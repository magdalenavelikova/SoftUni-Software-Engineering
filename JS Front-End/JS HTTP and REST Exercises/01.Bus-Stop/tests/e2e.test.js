const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

const host = 'http://localhost:' + 3000; // Application host (NOT service host - that can be anything)

const DEBUG = false;
const slowMo = 500;

const mockData = {
  list: [
    {
      _id: '1287',
      buses: { 76: 15, 84: 10, 204: 10, 213: 18, 280: 9, 306: 31, 604: 11 },
      name: 'Orlov Most sq.',
    },
    {
      _id: '1308',
      buses: { 4: 13, 12: 6, 18: 7 },
      name: 'St. Nedelya sq.',
    },
    {
      _id: '1327',
      buses: { 78: 18, 85: 20, 213: 18, 285: 20, 305: 18, 404: 18, 413: 16 },
      name: 'Central Train Station sq.',
    },
    {
      _id: '2334',
      buses: { 20: 11, 22: 4 },
      name: 'Centralni Hali',
    },
  ],
};

const endpoints = {
  catalog: (id) => `/jsonstore/bus/businfo/${id}`,
};

let browser;
let page;

describe('E2E tests', function () {
  this.timeout(6000);

  before(async () => {
    browser = await chromium.launch(DEBUG ? { headless: false, slowMo } : {});
  });
  after(async () => {
    await browser.close();
  });
  beforeEach(async () => {
    page = await browser.newPage();
  });
  afterEach(async () => {
    await page.close();
  });

  describe('List', () => {
    it('Show bus stop name', async () => {
      await page.goto(host);
      const data = mockData.list[3];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#stopId');

      await page.fill('[type="text"]', data._id);
      await page.click('[type="button"]');

      await page.waitForSelector('#stopName');

      const search = await page.$$eval(`#stopName`, (t) =>
        t.map((s) => s.textContent)
      );
      await page.waitForSelector('#buses>li');
      expect(search[0]).to.contains(data.name);
    });

    it('Match bus stops length', async () => {
      await page.goto(host);
      const data = mockData.list[3];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#stopId');

      await page.fill('[type="text"]', data._id);
      await page.click('[type="button"]');

      await page.waitForSelector('#stopName');

      const stops = await page.$$eval(`#buses li`, (t) =>
        t.map((s) => s.textContent)
      );
      await page.waitForSelector('#buses>li');

      expect(stops.length).to.equal(2);
    });

    it('Match bus stops length with wrong ID', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#stopId');

      await page.fill('[type="text"]', '1000');
      await page.click('[type="button"]');

      await page.waitForSelector('#stopName');

      const stops = await page.$$eval(`#buses li`, (t) =>
        t.map((s) => s.textContent)
      );
      await page.waitForSelector('#stopName');

      expect(stops.length).to.equal(0);
    });

    it('Show error with wrong ID', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#stopId');

      await page.fill('[type="text"]', '1000');
      await page.click('[type="button"]');

      await page.waitForSelector('#stopName');

      const search = await page.$$eval(`#stopName`, (t) =>
        t.map((s) => s.textContent)
      );

      await page.waitForSelector('#stopName');

      expect(search[0]).to.contains('Error');
    });
  });
});

async function setupContext(context) {
  // Catalog and Details
  await handleContext(context, endpoints.catalog, { get: mockData.list });

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
