window.addEventListener("load", solve);

function solve() {
  const inputs = {
    genre: document.getElementById("genre"),
    name: document.getElementById("name"),
    author: document.getElementById("author"),
    date: document.getElementById("date"),
  };
 
  const addBtn = document.getElementById("add-btn");
  addBtn.addEventListener("click", addInfo);
  let likeButtons = [];
  let saveButtons = [];
  let deleteButtons = [];
  let div;

  function addInfo(ev) {
  ev.preventDefault();

    if (
      inputs.genre.value === "" ||
      inputs.name.value === "" ||
      inputs.author.value === "" ||
      inputs.date.value === ""
    ) {
      return;
    }

    let collectionsContainer =
      document.getElementsByClassName("all-hits-container")[0];

    let div = createInfo();

    collectionsContainer.appendChild(div);

    clearInputs();

    function clearInputs() {
      inputs.name.value = "";
      inputs.genre.value = "";
      inputs.date.value = "";
      inputs.author.value = "";
    }

    listenerForButtons();
  }

  function like(ev) {
    ev.preventDefault();
    let totalLikes = document.querySelector("#total-likes p");
    let likes = Number(totalLikes.textContent.split(": ")[1]);
    let output = `Total Likes: ${likes + 1}`;
    totalLikes.textContent = output;
    ev.target.disabled=true;
  }

  function saveSong(ev) {
    ev.preventDefault();
    let savedContainer = document.getElementsByClassName("saved-container")[0];
    let info = document.createElement("div");
    info.className = "hits-info";
    info.innerHTML = ev.target.parentElement.innerHTML;
    info.children[6].remove();
    info.children[5].remove();
    savedContainer.appendChild(info);
    listenerForButtons();
    ev.target.parentElement.remove();
  }

  function deleteSong(ev) {
    ev.preventDefault();
    ev.target.parentElement.remove();
  }

  function createInfo() {
    let div = document.createElement("div");
    div.className = "hits-info";

    let img = document.createElement("img");
    img.src = "./static/img/img.png";
    div.appendChild(img);

    let h2Genre = document.createElement("h2");
    h2Genre.textContent = "Genre: " + inputs.genre.value;
    div.appendChild(h2Genre);

    let h2Name = document.createElement("h2");
    h2Name.textContent = "Name: " + inputs.name.value;
    div.appendChild(h2Name);

    let h2Author = document.createElement("h2");
    h2Author.textContent = "Author: " + inputs.author.value;
    div.appendChild(h2Author);

    let h3 = document.createElement("h3");
    h3.textContent = "Date: " + inputs.date.value;
    div.appendChild(h3);

    let btnSave = document.createElement("button");
    btnSave.className = "save-btn";
    btnSave.textContent = "Save song";
    div.appendChild(btnSave);

    let btnLike = document.createElement("button");
    btnLike.className = "like-btn";
    btnLike.textContent = "Like song";
    div.appendChild(btnLike);

    let btnDelete = document.createElement("button");
    btnDelete.className = "delete-btn";
    btnDelete.textContent = "Delete";
    div.appendChild(btnDelete);
    return div;
  }

  function listenerForButtons() {
    likeButtons = Array.from(document.querySelectorAll(".like-btn")).forEach(
      (btn) => btn.addEventListener("click", like)
    );
    saveButtons = Array.from(document.querySelectorAll(".save-btn")).forEach(
      (btn) => btn.addEventListener("click", saveSong)
    );
    deleteButtons = Array.from(
      document.querySelectorAll(".delete-btn")
    ).forEach((btn) => btn.addEventListener("click", deleteSong));
  }
}
