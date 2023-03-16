function create(words) {
  let parent = document.getElementById("content");

  for (let i = 0; i < words.length; i++) {
    let div = document.createElement("div");
    let p = document.createElement("p");
    let text = words[i];
    p.textContent = text;
    div.appendChild(p);
    p.style.display = "none";
    parent.appendChild(div);
    div.addEventListener("click", onClick);
  }
  function onClick(ev) {
    ev.target.children[0].style.display = "block";
  }
}
