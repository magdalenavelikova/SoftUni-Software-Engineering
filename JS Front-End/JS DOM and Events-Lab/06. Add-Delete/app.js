function addItem() {
  let liText = document.getElementById("newItemText").value;
  let li = document.createElement("li");
  li.textContent = liText;
  if (liText.length === 0) {
    return;
  }
  let a = document.createElement("a");
  a.textContent = "[Delete]";
  a.href = "#";
  a.addEventListener("click", deleteFunction);

  li.appendChild(a);
  let element = document.getElementById("items");
  element.appendChild(li);

  document.getElementById("newItemText").value = "";
  function deleteFunction() {
    li.remove();
  }
}
