function deleteByEmail() {
  let table = document.querySelector("tbody");
  let tr = table.children;
  let searchingText = document.querySelector("input[name=email]").value;
  let isRemove = false;
  for (let iterator of tr) {
    if (iterator.textContent.includes(searchingText)) {
      iterator.parentNode.removeChild(iterator);
      isRemove = true;
    }
  }
  let result = document.getElementById("result");
  

  if (isRemove) {
    result.textContent = "Deleted.";
    
  } else {
    result.textContent = "Not found.";
    
  }
 
  document.querySelector("input[name=email]").value = "";
}

//for judge

function deleteByEmail() {
  let email = document.getElementsByName("email")[0].value;
  let secondColumn = document.querySelectorAll(
    "#customers tr td:nth-child(2)");
  for (let td of secondColumn)
    if (td.textContent == email) {
      let row = td.parentNode;
      row.parentNode.removeChild(row);
      document.getElementById('result').
        textContent = "Deleted.";
      return;
    }
  document.getElementById('result').textContent = "Not found.";
}
