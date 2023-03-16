function sumTable() {
  const table = document.querySelector("table");
  let column = table.querySelectorAll("td:nth-child(2)");

  let sum = 0;
  for (let i = 0; i < column.length - 1; i++) {
    sum += Number(column[i].textContent);
  }
  document.getElementById("sum").textContent = sum;
}

//2nd
function sumTable() {
  const rows = Array.from(document.querySelectorAll("tr")).slice(1, -1);
  let sum = 0;
  for (const row of rows) {
    sum += Number(row.lastElementChild.textContent);
  }

  document.getElementById("sum").textContent = sum;
}
