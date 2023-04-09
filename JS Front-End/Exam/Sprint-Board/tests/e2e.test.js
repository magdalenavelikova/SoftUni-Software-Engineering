const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

const host = 'http://localhost:3000'; // Application host (NOT service host - that can be anything)

const DEBUG = false;
const slowMo = 500;

const mockData = {
  list: [
    {
      title: 'Bug 1',
      description: 'My first bug',
      status: 'ToDo',
      _id: '1001',
    },
    {
      title: 'Bug 2',
      description: 'My second bug',
      status: 'In Progress',
      _id: '1002',
    },
    {
      title: 'Bug 3',
      description: 'My third bug',
      status: 'Code Review',
      _id: '1003',
    },
    {
      title: 'Bug 4',
      description: 'My fourth bug',
      status: 'Done',
      _id: '1004',
    },
  ],
};

const endpoints = {
  catalog: '/jsonstore/tasks',
  byId: (id) => `/jsonstore/tasks/${id}`,
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

  describe('Sprint Board Tests', () => {
    it('Load Board (loads all in correct categories)', async () => {
      const data = mockData.list;
      const [ firstTask, secondTask, thirdTask, fourthTask ] = data;
      const { get } = await handle(endpoints.catalog);
      get(data);

      await page.goto(host);
      await page.waitForSelector('#load-board-btn');

      await page.click('#load-board-btn');

      const [ todoTask ] = await page.$$eval(`#todo-section li`, (t) =>
        t.map((s) => s.textContent)
      );
      const [ inProgressTask ] = await page.$$eval(`#in-progress-section li`, (t) =>
        t.map((s) => s.textContent)
      );
      const [ codeReviewTask ] = await page.$$eval(`#code-review-section li`, (t) =>
        t.map((s) => s.textContent)
      );
      const [ doneTask ] = await page.$$eval(`#done-section li`, (t) =>
        t.map((s) => s.textContent)
      );

      expect(todoTask).to.equal(`${firstTask.title}${firstTask.description}Move to In Progress`);
      expect(inProgressTask).to.equal(`${secondTask.title}${secondTask.description}Move to Code Review`);
      expect(codeReviewTask).to.equal(`${thirdTask.title}${thirdTask.description}Move to Done`);
      expect(doneTask).to.equal(`${fourthTask.title}${fourthTask.description}Close`);
    });

    it('Create Task (successful create & clear inputs)', async () => {
      const data = mockData.list[0];
      await page.goto(host);

      const { post } = await handle(endpoints.catalog);
      const { onRequest } = post();

      await page.waitForSelector('#title');
      await page.waitForSelector('#description');

      await page.fill('#title', data.title + '1');
      await page.fill('#description', data.description + '1');

      const [request] = await Promise.all([
        onRequest(),
        page.click('#create-task-btn'),
      ]);

      const postData = JSON.parse(request.postData());

      const [ titleValue ] = await page.$$eval(`#title`, (t) =>
        t.map((s) => s.value)
      );
      const [ descriptionValue ] = await page.$$eval(`#description`, (t) =>
        t.map((s) => s.value)
      );

      expect(postData.title).to.equal(data.title + '1');
      expect(postData.description).to.equal(data.description + '1');
      expect(titleValue).to.equal('');
      expect(descriptionValue).to.equal('');
    });
    
    it('Move Task (from ToDo to In Progress)', async () => {
      const data = mockData.list[0];
      await page.goto(host);
      const { patch } = await handle(endpoints.byId(data._id));
      const { onRequest } = patch({ id: data._id });

      await page.click('#load-board-btn');
      await page.waitForSelector('#todo-section li button');
      const [request] = await Promise.all([
        onRequest(),
        page.click('#todo-section li button'),
      ]);

      const postData = JSON.parse(request.postData());

      expect(postData.status).to.equal('In Progress');
    });

    it('Move Task (from In Progress to Code Review)', async () => {
      const data = mockData.list[1];
      await page.goto(host);
      const { patch } = await handle(endpoints.byId(data._id));
      const { onRequest } = patch({ id: data._id });

      await page.click('#load-board-btn');
      await page.waitForSelector('#in-progress-section li button');
      const [request] = await Promise.all([
        onRequest(),
        page.click('#in-progress-section li button'),
      ]);

      const postData = JSON.parse(request.postData());

      expect(postData.status).to.equal('Code Review');
    });

    it('Move Task (from Code Review to Done)', async () => {
      const data = mockData.list[2];
      await page.goto(host);
      const { patch } = await handle(endpoints.byId(data._id));
      const { onRequest } = patch({ id: data._id });

      await page.click('#load-board-btn');
      await page.waitForSelector('#code-review-section li button');
      const [request] = await Promise.all([
        onRequest(),
        page.click('#code-review-section li button'),
      ]);

      const postData = JSON.parse(request.postData());

      expect(postData.status).to.equal('Done');
    });

    it('Close Task', async () => {
      const data = mockData.list[3];
      await page.goto(host);
      const { del } = await handle(endpoints.byId(data._id));
      const { onResponse, isHandled } = del({ id: data._id });

      await page.click('#load-board-btn');

      await page.waitForSelector('#done-section li button');

      await Promise.all([
        onResponse(),
        page.click(
          '#done-section li button'
        ),
      ]);

      expect(isHandled()).to.be.true;
    });
  });
});

async function setupContext(context) {
  // Catalog and Details
  await handleContext(context, endpoints.catalog, { get: mockData.list });
  await handleContext(context, endpoints.catalog, { post: mockData.list[0] });

  await handleContext(context, endpoints.byId('1001'), {
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
  });``

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
