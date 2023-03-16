function toggle() {
  let button = document.getElementsByClassName("button")[0];
  let extra = document.getElementById("extra");
  if (button.textContent == "Less") {
    extra.style.display = "none";
    button.textContent = "More";
  } else {
    extra.style.display = "block";
    button.textContent = "Less";
  }
}
