const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

const host = 'http://localhost:3000'; // Application host (NOT service host - that can be anything)

const DEBUG = false;
const slowMo = 500;

const mockData = {
  catalog: [
    {
      author: 'J.K.Rowling',
      title: '.Harry Potter and the Philosopher Stone',
      _id: 'd953e5fb-a585-4d6b-92d3-ee90697398a0',
    },
    {
      author: 'Author2',
      title: 'Book2',
      _id: '1002',
    },
  ],
};

const endpoints = {
  catalog: '/jsonstore/collections/books',
  details: (id) => `/jsonstore/collections/books/${id}`,
  delete: (id) => `jsonstore/collections/books/${id}`,
};

let browser;
let context;
let page;

describe('E2E tests', function () {
  // Setup
  this.timeout(DEBUG ? 120000 : 7000);
  before(
    async () =>
    (browser = await chromium.launch(
      DEBUG ? { headless: false, slowMo } : {}
    ))
  );
  after(async () => await browser.close());
  beforeEach(async () => {
    context = await browser.newContext();
    setupContext(context);
    page = await context.newPage();
  });
  afterEach(async () => {
    await page.close();
    await context.close();
  });

  // Test proper
  describe('Book Library', () => {
    it('Load Books', async () => {
      const data = mockData.catalog;
      const { get } = await handle(endpoints.catalog);
      get(data);

      await page.goto(host);
      await page.waitForSelector('#loadBooks');

      await page.click('#loadBooks');

      const books = await page.$$eval(`tbody tr`, (t) =>
        t.map((s) => s.textContent)
      );

      expect(books.length).to.equal(data.length);
    });

    it('Check books info', async () => {
      const data = mockData.catalog;
      const { get } = await handle(endpoints.catalog);
      get(data);

      await page.goto(host);
      await page.waitForSelector('#loadBooks');

      await page.click('#loadBooks');

      const books = await page.$$eval(`tbody tr td`, (t) =>
        t.map((s) => s.textContent)
      );

      expect(books[0]).to.equal(data[0].title);
      expect(books[1]).to.equal(data[0].author);
    });

    it('Create Book', async () => {
      const data = mockData.catalog[0];
      await page.goto(host);

      const { post } = await handle(endpoints.catalog);
      const { onRequest } = post();

      await page.waitForSelector('#form');

      await page.fill('input[name="title"]', data.title + '1');
      await page.fill('input[name="author"]', data.author + '1');

      const [request] = await Promise.all([
        onRequest(),
        page.click('text=Submit'),
      ]);

      const postData = JSON.parse(request.postData());

      expect(postData.title).to.equal(data.title + '1');
      expect(postData.author).to.equal(data.author + '1');
    });

    it('Edit should populate form with correct data', async () => {
      const info = mockData.catalog;
      const data = mockData.catalog[0];
      await page.goto(host);

      const { get } = await handle(endpoints.catalog);
      get(info);

      await page.click('#loadBooks');

      const { get2 } = await handle(endpoints.details(data._id));
      get2(data);

      await page.click(`tr:has-text("${data.title}") >> text=Edit`);

      await page.waitForSelector('#form');

      const inputs = await page.$$eval('#form input', t => t.map(i => i.value));

      expect(inputs[0]).to.equal(data.title);
      expect(inputs[1]).to.equal(data.author);
    });
  });
});

async function setupContext(context) {
  // Catalog and Details
  await handleContext(context, endpoints.catalog, { get: mockData.catalog });
  await handleContext(context, endpoints.details('1001'), {
    get: mockData.catalog[0],
  });

  // Block external calls
  await context.route(
    (url) => url.href.slice(0, host.length) != host,
    (route) => {
      if (DEBUG) {
        console.log('Preventing external call to ' + route.request().url());
      }
      route.abort();
    }
  );
}

function handle(match, handlers) {
  return handleRaw.call(page, match, handlers);
}

function handleContext(context, match, handlers) {
  return handleRaw.call(context, match, handlers);
}

async function handleRaw(match, handlers) {
  const methodHandlers = {};
  const result = {
    get: (returns, options) => request('GET', returns, options),
    get2: (returns, options) => request('GET', returns, options),
    post: (returns, options) => request('POST', returns, options),
    put: (returns, options) => request('PUT', returns, options),
    patch: (returns, options) => request('PATCH', returns, options),
    del: (returns, options) => request('DELETE', returns, options),
    delete: (returns, options) => request('DELETE', returns, options),
  };

  const context = this;

  await context.route(urlPredicate, (route, request) => {
    if (DEBUG) {
      console.log('>>>', request.method(), request.url());
    }

    const handler = methodHandlers[request.method().toLowerCase()];
    if (handler == undefined) {
      route.continue();
    } else {
      handler(route, request);
    }
  });

  if (handlers) {
    for (let method in handlers) {
      if (typeof handlers[method] == 'function') {
        handlers[method](result[method]);
      } else {
        result[method](handlers[method]);
      }
    }
  }

  return result;

  function request(method, returns, options) {
    let handled = false;

    methodHandlers[method.toLowerCase()] = (route, request) => {
      handled = true;
      route.fulfill(respond(returns, options));
    };

    return {
      onRequest: () => context.waitForRequest(urlPredicate),
      onResponse: () => context.waitForResponse(urlPredicate),
      isHandled: () => handled,
    };
  }

  function urlPredicate(current) {
    if (current instanceof URL) {
      return current.href.toLowerCase().includes(match.toLowerCase());
    } else {
      return current.url().toLowerCase().includes(match.toLowerCase());
    }
  }
}

function respond(data, options = {}) {
  options = Object.assign(
    {
      json: true,
      status: 200,
    },
    options
  );

  const headers = {
    'Access-Control-Allow-Origin': '*',
  };
  if (options.json) {
    headers['Content-Type'] = 'application/json';
    data = JSON.stringify(data);
  }

  return {
    status: options.status,
    headers,
    body: data,
  };
}
