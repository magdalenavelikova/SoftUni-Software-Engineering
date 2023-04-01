function solve() {
  const info = {
    recipientName: null,
    title: null,
    message: null,
  };

  const inputDOMSelectors = {
    recipientName: document.getElementById("recipientName"),
    title: document.getElementById("title"),
    message: document.getElementById("message"),
  };

  const otherDOMSelectors = {
    addBtn: document.getElementById("add"),
    resetBtn: document.getElementById("reset"),
    listMails: document.querySelector("#list"),
    sentList: document.querySelector(".sent-list"),
    deleteList: document.querySelector(".delete-list"),
  };

  otherDOMSelectors.addBtn.addEventListener("click", inAddHandler);
  otherDOMSelectors.resetBtn.addEventListener("click", inResetHandler);
  function inAddHandler(event) {
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
    const { recipientName, title, message } = inputDOMSelectors;
    let li = createElement("li", otherDOMSelectors.listMails);
    createElement("h4", li, `Title: ${title.value}`);
    createElement("h4", li, `Recipient Name: ${recipientName.value}`);
    createElement("span", li, message.value);
    let div = createElement("div", li, "", "list-action");
    let sendBtn = createElement("button", div, "Send", "send", "", {
      type: "submit",
    });

    let deleteBtn = createElement("button", div, "Delete", "delete", "", {
      type: "submit",
    });
    for (const key in inputDOMSelectors) {
      info[key] = inputDOMSelectors[key].value;
    }
    clear();

    sendBtn.addEventListener("click", inSendHandler);
    deleteBtn.addEventListener("click", inDeleteHandler);
  }
  function inSendHandler(event) {
    let li = createElement("li", otherDOMSelectors.sentList);
    createElement("span", li, `To: ${info.recipientName}`);
    createElement("span", li, `Title: ${info.title}`);
    let div = createElement("div", li, "", "", ["btn"]);
    let deleteBtn = createElement("button", div, "Delete", "", ["delete"], {
      type: "submit",
    });
    deleteBtn.addEventListener("click", inDeleteHandler);

    event.target.parentElement.parentElement.remove();
  }
  function inDeleteHandler(event) {
    event.target.parentElement.parentElement.remove();
    let li = createElement("li", otherDOMSelectors.deleteList);
    createElement("span", li, `To: ${info.recipientName}`);
    createElement("span", li, `Title: ${info.title}`);
  }

  function inResetHandler(event) {
    if (event) {
      event.preventDefault();
    }
    clear();
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

solve();
