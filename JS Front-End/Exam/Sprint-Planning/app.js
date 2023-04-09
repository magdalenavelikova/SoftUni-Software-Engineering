window.addEventListener("load", solve);

function solve() {
  let counter = 0;
  let totalPoints = 0;
  const mapOfTask = new Map();
  let domForDelete;
  const info = {
    id: null,
    title: null,
    description: null,
    label: null,
    points: null,
    assignee: null,
  };
  const inputDOMSelectors = {
    id: document.getElementById("task-id"),
    title: document.getElementById("title"),
    description: document.getElementById("description"),
    label: document.getElementById("label"),
    points: document.getElementById("points"),
    assignee: document.getElementById("assignee"),
  };
  const otherDOMSelectors = {
    createBtn: document.getElementById("create-task-btn"),
    section: document.getElementById("tasks-section"),
    totalPoints: document.getElementById("total-sprint-points"),
    deleteTaskBtn: document.getElementById("delete-task-btn"),
    //  finished: document.getElementById("finished"),
  };

  otherDOMSelectors.createBtn.addEventListener("click", inCreateHandler);
  otherDOMSelectors.deleteTaskBtn.addEventListener(
    "click",
    inDeleteTaskHandler
  );

  function inCreateHandler(event) {
    event.preventDefault();
    counter++;
    const { id, title, description, label, points, assignee } =
      inputDOMSelectors;
    id.value = counter;
    const areValidInputsValues = Object.values(inputDOMSelectors).every(
      (input) => input.value != ""
    );

    if (!areValidInputsValues) {
      console.log("Empty Field!");
      return;
    }

    const article = createElement(
      "article",
      otherDOMSelectors.section,
      "",
      `task-${id.value}`,
      ["task-card"]
    );

    if (label.value === "Feature") {
      let div = createElement("div", article, "", "", [
        "task-card-label",
        "feature",
      ]);
      div.innerHTML = "Feature &#8865";
    } else if (label.value === "Low Priority Bug") {
      let div = createElement("div", article, "", "", [
        "task-card-label",
        "low-priority",
      ]);
      div.innerHTML = "Low Priority Bug &#9737";
    } else if (label.value === "High Priority Bug") {
      let div = createElement("div", article, "", "", [
        "task-card-label",
        "high-priority",
      ]);
      div.innerHTML = "High Priority Bug &#9888";
    }

    createElement("h3", article, title.value, "", ["task-card-title"]);
    createElement("p", article, description.value, "", [
      "task-card-description",
    ]);
    createElement("div", article, `Estimated at ${points.value} pts`, "", [
      "task-card-points",
    ]);
    totalPoints += Number(points.value);

    createElement("div", article, `Assigned to: ${assignee.value}`, "", [
      "task-card-assignee",
    ]);
    let div = createElement("div", article, "", "", ["task-card-actions"]);

    const deleteBtn = createElement("button", div, "Delete");

    deleteBtn.addEventListener("click", inDeleteHandler);

    for (const key in inputDOMSelectors) {
      info[key] = inputDOMSelectors[key].value;
    }
    mapOfTask.set(id.value, info);

    otherDOMSelectors.totalPoints.textContent = `Total Points ${totalPoints}pts`;
    clear();
  }
  function  inDeleteTaskHandler(){
domForDelete.remove();
Object.values(inputDOMSelectors).forEach(
    (input) =>{
        (input.value = "");
        (input.disabled = "")

    } 
  );
  otherDOMSelectors.createBtn.disabled = "";
    otherDOMSelectors.deleteTaskBtn.disabled = "true";

  }

  function inDeleteHandler(event) {
    let content = event.target.parentElement.parentElement.id;
    console.log(content);
    let text = content.split("-");
    let id = text[1];
    console.log(id);
    let objForDelete=mapOfTask.get(id);
    console.log(objForDelete);
    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = objForDelete[key];
    }
    domForDelete=event.target.parentElement.parentElement;
    counter--;
    totalPoints -= Number(info.points);
    otherDOMSelectors.totalPoints.textContent = `Total Points ${totalPoints}pts`;
    Object.values(inputDOMSelectors).forEach(
      (input) => (input.disabled = "true")
    );
    otherDOMSelectors.createBtn.disabled = "true";
    otherDOMSelectors.deleteTaskBtn.disabled = "";
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
