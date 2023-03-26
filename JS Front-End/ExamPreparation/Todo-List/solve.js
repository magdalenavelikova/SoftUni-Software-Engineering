// TODO
const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

const list = document.getElementById("todo-list");
const input = document.getElementById("title");

function attachEvents() {
  document.getElementById("load-button").addEventListener("click", loadAll);
  document.getElementById("add-button").addEventListener("click", saveRecord);
}

function loadAll(ev) {
  ev.preventDefault();
list.innerHTML="";
  fetch(BASE_URL)
    .then((result) => result.json())
    .then((data) => {
      Object.entries(data).forEach((obj) => {
        let li = createLi(obj[0], obj[1]);
        list.appendChild(li);
      });
    });
}

function editRecord(event) {
  let id = this.id;
  let span = event.target.parentElement.firstChild;
  let inputElement = document.createElement("input");
  inputElement.value = span.textContent;

  event.target.parentElement.removeChild(span);
  event.target.parentElement.prepend(inputElement);
  event.target.parentElement.lastChild.textContent = "Submit";
    
  let urlEdit = `${BASE_URL}${id}`;
  event.target.parentElement.lastChild.addEventListener("click", function () {
    if (typeof inputElement.value !== "string" || inputElement.value.length == 0) {
      return;
    }
    fetch(urlEdit, {
      method: "PATCH",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: inputElement.value,
      }),
    }).then(() => loadAll(event));
  });
}

function saveRecord(event) {
  
  if (typeof input.value !== "string" || input.value.length == 0) {
    return;
  }
  fetch(BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      name: input.value,
    }),
  }).then(() => loadAll(event));
  input.value = "";
}

function deleteRecord(event) {
  let id = this.id;
  let urlDelete = `${BASE_URL}${id}`;
  fetch(urlDelete, {
    method: "DELETE",
  }).then(() => loadAll(event));
}

 function createLi(key, obj) {
  let li = document.createElement("li");
  let span = document.createElement("span");
  span.textContent = obj.name;
  let editBtn = document.createElement("button");
  editBtn.textContent = "Edit";
  editBtn.id = key;
  editBtn.addEventListener("click", editRecord);
  let deleteBtn = document.createElement("button");
  deleteBtn.textContent = "Remove";
  deleteBtn.id = key;
  deleteBtn.addEventListener("click", deleteRecord);
  li.appendChild(span);
  li.appendChild(deleteBtn);
  li.appendChild(editBtn);
  return  li;
}

attachEvents();
