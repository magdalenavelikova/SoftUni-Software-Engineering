const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

const host = 'http://localhost:3000'; // Application host (NOT service host - that can be anything)

const DEBUG = false;
const slowMo = 500;

const mockData = {
  list: [
    {
      firstName: 'Isaac',
      lastName: 'Netero',
      facultyNumber: '90000587896',
      grade: 4.99,
      _id: '1001',
    },
    {
      firstName: 'Nvy',
      lastName: 'Ose',
      facultyNumber: '90000123456',
      grade: 6,
      _id: '1002',
    },
  ],
};

const endpoints = {
  catalog: '/jsonstore/collections/students',
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
  describe('Students', () => {
    it('Load Students', async () => {
      const data = mockData.list;
      const { get } = await handle(endpoints.catalog);
      get(data);

      await page.goto(host);
      await page.waitForSelector('tbody>tr');

      const students = await page.$$eval(`tbody tr`, (t) =>
        t.map((s) => s.textContent)
      );

      expect(students.length).to.equal(data.length);
    });

    it('Check first name', async () => {
      const data = mockData.list[0];
      await page.goto(host);

      const { post } = await handle(endpoints.catalog);
      const { onRequest } = post();

      await page.waitForSelector('.inputs');

      await page.fill('input[name="firstName"]', data.firstName + '1');
      await page.fill('input[name="lastName"]', data.lastName + '1');
      await page.fill('input[name="facultyNumber"]', data.facultyNumber + '1');
      await page.fill('input[name="grade"]', data.grade + '1');

      const [request] = await Promise.all([onRequest(), page.click('#submit')]);

      const postData = JSON.parse(request.postData());

      expect(postData.firstName).to.equal(data.firstName + '1');
    });

    it('Check last name', async () => {
      const data = mockData.list[0];
      await page.goto(host);

      const { post } = await handle(endpoints.catalog);
      const { onRequest } = post();

      await page.waitForSelector('.inputs');

      await page.fill('input[name="firstName"]', data.firstName + '1');
      await page.fill('input[name="lastName"]', data.lastName + '1');
      await page.fill('input[name="facultyNumber"]', data.facultyNumber + '1');
      await page.fill('input[name="grade"]', data.grade + '1');

      const [request] = await Promise.all([onRequest(), page.click('#submit')]);

      const postData = JSON.parse(request.postData());

      expect(postData.lastName).to.equal(data.lastName + '1');
    });

    it('Check faculty number', async () => {
      const data = mockData.list[0];
      await page.goto(host);

      const { post } = await handle(endpoints.catalog);
      const { onRequest } = post();

      await page.waitForSelector('.inputs');

      await page.fill('input[name="firstName"]', data.firstName + '1');
      await page.fill('input[name="lastName"]', data.lastName + '1');
      await page.fill('input[name="facultyNumber"]', data.facultyNumber + '1');
      await page.fill('input[name="grade"]', data.grade + '1');

      const [request] = await Promise.all([onRequest(), page.click('#submit')]);

      const postData = JSON.parse(request.postData());

      expect(postData.facultyNumber).to.equal(data.facultyNumber + '1');
    });

    it('Check grade', async () => {
      const data = mockData.list[0];
      await page.goto(host);

      const { post } = await handle(endpoints.catalog);
      const { onRequest } = post();

      await page.waitForSelector('.inputs');

      await page.fill('input[name="firstName"]', data.firstName + '1');
      await page.fill('input[name="lastName"]', data.lastName + '1');
      await page.fill('input[name="facultyNumber"]', data.facultyNumber + '1');
      await page.fill('input[name="grade"]', data.grade + '1');

      const [request] = await Promise.all([onRequest(), page.click('#submit')]);

      const postData = JSON.parse(request.postData());

      expect(postData.grade).to.equal(data.grade + '1');
    });
  });
});

async function setupContext(context) {
  // Catalog and Details
  await handleContext(context, endpoints.catalog, { get: mockData.list });
  await handleContext(context, endpoints.catalog, { post: mockData.list[0] });

  await handleContext(context, endpoints.delete('1001'), {
    get: mockData.list[0],
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
