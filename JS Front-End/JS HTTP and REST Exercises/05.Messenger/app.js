function attachEvents() {
  document.getElementById("submit").addEventListener("click", addMessage);
  document.getElementById("refresh").addEventListener("click", viewMessages);
}

const inputAuthorName = document.querySelector("[name='author']");
const inputContent = document.querySelector("[name='content']");
const url = "http://localhost:3030/jsonstore/messenger";

async function addMessage(ev) {
  ev.preventDefault();
  if (!inputAuthorName.value || !inputContent.value) {
    throw new Error("The inputs are empty!");
  }
  try {
    let response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify({
        author: inputAuthorName.value.trim(),
        content: inputContent.value.trim(),
      }),
    });
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    inputAuthorName.value = "";
    inputContent.value = "";
    viewMessages(ev);
    return await response.json();
  } catch (error) {
    alert(error);
  }
}

async function viewMessages(ev) {
  ev.preventDefault();
  let textArea = document.getElementById("messages");

  try {
    const response = await fetch(`${url}`);
    if (response.ok === false) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    let data = await response.json();

    let comment = [];
    Object.values(data).forEach((obj) =>
      comment.push(`${obj.author}: ${obj.content}`)
    );

    textArea.value = comment.join("\n");
  } catch (error) {
    textArea.value = "Error";
  }
}

attachEvents();
