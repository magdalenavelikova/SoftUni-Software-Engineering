const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

const host = 'http://localhost:3000'; // Application host (NOT service host - that can be anything)

const DEBUG = false;
const slowMo = 500;

const mockData = {
  location: [
    {
      code: 'ny',
      name: 'New York',
    },
  ],
  today: [
    {
      forecast: {
        condition: 'Sunny',
        high: '19',
        low: '8',
      },
      name: 'New York, USA',
    },
  ],
  upcomming: [
    {
      forecast: [
        {
          condition: 'Partly sunny',
          high: '17',
          low: '6',
        },
        {
          condition: 'Overcast',
          high: '9',
          low: '3',
        },
        {
          condition: 'Overcast',
          high: '7',
          low: '3',
        },
      ],
      name: 'New York',
    },
  ],
};

const endpoints = {
  locations: '/jsonstore/forecaster/locations',
  today: (code) => `/jsonstore/forecaster/today/${code}`,
  upcommig: (code) => `/jsonstore/forecaster/upcoming/${code}`,
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
  describe('Forecaster', () => {
    it('Search location', async () => {
      const data = mockData.location;
      const city = mockData.today[0];
      const { get } = await handle(endpoints.locations);
      get(data);

      await page.goto(host);
      await page.waitForSelector('#location');

      await page.fill('#location', `${data[0].name}`);
      await page.click('input[type="button"]');

      const { get2 } = await handle(endpoints.today(`${data.code}`));
      get2(city);
      await page.waitForSelector('.forecast-data');

      const info = await page.$$eval(
        `#current .condition .forecast-data`,
        (t) => t.map((s) => s.textContent)
      );
      await page.waitForSelector('.forecast-data');

      expect(info[0]).to.equal(city.name);
    });

    it('Check current condition info', async () => {
      const data = mockData.location;
      const city = mockData.today[0];
      const { get } = await handle(endpoints.locations);
      get(data);

      await page.goto(host);
      await page.waitForSelector('#location');

      await page.fill('#location', `${data[0].name}`);
      await page.click('input[type="button"]');
      await page.waitForSelector('.forecast-data');

      const { get2 } = await handle(endpoints.today(`${data.code}`));
      get2(city);

      const info = await page.$$eval(
        `#current .condition .forecast-data`,
        (t) => t.map((s) => s.textContent)
      );
      await page.waitForSelector('.forecast-data');

      expect(info[0]).to.equal(city.name);
      expect(info[1]).to.equal(`${city.forecast.low}°/${city.forecast.high}°`);
      expect(info[2]).to.equal(city.forecast.condition);
    });

    it('Check upcomming days', async () => {
      const data = mockData.location;
      const city = mockData.upcomming[0];
      const { get } = await handle(endpoints.locations);
      get(data);

      await page.goto(host);
      await page.waitForSelector('#location');

      await page.fill('#location', `${data[0].name}`);
      await page.click('input[type="button"]');

      const { get2 } = await handle(endpoints.upcommig(`${data.code}`));
      get2(city);
      await page.waitForSelector('.upcoming');

      const info = await page.$$eval(
        `#upcoming .forecast-info .upcoming`,
        (t) => t.map((s) => s.textContent)
      );
      await page.waitForSelector('.upcoming');

      expect(info.length).to.equal(city.forecast.length);
    });

    it('Check upcoming day info', async () => {
      const data = mockData.location;
      const city = mockData.upcomming[0];
      const { get } = await handle(endpoints.locations);
      get(data);

      await page.goto(host);
      await page.waitForSelector('#location');

      await page.fill('#location', `${data[0].name}`);
      await page.click('input[type="button"]');

      const { get2 } = await handle(endpoints.upcommig(`${data.code}`));
      get2(city);
      await page.waitForSelector('.forecast-data');

      const info = await page.$$eval(
        `#upcoming .forecast-info .upcoming .forecast-data`,
        (t) => t.map((s) => s.textContent)
      );
      await page.waitForSelector('.forecast-data');

      expect(info[0]).to.equal(
        `${city.forecast[0].low}°/${city.forecast[0].high}°`
      );
      expect(info[1]).to.equal(city.forecast[0].condition);
    });
  });
});

async function setupContext(context) {
  // Catalog and Details
  await handleContext(context, endpoints.locations, { get: mockData.location });
  await handleContext(context, endpoints.today('ny'), {
    get: mockData.today[0],
  });
  await handleContext(context, endpoints.upcommig('ny'), {
    get: mockData.upcomming[0],
  });

  await handleContext(context, endpoints.details('1001'), {
    get: mockData.catalog[0],
  });
  await handleContext(context, endpoints.details('1002'), {
    get: mockData.catalog[1],
  });
  await handleContext(context, endpoints.details('1003'), {
    get: mockData.catalog[2],
  });

  await handleContext(
    endpoints.profile('0001'),
    { get: mockData.catalog.slice(0, 2) },
    context
  );

  await handleContext(endpoints.total('1001'), { get: 6 }, context);
  await handleContext(endpoints.total('1002'), { get: 4 }, context);
  await handleContext(endpoints.total('1003'), { get: 7 }, context);

  await handleContext(endpoints.own('1001', '0001'), { get: 1 }, context);
  await handleContext(endpoints.own('1002', '0001'), { get: 0 }, context);
  await handleContext(endpoints.own('1003', '0001'), { get: 0 }, context);

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
