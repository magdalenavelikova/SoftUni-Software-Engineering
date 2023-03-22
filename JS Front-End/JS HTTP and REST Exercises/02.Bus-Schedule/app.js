let result = solve();
function solve() {
  const infoSpan = document.querySelector("div#info span.info");
  const departBtn = document.getElementById("depart");
  const arriveBtn = document.getElementById("arrive");
  
  let nextStopId = "depot";
  let stopName = "";

  async function depart() {
   
    try {
      const response = await fetch(
        `http://localhost:3030/jsonstore/bus/schedule/${nextStopId}`
      );

      if (response.ok == false) {
        throw new Error(`${response.status} ${response.statusText}`);
      }
      const data = await response.json();
      stopName = data.name;
      nextStopId = data.next;
      infoSpan.textContent = `Next stop ${stopName}`;
      departBtn.disabled = true;
      arriveBtn.disabled = false;
    } catch (error) {
      infoSpan.textContent = "Error";

      departBtn.disabled = true;
      arriveBtn.disabled = true;
    }
  }

  async function arrive() {
    infoSpan.textContent = `Arriving at ${stopName}`;
    arriveBtn.disabled = true;
    departBtn.disabled = false;
  }

  return {
    depart,
    arrive
  };
}

