function addItem() {
  const newItemText = document.getElementById("newItemText").value;
  const newItemValue = document.getElementById("newItemValue").value;

  let select = document.getElementById("menu");

  let option = document.createElement("option");
  option.text = newItemText;
  option.value = newItemValue;

  if (newItemText !== " " && newItemValue !== " ") {
    select.appendChild(option);
  }
  
  document.getElementById("newItemText").value = "";
  document.getElementById("newItemValue").value = "";
}
