function attachEvents() {
  document.getElementById("btnLoad").addEventListener("click", load);
  document.getElementById("btnCreate").addEventListener("click", add);
}
let url = "http://localhost:3030/jsonstore/phonebook";
let ul = document.getElementById("phonebook");

async function load(ev) {
  ul.replaceChildren();
  try {
    let response = await fetch(url);
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    let data = await response.json();
    Object.values(data).forEach((obj) => {
      let li = document.createElement("li");
      li.textContent = `${obj.person}: ${obj.phone}`;
      let btn = document.createElement("button");
      btn.id = obj._id;
      btn.textContent = "Delete";
      btn.addEventListener("click", deleteRecord);
      li.appendChild(btn);
      ul.appendChild(li);
    });
  } catch (error) {
    alert(error);
  }
}
async function add(ev) {
  let person = document.getElementById("person");
  let phone = document.getElementById("phone");

  try {
    if (!person.value || !phone.value) {
      throw new Error("Inputs are empty or invalid!");
    }

    let response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify({
        person: person.value.trim(),
        phone: phone.value.trim(),
      }),
    });

    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    load(ev);
    person.value = "";
    phone.value = "";
    return await response.json();
  } catch (error) {
    alert(error);
  }
  ev.preventDefault();
}
async function deleteRecord(ev) {
  let urlToken = `${url}/${ev.target.id}`;

  try {
    let response = await fetch(urlToken, {
      method: "DELETE",
    });

    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    ev.target.parentElement.remove();
    load(ev);
    return await response.json();
  } catch (error) {
    alert(error);
  }
}

attachEvents();
