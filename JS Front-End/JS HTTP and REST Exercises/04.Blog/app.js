function attachEvents() {
  document.getElementById("btnLoadPosts").addEventListener("click", load);
  document.getElementById("btnViewPost").addEventListener("click", view);
}
let select = document.getElementById("posts");
let posts = [];
async function load(ev) {
  ev.preventDefault();
  try {
    let response = await fetch("http://localhost:3030/jsonstore/blog/posts");

    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    let data = await response.json();
    Object.values(data).forEach((obj) => {
      let option = document.createElement("option");
      option.textContent = obj.title;
      option.value = obj.id;
      select.appendChild(option);
      posts.push({ id: obj.id, title: obj.title, body: obj.body });
    });
  } catch (error) {
    alert(error);
  }
}
async function view(ev) {
  ev.preventDefault();
  let selectedOptionKey = select.value;

  try {
    let response = await fetch("http://localhost:3030/jsonstore/blog/comments");
    if (!response.ok) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    let data = await response.json();

    document.getElementById(
      "post-title"
    ).textContent = `${select.selectedOptions[0].textContent}`;
    let body = Object.values(posts).filter(
      (obj) => obj.id == selectedOptionKey
    );
    document.getElementById("post-body").innerHTML = body[0].body;
    let selected = Object.values(data).filter(
      (obj) => obj.postId == selectedOptionKey
    );
    let postComments = document.getElementById("post-comments");
    postComments.replaceChildren();
    Array.from(selected).forEach(obj=>{
        let li=document.createElement("li");
       li.id=obj.id;
        li.textContent=obj.text;
        postComments.appendChild(li);

    });
  } catch (error) {
    alert(error);
  }
}

attachEvents();
