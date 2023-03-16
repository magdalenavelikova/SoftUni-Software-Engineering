function lockedProfile() {
  Array.from(document.querySelectorAll("button")).forEach((e) =>
    e.addEventListener("click", onClick)
  );

  function onClick(ev) {
    let card = ev.target.parentElement;
    let buttonValue = ev.target.textContent;
    let isUnlock = card.querySelector("input[value=unlock]").checked;

    if (isUnlock) {
      if (buttonValue === "Show more") {
        card.querySelector("div").style.display = "block";
        ev.target.textContent = "Hide it";
      } else {
        card.querySelector("div").style.display = "none";
        ev.target.textContent = "Show more";
      }
    }
  }
}
