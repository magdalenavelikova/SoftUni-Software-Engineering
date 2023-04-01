window.addEventListener("load", solve);

function solve() {
  const info = {
    make: null,
    model: null,
    year: null,
    fuel: null,
    originalCost: null,
    sellingPrice: null,
  };
  const inputDOMSelectors = {
    make: document.getElementById("make"),
    model: document.getElementById("model"),
    year: document.getElementById("year"),
    fuel: document.getElementById("fuel"),
    originalCost: document.getElementById("original-cost"),
    sellingPrice: document.getElementById("selling-price"),
  };
  const otherDOMSelectors = {
    publishBtn: document.getElementById("publish"),
    tbody: document.getElementById("table-body"),
    carList: document.getElementById("cars-list"),
   profit: document.getElementById("profit"),
    
  };
let totalProfit=0;
  otherDOMSelectors.publishBtn.addEventListener("click", inPublishHandler);

  function inPublishHandler(event) {
    if (event) {
      event.preventDefault();
    }

    const areValidInputsValues = Object.values(inputDOMSelectors).every(
      (input) => input.value != ""
    );

    if (!areValidInputsValues) {
      console.log("Empty Field!");
      return;
    }

    if (
      Number(inputDOMSelectors.originalCost.value) >=
      Number(inputDOMSelectors.sellingPrice.value)
    ) {
      console.log("Original cost must be less then selling price!");
      return;
    }
    const { make, model, year, fuel, originalCost, sellingPrice } =
      inputDOMSelectors;

    const tr = createElement("tr", otherDOMSelectors.tbody, "", "", ["row"]);
    createElement("td", tr, make.value);
    createElement("td", tr, model.value);
    createElement("td", tr, year.value);
    createElement("td", tr, fuel.value);
    createElement("td", tr, originalCost.value);
    createElement("td", tr, sellingPrice.value);
    const td = createElement("td", tr);
    const editBtn = createElement("button", td, "Edit", "", [
      "action-btn",
      "edit",
    ]);
    const sellBtn = createElement("button", td, "Sell", "", [
      "action-btn",
      "sell",
    ]);
    for (const key in inputDOMSelectors) {
      info[key] = inputDOMSelectors[key].value;
    }
    clear();

    editBtn.addEventListener("click", inEditHandler);
    sellBtn.addEventListener("click", inSellHandler);
  }
  function inSellHandler(event){
    let profit=Number(info.sellingPrice)-Number(info.originalCost);
    totalProfit+=profit;
    const li = createElement("li",otherDOMSelectors.carList,"", "", ["each-list"]);
    createElement("span",li, `${info.make} ${info.model}`);
    createElement("span",li, `${info.year}`);
    createElement("span",li, `${profit}`);
    event.target.parentElement.parentElement.remove();
    otherDOMSelectors.profit.textContent=`${totalProfit.toFixed(2)}`;
  }

  function inEditHandler(event) {
    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = info[key];
    }
    event.target.parentElement.parentElement.remove();
  }

  function clear() {
    Object.values(inputDOMSelectors).forEach((input) => (input.value = ""));
  }

  function createElement(type, parent, content, id, classes, attributes) {
    //TYPE parse
    const element = document.createElement(type);

    //CONTENT Parse
    if (content) {
      if (type !== "input" && type !== "textarea") {
        element.textContent = content;
      } else {
        element.value = content;
      }
    }

    //ID Parse
    if (id) {
      element.setAttribute("id", id);
    }

    //CLASSES Parse
    if (classes) {
      for (const clazz of classes) {
        element.classList.add(clazz);
      }
    }

    //PARENT Parse
    if (parent) {
      parent.appendChild(element);
    }

    //ATTRIBUTES Parse
    if (attributes) {
      for (const key in attributes) {
        element.setAttribute(key, attributes[key]);
      }
    }
    return element;
  }
}