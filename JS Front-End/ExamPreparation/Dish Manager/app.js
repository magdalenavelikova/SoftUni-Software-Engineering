window.addEventListener("load", solve);

function solve() {
  const info = {
    firstName: null,
    lastName: null,
    age: null,
    genre: null,
    task: null,
  };
  const inputDOMSelectors = {
    firstName: document.getElementById("first-name"),
    lastName: document.getElementById("last-name"),
    age: document.getElementById("age"),
    genre: document.getElementById("genderSelect"),
    task: document.getElementById("task"),
  };
  const otherDOMSelectors = {
    submitBtn: document.getElementById("form-btn"),
    clearBtn: document.getElementById("clear-btn"),
    inProgress: document.getElementById("in-progress"),
    counter: document.getElementById("progress-count"),
    finished: document.getElementById("finished"),
  };
  let counter = 0;
  otherDOMSelectors.submitBtn.addEventListener("click", inProgressHandler);
  otherDOMSelectors.clearBtn.addEventListener("click", inClearHandler);
  function inProgressHandler(event) {
    event.preventDefault();
    const areValidInputsValues = Object.values(inputDOMSelectors).every(
      (input) => input.value != ""
    );

    if (!areValidInputsValues) {
      console.log("Empty Field!");
      return;
    }
    const { firstName, lastName, age, genre, task } = inputDOMSelectors;

    const li = createElement("li", otherDOMSelectors.inProgress, "", "", [
      "each-line",
    ]);
    const article = createElement("article", li);
    createElement("h4", article, `${firstName.value} ${lastName.value}`);
    createElement("p", article, `${genre.value}, ${age.value}`);
    createElement("p", article, `Dish description: ${task.value}`);
    const editBtn = createElement("button", li, "Edit", "", ["edit-btn"]);
    editBtn.addEventListener("click", inEditHandler);
    const completeBtn = createElement("button", li, "Mark as complete", "", [
      "complete-btn",
    ]);
    completeBtn.addEventListener("click", inFinishedHandler);

    for (const key in inputDOMSelectors) {
      info[key] = inputDOMSelectors[key].value;
    }
    counter++;
    otherDOMSelectors.counter.textContent = counter;
    clear();
  }
  function inEditHandler(event) {
    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = info[key];
    }
    event.target.parentElement.remove();
    counter--;
    otherDOMSelectors.counter.textContent = counter;
  }
  function inFinishedHandler(event) {
    let html = event.target.parentElement.innerHTML;
    let editHtml = html.replace(
      '<button class="edit-btn">Edit</button><button class="complete-btn">Mark as complete</button>',
      ""
    );
    let li = document.createElement("li");
    li.className="each-line"
    li.innerHTML = editHtml;
    otherDOMSelectors.finished.appendChild(li);
    event.target.parentElement.remove();
    counter--;
    otherDOMSelectors.counter.textContent = counter;
  }
  function inClearHandler(event) {
    otherDOMSelectors.finished.innerHTML=" ";
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
