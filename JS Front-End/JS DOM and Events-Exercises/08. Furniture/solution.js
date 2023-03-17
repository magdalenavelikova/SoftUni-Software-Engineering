function solve() {
  let [generateBtn, buyBtn] = document.querySelectorAll("button");
  generateBtn.addEventListener("click", generate);
  buyBtn.addEventListener("click", buy);
  let info = document.querySelectorAll("textarea")[1];
  info.value = "";
  let tbody = document.querySelector("tbody");

  function generate() {
    let input = Array.from(
      JSON.parse(document.querySelector("textarea").value)
    );
    input.forEach((obj) => {
      let tr = document.createElement("tr");
      let td1 = document.createElement("td");
      let img = document.createElement("img");
      img.src = obj.img;
      td1.appendChild(img);
      tr.appendChild(td1);

      let td2 = document.createElement("td");
      let p2 = document.createElement("p");
      p2.textContent = obj.name;
      td2.appendChild(p2);
      tr.appendChild(td2);

      let td3 = document.createElement("td");
      let p3 = document.createElement("p");
      p3.textContent = obj.price;
      td3.appendChild(p3);
      tr.appendChild(td3);

      let td4 = document.createElement("td");
      let p4 = document.createElement("p");
      p4.textContent = obj.decFactor;
      td4.appendChild(p4);
      tr.appendChild(td4);

      let td5 = document.createElement("td");
      let input = document.createElement("input");
      input.type = "checkbox";
      td5.appendChild(input);
      tr.appendChild(td5);
      tbody.appendChild(tr);
    });
  }

  function buy() {
    let sum = 0;
    let average = 0;
    let furniture = [];
    let checkboxes = Array.from(
      document.querySelectorAll('input[type="checkbox"]')
    ).filter((c) => c.checked);
    checkboxes.forEach((ch) => {
      let p = Array.from(ch.parentElement.parentElement.querySelectorAll("p"));
      furniture.push(p[0].textContent);
      sum += Number(p[1].textContent);
      average += Number(p[2].textContent);
    });
    if (checkboxes.length > 0) {
      let output =
        `Bought furniture: ${furniture.join(", ")}` +
        "\n" +
        `Total price: ${sum.toFixed(2)}` +
        "\n" +
        `Average decoration factor: ${average / checkboxes.length}`;
      info.value = output;
    }
  }
}
