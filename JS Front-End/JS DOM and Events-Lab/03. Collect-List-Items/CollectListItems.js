function extractText() {
  let elements = document.querySelectorAll("ul#items li");

  let text = "";
  for (let iterator of elements) {
    text += iterator.textContent + "\n";
  }
  document.getElementById("result").value = text;
}
