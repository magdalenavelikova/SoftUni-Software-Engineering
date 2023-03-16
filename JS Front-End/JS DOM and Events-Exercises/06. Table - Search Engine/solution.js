function solve() {
  document.querySelector("#searchBtn").addEventListener("click", onClick);
  let search = document.getElementById("searchField");
  let rows = document.querySelectorAll("tbody tr");

  function onClick(ev) {
    for (let row of rows) {
      row.classList.remove("select");
      if (search.value !== " " && row.innerHTML.includes(search.value)) {
        row.className = "select";
      }
    }

    search.value = "";
  }
}
