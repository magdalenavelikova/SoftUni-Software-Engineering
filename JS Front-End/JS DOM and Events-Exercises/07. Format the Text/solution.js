function solve() {
  let text = document
    .getElementById("input")
    .value.split(".")
    .filter((s) => s !== "");

  let output = document.getElementById("output");

  while (text.length > 0) {
    let p = document.createElement("p");
    let pText = text.splice(0, 3).join(". ") + ".";
    p.textContent = pText;
    output.appendChild(p);
  }
}
