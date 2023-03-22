async function getInfo() {
  const id = document.getElementById("stopId").value;
  const list = document.getElementById("buses");
  const stopName = document.getElementById("stopName");
  list.replaceChildren();
  
  try {
    const result = await fetch(
      `http://localhost:3030/jsonstore/bus/businfo/${id}`
    );

    if (result.ok == false) {
      throw new Error(`${result.status} ${result.statusText}`);
    }
    let data = await result.json();
 
    list.innerHTML = "";
    stopName.textContent = `${data.name}`;
    Object.entries(data.buses).forEach((b) => {
      const li = document.createElement("li");
      li.textContent = `Bus ${b[0]} arrives in ${b[1]} minutes`;
      list.appendChild(li);
    });
  } catch (error) {
    stopName.textContent = "Error";
  }
}
