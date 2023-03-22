const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

const host = 'http://localhost:' + 3000; // Application host (NOT service host - that can be anything)

const DEBUG = false;
const slowMo = 500;

const mockData = {
  list: [
    {
      _id: 'depot',
      next: '0361',
      name: 'Depot',
    },
    {
      _id: '0361',
      next: '1931',
      name: 'Krasna Polyana',
    },
    {
      _id: '1931',
      next: '2571',
      name: 'Agriculture High School',
    },
  ],
};

const endpoints = {
  catalog: (id) => `/jsonstore/bus/schedule/${id}`,
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
    it('Click Depart button', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#depart');

      await page.click('[value="Depart"]');

      await page.waitForSelector('.info');

      const search = await page.$$eval(`.info`, (t) =>
        t.map((s) => s.textContent)
      );

      await page.waitForSelector('.info');
      expect(`Next stop ${search[0]}`).to.contains(data.name);
    });

    it('Click Depart and Arrive button', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#depart');

      await page.click('[value="Depart"]');

      await page.waitForSelector('#arrive');

      await page.click('[value="Arrive"]');

      const search = await page.$$eval(`.info`, (t) =>
        t.map((s) => s.textContent)
      );

      await page.waitForSelector('.info');
      expect(`Arriving at ${search[0]}`).to.contains(data.name);
    });

    it('Check if depart button is disabled before click on it', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#depart');

      const search = await page.$$eval(`#depart`, (t) =>
        t.map((s) => s.disabled)
      );

      await page.waitForSelector('#depart');
      expect(search[0]).to.be.false;
    });

    it('Check if depart button is disabled after click on it', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#depart');

      await page.click('[value="Depart"]');

      await page.waitForSelector('#depart');

      const search = await page.$$eval(`#depart`, (t) =>
        t.map((s) => s.disabled)
      );

      await page.waitForSelector('#depart');
      expect(search[0]).to.be.true;
    });

    it('Check if arrive button is disabled before click on it', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#depart');

      await page.click('[value="Depart"]');

      await page.waitForSelector('#arrive');

      const search = await page.$$eval(`#arrive`, (t) =>
        t.map((s) => s.disabled)
      );

      await page.waitForSelector('#arrive');
      expect(search[0]).to.be.false;
    });

    it('Check if arrive button is disabled after click on it', async () => {
      await page.goto(host);
      const data = mockData.list[0];
      const { get } = await handle(endpoints.catalog(data._id));
      get(data);
      await page.waitForSelector('#depart');

      await page.click('[value="Depart"]');

      await page.waitForSelector('#arrive');

      await page.click('[value="Arrive"]');

      const search = await page.$$eval(`#arrive`, (t) =>
        t.map((s) => s.disabled)
      );

      await page.waitForSelector('#arrive');
      expect(search[0]).to.be.true;
    });
  });
});

async function setupContext(context) {
  // Catalog and Details
  await handleContext(context, endpoints.catalog, { get: mockData.catalog });

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
