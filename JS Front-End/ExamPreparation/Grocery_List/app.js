function attachEvents() {
  document.getElementById("load-product").addEventListener("click", loadAll);
  addButton.addEventListener("click", addRecord);
  updateBtn.addEventListener("click", updateRecord);
}

const url = "http://localhost:3030/jsonstore/grocery/";
let tbody = document.querySelector("#tbody");
let product = document.getElementById("product");
let count = document.getElementById("count");
let price = document.getElementById("price");
let id = "";
const addButton = document.getElementById("add-product");
const updateBtn = document.getElementById("update-product");

async function addRecord(ev) {
  ev.preventDefault();
  if (
    product.value.length <= 0 ||
    count.value.length <= 0 ||
    price.value.length <= 0
  ) {
    console.log("Please fill all fields");
  } else {
    try {
      let response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          product: product.value,
          count: count.value,
          price: price.value,
        }),
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }
      loadAll(ev);
      clearInputs();
    } catch (error) {
      console.log(error);
    }
  }
}
function clearInputs() {
  product.value = "";
  count.value = "";
  price.value = "";
}

async function loadAll(ev) {
  ev.preventDefault();
  tbody.innerHTML = "";
  try {
    let response = await fetch(url);
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    let data = await response.json();
    Object.values(data).forEach((obj) => {
      let tr = createTr( obj);
      tbody.appendChild(tr);
    });
  } catch (error) {
    console.log(error);
  }
}

function fillInputs(ev) {
  id = ev.target.id;
  product.value = ev.target.parentElement.parentElement.children[0].textContent;
  count.value = Number(
    ev.target.parentElement.parentElement.children[1].textContent
  );
  price.value = Number(
    ev.target.parentElement.parentElement.children[2].textContent
  );
  updateBtn.disabled = false;
  addButton.disabled = true;
}

async function updateRecord(ev) {
  let urlToken = `${url}${id}`;
  console.log(urlToken);

  ev.preventDefault();
  if (
    product.value.length <= 0 ||
    count.value.length <= 0 ||
    price.value.length <= 0
  ) {
    console.log("Please fill all fields");
  } else {
    try {
      let response = await fetch(urlToken, {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          product: product.value,
          count: count.value,
          price: price.value,
          
        }),
      });
      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }
      updateBtn.disabled = true;
      addButton.disabled = false;
      clearInputs();
      loadAll(ev);
    } catch (error) {
      console.log(error);
    }
  }
}

async function deleteRecord(ev) {
  let urlToken = `${url}${ev.target.id}`;
  ev.preventDefault();
  try {
    let response = await fetch(urlToken, {
      method: "DELETE",
    });
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    ev.target.parentElement.parentElement.remove();
    loadAll(ev);
  } catch (error) {
    console.log(error);
  }
}

function createTr(obj) {
  let tr = document.createElement("tr");
  let tdName = document.createElement("td");
  tdName.className = "name";
  tdName.textContent = obj.product;
  tr.appendChild(tdName);
  let tdCount = document.createElement("td");
  tdCount.className = "count-product";
  tdCount.textContent = obj.count;
  tr.appendChild(tdCount);
  let tdPrice = document.createElement("td");
  tdPrice.className = "product-price";
  tdPrice.textContent = obj.price;
  tr.appendChild(tdPrice);
  let tdButtons = document.createElement("td");
  tdButtons.className = "btn";
  let updateBtn = document.createElement("button");
  updateBtn.textContent = "Update";
  updateBtn.className = "update";
  updateBtn.id = obj._id;
  updateBtn.addEventListener("click", fillInputs);
  tdButtons.appendChild(updateBtn);
  let deleteBtn = document.createElement("button");
  deleteBtn.className = "delete";
  deleteBtn.textContent = "Delete";
  deleteBtn.id = obj._id;
  deleteBtn.addEventListener("click", deleteRecord);
  tdButtons.appendChild(deleteBtn);
  tr.appendChild(tdButtons);
  return tr;
}

attachEvents();
