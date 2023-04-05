function solve() {
  let totalSalary = 0;
  const info = {
    firstName: null,
    lastName: null,
    email: null,
    birth: null,
    position: null,
    salary: null,
  };
  const inputDOMSelectors = {
    firstName: document.getElementById("fname"),
    lastName: document.getElementById("lname"),
    email: document.getElementById("email"),
    birth: document.getElementById("birth"),
    position: document.getElementById("position"),
    salary: document.getElementById("salary"),
  };
  const otherDOMSelectors = {
    addBtn: document.getElementById("add-worker"),
    budget: document.getElementById("sum"),
    // inProgress: document.getElementById("in-progress"),
    // counter: document.getElementById("progress-count"),
    tbody: document.getElementById("tbody"),
  };
  otherDOMSelectors.addBtn.addEventListener("click", add);

  function add(ev) {
    if (ev) {
      ev.preventDefault();
    }
    const areValidInputsValues = Object.values(inputDOMSelectors).every(
      (input) => input.value != ""
    );

    if (!areValidInputsValues) {
      console.log("Empty Field!");
      return;
    }
    const { firstName, lastName, email, birth, position, salary } =
      inputDOMSelectors;

    const tr = createElement("tr",  otherDOMSelectors.tbody);
    createElement("td", tr, firstName.value);
    createElement("td", tr, lastName.value);
    createElement("td", tr, email.value);
    createElement("td", tr, birth.value);
    createElement("td", tr, position.value);
    createElement("td", tr, salary.value);
    let td = createElement("td", tr);
    const firedBtn = createElement("button", td, "Fired", "", ["fired"]);
    firedBtn.addEventListener("click", inFiredHandler);
    const editBtn = createElement("button", td, "Edit", "", ["edit"]);
    editBtn.addEventListener("click", inEditHandler);
    totalSalary += Number(salary.value);
    otherDOMSelectors.budget.textContent = totalSalary.toFixed(2);

    for (const key in inputDOMSelectors) {
      info[key] = inputDOMSelectors[key].value;
    }
    clear();
  }
  function inFiredHandler(event) {
    totalSalary -= Number(info.salary);
    otherDOMSelectors.budget.textContent = totalSalary.toFixed(2);
    event.target.parentElement.parentElement.remove();
  }

  function inEditHandler(event) {
    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = info[key];
    }
    totalSalary -= Number(info.salary);
    otherDOMSelectors.budget.textContent = totalSalary.toFixed(2);
    event.target.parentElement.parentElement.remove();
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

  function clear() {
    Object.values(inputDOMSelectors).forEach((input) => (input.value = ""));
  }
}

solve();
