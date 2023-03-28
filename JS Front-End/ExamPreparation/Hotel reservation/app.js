window.addEventListener("load", solve);

function solve() {
  const inputs = document.querySelectorAll(".container-text input");
  const inputFirstName = document.getElementById("first-name");
  const inputLastName = document.getElementById("last-name");
  const inputDateIn = document.getElementById("date-in");
  const inputDateOut = document.getElementById("date-out");
  const inputPeopleCount = document.getElementById("people-count");
  const nextBtn = document.getElementById("next-btn");
  const infoList = document.querySelector(".info-list");
  const confirmList = document.querySelector(".confirm-list");
  const h1 = document.getElementById("verification");
  nextBtn.addEventListener("click", submit);

  function submit(ev) {
    if (ev) {
      ev.preventDefault();
    }

    if(inputFirstName.value == ''
    || inputLastName.value == ''
    || inputDateIn.value == ''
    ||inputDateOut.value == ''
    ||inputPeopleCount.value == ''
    || new Date(inputDateIn.value) >= new Date(inputDateOut.value)) {
        return;
    }

    let li = document.createElement("li");
    li.className = "reservation-content";
    let article = document.createElement("article");
    let h3 = document.createElement("h3");
    h3.textContent = `Name: ${inputFirstName.value} ${inputLastName.value}`;
    let p1 = document.createElement("p");
    p1.textContent = `From date: ${inputDateIn.value}`;
    let p2 = document.createElement("p");
    p2.textContent = `To date: ${inputDateOut.value}`;
    let p3 = document.createElement("p");
    p3.textContent = `For ${inputPeopleCount.value} people`;

    article.appendChild(h3);
    article.appendChild(p1);
    article.appendChild(p2);
    article.appendChild(p3);
    li.appendChild(article);
    let editBtn = document.createElement("button");
    editBtn.className = "edit-btn";
    editBtn.textContent = "Edit";
    editBtn.addEventListener("click", edit);
    li.appendChild(editBtn);
    let continueBtn = document.createElement("button");
    continueBtn.className = "continue-btn";
    continueBtn.textContent = "Continue";
    continueBtn.addEventListener("click", next);
    li.appendChild(continueBtn);
    infoList.appendChild(li);
    nextBtn.disabled = true;
    Array.from(inputs).forEach((i) => (i.value = ""));
  }

  function edit(ev) {
    let info = Array.from(ev.target.parentElement.children[0].children);
    let names = info.shift().textContent.split(": ")[1];
    let dateIn = info.shift().textContent.split(": ")[1];
    let dateOut = info.shift().textContent.split(": ")[1];
    let people = Number(info.shift().textContent.split(" ")[1]);
    let namesArr = names.split(" ");
    inputFirstName.value = namesArr[0];
    inputLastName.value = namesArr[1];
    inputDateIn.value = dateIn;
    inputDateOut.value = dateOut;
    inputPeopleCount.value = people;
    nextBtn.disabled = false;
    infoList.innerHTML = " ";
  }
  function next(ev) {
    let html = ev.target.parentElement.parentElement.innerHTML;
    let result = html.replace(
      '<button class="edit-btn">Edit</button><button class="continue-btn">Continue</button></li>',
      '<button class="confirm-btn">Confirm</button><button class="cancel-btn">Cancel</button></li>'
    );

    confirmList.innerHTML = result;
    infoList.innerHTML = " ";

    document
      .querySelector(".confirm-btn")
      .addEventListener("click", madeReservation);

    document
      .querySelector(".cancel-btn")
      .addEventListener("click", cancelReservation);
  }

  function madeReservation(ev) {
    h1.className = "reservation-confirmed";
    h1.textContent = "Confirmed.";
    ev.target.parentElement.remove();
    nextBtn.disabled = false;
  }

  function cancelReservation(ev) {
    h1.className = "reservation-cancelled";
    h1.textContent = "Cancelled.";
    ev.target.parentElement.remove();
    nextBtn.disabled = false;
  }
}
