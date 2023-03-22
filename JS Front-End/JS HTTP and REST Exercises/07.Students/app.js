function attachEvents() {
  window.addEventListener("load", loadData);
  document.getElementById("submit").addEventListener("click", add);
}

let url = "http://localhost:3030/jsonstore/collections/students";
let table = document.querySelector("#results tbody");
let form = document.querySelector(".inputs");
async function add() {
  let inputs = Array.from(form.children);
  let empty = inputs.filter((e) => !e.value);

  try {
    if (empty.length > 0) {
      throw new Error("Empty inputs");
    }
   

    let response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify({
        firstName: inputs[0].value.trim(),
        lastName: inputs[1].value.trim(),
        facultyNumber: inputs[2].value.trim(),
        grade:inputs[3].value.trim(),
      }),
    });
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    inputs.forEach((e) => (e.value = ""));
    loadData();
    return await response.json();
  } catch (error) {
    alert(error);
  }
}

async function loadData() {
  table.replaceChildren();
  try {
    let response = await fetch(url);
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    let data = await response.json();
    Object.values(data).forEach((obj) => {
      table.appendChild(createRow(obj));
    });
  } catch (error) {
    alert(error);
  }
}
function createRow(obj) {
  console.log(obj);
  let tr = document.createElement("tr");
  Object.entries(obj).forEach((obj) => {
    let td = document.createElement("td");
    td.textContent = obj[1];
    tr.appendChild(td);
  });
  tr.removeChild(tr.lastChild);
  return tr;
}
attachEvents();
