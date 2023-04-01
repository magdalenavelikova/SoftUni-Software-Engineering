window.addEventListener("load", solve);

function solve() {
  const info = {
    title: null,
    category: null,
    postContent: null,
  };
  
  const inputDOMSelectors = {
    title: document.getElementById("post-title"),
    category: document.getElementById("post-category"),
    postContent: document.getElementById("post-content"),
  };

  const otherDOMSelectors = {
    publishBtn: document.getElementById("publish-btn"),
    review: document.getElementById("review-list"),
    published: document.getElementById("published-list"),
    clearBtn: document.getElementById("clear-btn"),
  };

  otherDOMSelectors.publishBtn.addEventListener("click", inPublishHandler);
  otherDOMSelectors.clearBtn.addEventListener("click", inClearHandler);

  function inPublishHandler(event) {
    if (event) {
      event.preventDefault();
    }

    const areValidInputsValues = Object.values(inputDOMSelectors).every(
      (input) => input.value != ""
    );
    if (!areValidInputsValues) {
      console.log("Empty Field!");
      return;
    }
    const { title, category, postContent } = inputDOMSelectors;

    const li = createElement("li", otherDOMSelectors.review, "", "", ["rpost"]);
    const article = createElement("article", li);
    createElement("h4", article, title.value);
    createElement("p", article, `Category: ${category.value}`);
    createElement("p", article, `Content: ${postContent.value}`);
    const editBtn = createElement("button", li, "Edit", "", [
      "action-btn",
      "edit",
    ]);
    const approveBtn = createElement("button", li, "Approve", "", [
      "action-btn",
      "approve",
    ]);
    for (const key in inputDOMSelectors) {
      info[key] = inputDOMSelectors[key].value;
    }
    clear();

    editBtn.addEventListener("click", inEditHandler);
    approveBtn.addEventListener("click", inApproveHandler);
  }

  function inEditHandler(event) {
    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = info[key];
    }
    event.target.parentElement.remove();
  }

  function inApproveHandler(event) {
    let html = event.target.parentElement.innerHTML;
    let editHtml = html.replace(
      '<button class="action-btn edit">Edit</button><button class="action-btn approve">Approve</button>',
      ""
    );
    let li = document.createElement("li");
    li.className = "rpost";
    li.innerHTML = editHtml;
    otherDOMSelectors.published.appendChild(li);
    event.target.parentElement.remove();
  }

  function inClearHandler(event) {
    otherDOMSelectors.published.innerHTML = " ";
  }

  function clear() {
    Object.values(inputDOMSelectors).forEach((input) => (input.value = ""));
  }

  function createElement(type, parent, content, id, classes, attributes) {
    //TYPE parse
    const element = document.createElement(type);

    //CONTENT Parse
    if (content) {
      if (type !== "input" && type !== "textarea") {
        element.textContent = content;
      } else {
        element.value = content;
      }
    }

    //ID Parse
    if (id) {
      element.setAttribute("id", id);
    }

    //CLASSES Parse
    if (classes) {
      for (const clazz of classes) {
        element.classList.add(clazz);
      }
    }

    //PARENT Parse
    if (parent) {
      parent.appendChild(element);
    }

    //ATTRIBUTES Parse
    if (attributes) {
      for (const key in attributes) {
        element.setAttribute(key, attributes[key]);
      }
    }
    return element;
  }
}
