function attachEvents() {
  document.getElementById("loadBooks").addEventListener("click", loadAll);
  document.querySelector("#form button").addEventListener("click", save);
  window.addEventListener("load", clear);
}

let baseUrl = "http://localhost:3030/jsonstore/collections/books";
let tbody = document.querySelector("tbody");
let inputTitle = document.querySelector("[name='title']");
let inputAuthor = document.querySelector("[name='author']");
let id = "";
let submitBtn = document.querySelector("#form button");
let h3 = document.querySelector("#form h3");

async function loadAll() {
  tbody.replaceChildren();
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

async function save() {
  if (!inputTitle.value || !inputAuthor.value) {
    alert("Please fill all fields");
  } else {
    let method = "";
    let url=""
    if (submitBtn.textContent == "Submit") {
      method = "POST";
      url=baseUrl
    } else if (submitBtn.textContent == "Save") {
      method = "PUT";
      url = baseUrl + "/" + id;
         submitBtn.textContent = "Submit";
    }
       try {
      let response = await fetch(url, {
        method: `${method}`,
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          title: inputTitle.value,
          author: inputAuthor.value,
        }),
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }
      h3.textContent = "FORM";
      //inputTitle.value = "";
    //  inputAuthor.value = "";
      loadAll();
      return await response.json;
    } catch(error) {
      alert(error);
    }
  }
}

function edit(ev) {
  submitBtn.textContent = "Save";
  id = ev.target.id;
  h3.textContent = "Edit FORM";
  inputTitle.value =
    ev.target.parentElement.parentElement.children[0].textContent;
  inputAuthor.value =
    ev.target.parentElement.parentElement.children[1].textContent;						 
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
    loadAll();
    return await response.json();
  } catch (error) {
    alert(error);
  }
}


function clear() {
  tbody.replaceChildren();
  //inputTitle.value = "";
  //inputAuthor.value = "";
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
