function addItem() {
  let liText = document.getElementById("newItemText").value;
  let li = document.createElement("li");
  li.textContent = liText;
  //li.appendChild(document.createTextNode(text));
  let element = document.getElementById("items");
  element.appendChild(li);
  document.getElementById("newItemText").value="";
}
