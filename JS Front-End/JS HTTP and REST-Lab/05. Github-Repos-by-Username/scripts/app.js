async function loadRepos() {
  const username = document.getElementById("username").value;
  const list = document.getElementById("repos");

  try {
    const response = await fetch(
      `https://api.github.com/users/${username}/repos`,
      {
        headers: {
          Authorization: "Bearer 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",
        },
      }
    );

    if (response.ok == false) {
      throw new Error(`${response.status} ${response.statusText}`);
    }
    const data = await response.json();
    list.innerHTML = "";
    for (let repo of data) {
      list.innerHTML += `<li> <a href="${repo.html_url}" target="_blank"> ${repo.full_name} </a> </li>`;
    }
  } catch (error) {
    list.innerHTML = `${error.message}`;
  }
}
