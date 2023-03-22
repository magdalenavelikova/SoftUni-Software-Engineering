async function loadCommits() {

    const username = document.getElementById("username").value;
    const repo = document.getElementById("repo").value;
    const list = document.getElementById("commits");
    
    try {
      const response = await fetch(
        `https://api.github.com/users/${username}/${repo}/commits`,
        {
          headers: {
            Authorization: "Bearer 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",
          },
        }
      );

      if (response.ok == false) {
        throw new Error(`${response.status} ${response.statusText}`);
      }
      const data = await response.text();
      list.innerHTML = "";
      for (let { commit } of data) {
        list.innerHTML += `<li> ${commit.author.name}  ${commit.message}  </li>`;
      }
   
    } catch (error) {
      list.innerHTML = `Error ${error.message}`;
      
    }
  }

