window.addEventListener("load", solve);

function solve() {
  const inputs = {
    firstName: document.getElementById("first-name"),
    lastName: document.getElementById("last-name"),
    age: document.getElementById("age"),
    title: document.getElementById("story-title"),
    genre: document.getElementById("genre"),
    text: document.getElementById("story"),
  };

  const publishBtn = document.getElementById("form-btn");
  const ul = document.getElementById("preview-list");
  publishBtn.addEventListener("click", preview);

  function preview(ev) {
    
    let inValid = Object.values(inputs).filter((i) => i.value === "");

    if (inValid.length > 0) {
      return;
    }

    let li = document.createElement("li");
    li.className = "story-info";

    let article = document.createElement("article");

    h4 = document.createElement("h4");
    h4.textContent = `Name: ${inputs.firstName.value} ${inputs.lastName.value}`;
    article.appendChild(h4);

    pAge = document.createElement("p");
    pAge.textContent = `Age: ${inputs.age.value}`;
    article.appendChild(pAge);

    pTitle = document.createElement("p");
    pTitle.textContent = `Title: ${inputs.title.value}`;
    article.appendChild(pTitle);

    pGenre = document.createElement("p");
    pGenre.textContent = `Genre: ${inputs.genre.value}`;
    article.appendChild(pGenre);

    pText = document.createElement("p");
    pText.textContent = inputs.text.value;
    article.appendChild(pText);

    li.appendChild(article);

    let saveBtn = document.createElement("button");
    saveBtn.className = "save-btn";
    saveBtn.textContent = "Save Story";
    li.appendChild(saveBtn);

    let editBtn = document.createElement("button");
    editBtn.className = "edit-btn";
    editBtn.textContent = "Edit Story";
    li.appendChild(editBtn);

    let deleteBtn = document.createElement("button");
    deleteBtn.className = "delete-btn";
    deleteBtn.textContent = "Delete Story";
    li.appendChild(deleteBtn);

    ul.appendChild(li);

    publishBtn.disabled = true;
    Object.values(inputs).forEach((i) => (i.value = ""));
    listenerForButtons();
  }

  function savePublication(ev) {
    ev.preventDefault();

    let main = Array.from(document.getElementById("main").children);
    main.forEach((ch) => ch.remove());
    let h1 = document.createElement("h1");
    h1.textContent = "Your scary story is saved!";
    document.getElementById("main").appendChild(h1);
  }

  function editPublication(ev) {
    let publishedInfo = Array.from(
      ev.target.parentElement.children[0].children
    );

    let names = publishedInfo.shift().textContent.split(": ")[1];
    let namesArr = names.split(" ");
    inputs.firstName.value = namesArr[0];
    inputs.lastName.value = namesArr[1];
    let age = Number(publishedInfo.shift().textContent.split(": ")[1]);
    inputs.age.value = age;
    inputs.title.value = publishedInfo.shift().textContent.split(": ")[1];
    inputs.genre.value = publishedInfo.shift().textContent.split(": ")[1];
    inputs.text.value = publishedInfo.shift().textContent;

    publishBtn.disabled = false;
    ev.target.parentElement.remove();
  }
  function deletePublication(ev) {
    ev.preventDefault();
    ev.target.parentElement.remove();
    publishBtn.disabled = false;
  }

  function listenerForButtons() {
    likeButtons = Array.from(document.querySelectorAll(".save-btn")).forEach(
      (btn) => btn.addEventListener("click", savePublication)
    );
    saveButtons = Array.from(document.querySelectorAll(".edit-btn")).forEach(
      (btn) => btn.addEventListener("click", editPublication)
    );
    deleteButtons = Array.from(
      document.querySelectorAll(".delete-btn")
    ).forEach((btn) => btn.addEventListener("click", deletePublication));
  }
}
