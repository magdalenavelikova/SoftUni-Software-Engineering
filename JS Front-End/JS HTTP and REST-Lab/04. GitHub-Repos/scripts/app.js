function loadRepos() {
  document.getElementById("res").textContent = "";
  let button = document.querySelector("button");
  button.addEventListener("click", onClick);

  async function onClick() {
    try {
      const response = await fetch(
         "https://api.github.com/users/magdalenavelikova/repos",
         {
           headers: {
             Authorization: "Bearer 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",
           },
         }
       );
      if (response.ok == false) {
        throw new Error("Request Error");
      }
      const data = await response.text();
      document.getElementById("res").textContent = data;
     console.log(data);
    } catch (error) {
      const err = error.text;
      document.getElementById("res").textContent = err;
    }
  }
}
