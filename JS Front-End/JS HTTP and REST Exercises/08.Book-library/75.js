let baseUrl = "http://localhost:3030/jsonstore/collections/books";
let tbody = document.querySelector("tbody");
let inputTitle = document.querySelector("[name='title']");
let inputAuthor = document.querySelector("[name='author']");
let id = "";
let submitBtn = document.querySelector("#form button");
let h3 = document.querySelector("#form h3");
let form = document.getElementById("form");

function attachEvents() {
  document.getElementById("loadBooks").addEventListener("click", loadAll);
  submitBtn.addEventListener("click", save);
  window.addEventListener("load", clear);
}
function clear() {
  tbody.replaceChildren();
  
}
async function loadAll() {
  clear();
  try {
    const response = await fetch(baseUrl);
    if (!response.ok) {
      throw new Error(response.statusText);
    }
    const data = await response.json();
    Object.entries(data).forEach((obj) => {
      let tr = createTr(obj[0], obj[1]);
      tbody.appendChild(tr);
    });
  } catch (error) {
    alert(error);
  }
}

function edit(ev) {
  submitBtn.style.display = "none";
  let editBtn = document.createElement("button");
  editBtn.textContent = "Save";
  form.appendChild(editBtn);
  id = ev.target.id;
  h3.textContent = "Edit FORM";
  inputTitle.value =
    ev.target.parentElement.parentElement.children[0].textContent;
  inputAuthor.value =
    ev.target.parentElement.parentElement.children[1].textContent;
  editBtn.addEventListener("click", editRecord);
}


async function editRecord(ev) {
  ev.target.style.display = "none";
  if (!inputTitle.value || !inputAuthor.value) {
    alert("Please fill all fields");
  } else {
    let urlToken = `${baseUrl}/${id}`;
    try {
      let response = await fetch(urlToken, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          title: inputTitle.value.trim(),
          author: inputAuthor.value.trim(),
        }),
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      submitBtn.style.display = "";
      loadAll();
      return await response.json();
    } catch (error) {
      alert(error);
    }
  }
}

async function save(ev) {
  if (!inputTitle.value.trim() || !inputAuthor.value.trim()) {
    alert("Please fill all fields");
  } else {
    try {
      let response = await fetch(baseUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          title: inputTitle.value.trim(),
          author: inputAuthor.value.trim(),
        }),
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }
      h3.textContent = "FORM";

      loadAll();
      return await response.json;
    } catch (error) {
      alert(error);
    }
  }
}

async function deleteRecord(ev) {
  let urlToken = `${baseUrl}/${ev.target.id}`;
  try {
    let response = await fetch(urlToken, {
      method: "DELETE",
    });
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    ev.target.parentElement.parentElement.remove();

    return await response.json();
  } catch (error) {
    alert(error);
  }
}

function createTr(key, obj) {
  let tr = document.createElement("tr");
  let tdBook = document.createElement("td");
  tdBook.textContent = obj.title;
  let tdAuthor = document.createElement("td");
  tdAuthor.textContent = obj.author;
  let tdBtn = document.createElement("td");
  let editBtn = document.createElement("button");
  editBtn.textContent = "Edit";
  editBtn.id = key;
  editBtn.addEventListener("click", edit);
  tdBtn.appendChild(editBtn);
  let deleteBtn = document.createElement("button");
  deleteBtn.textContent = "Delete";
  deleteBtn.id = key;
  deleteBtn.addEventListener("click", deleteRecord);
  tdBtn.appendChild(deleteBtn);
  tr.appendChild(tdBook);
  tr.appendChild(tdAuthor);
  tr.appendChild(tdBtn);
  return tr;
}

attachEvents();
