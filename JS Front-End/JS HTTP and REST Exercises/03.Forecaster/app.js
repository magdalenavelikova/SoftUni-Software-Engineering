function attachEvents() {
  const locationInput = document.getElementById("location");
  const divForecast = document.getElementById("forecast");
  const divCurrent = document.getElementById("current");
  const divUpcoming = document.getElementById("upcoming");
  let inner = "";
  const submitBtn = document.getElementById("submit");
  submitBtn.addEventListener("click", getWeather);

  async function getWeather(ev) {
    let allSpan = document.querySelectorAll("span");
    allSpan.forEach((span) => span.remove());
    divForecast.style = "display:block";
    let cityName = locationInput.value;
    ev.preventDefault();
    let code = "";
    try {
      code = "";
      const response = await fetch(
        `http://localhost:3030/jsonstore/forecaster/locations`
      );
      if (response.ok === false) {
        throw new Error(`${response.status} ${response.statusText}`);
      }
      let data = await response.json();

      data.forEach((element) => {
        if (element.name == cityName) {
          code = element.code;
          return code;
        }
      });
      if (code == "") {
        throw new Error("No data for this town");
      }

      const result = await fetch(
        `http://localhost:3030/jsonstore/forecaster/today/${code}`
      );
      if (result.ok === false) {
        throw new Error(`${result.status} ${result.statusText}`);
      }
      let dailyInfo = await result.json();

      createElement("forecast", dailyInfo.forecast, dailyInfo.name);

      const resultForecast = await fetch(
        `http://localhost:3030/jsonstore/forecaster/upcoming/${code}`
      );
      if (resultForecast.ok === false) {
        throw new Error(
          `${resultForecast.status} ${resultForecast.statusText}`
        );
      }
      let upcomingInfo = await resultForecast.json();
      upcomingInfo.forecast.forEach((e) => {
        createElement("upcoming", e, dailyInfo.name);
      });
      let divForecastInfoClass = document.createElement("div");
      divForecastInfoClass.className = "forecast-info";
      divForecastInfoClass.innerHTML = inner;
      divUpcoming.appendChild(divForecastInfoClass);
      
    } catch (error) {
      divForecast.textContent = "Error";
    }
  }

  function createElement(flag, obj, name) {
    let condition = obj.condition;
    let icon = "hi";
    let sunny = "&#x2600";
    let partlySunny = "&#x26C5";
    let overcast = "&#x2601";
    let rain = "&#x2614";
    let degrees = "&#176";

    if (condition == "Rain") {
      icon = rain;
    } else if (condition == "Sunny") {
      icon = sunny;
    } else if (condition == "Partly sunny") {
      icon = partlySunny;
    } else if (condition == "Overcast") {
      icon = overcast;
    }
    let divForecastClass = document.createElement("div");
    divForecastClass.className = "forecasts";

    let spanIcon = document.createElement("span");
    spanIcon.innerHTML = `${icon}`;
    let spanGroup = document.createElement("span");
    let spanName = document.createElement("span");
    let spanDegrees = document.createElement("span");
    let spanCondition = document.createElement("span");
    spanName.className = "forecast-data";
    spanName.textContent = name;
    let buffer = document.createElement("span");

    spanDegrees.className = "forecast-data";
    spanDegrees.innerHTML = `${obj.low}${degrees}/${obj.high}${degrees}`;
    spanCondition.className = "forecast-data";
    spanCondition.textContent = condition;

    if (flag == "forecast") {
      spanIcon.className = "condition symbol";
      spanGroup.className = "condition";
      spanGroup.appendChild(spanName);
      spanGroup.appendChild(spanDegrees);
      spanGroup.appendChild(spanCondition);
      divForecastClass.appendChild(spanIcon);
      divForecastClass.appendChild(spanGroup);
      divCurrent.appendChild(divForecastClass);
    } else if (flag == "upcoming") {
      spanGroup.className = "upcoming";
      spanIcon.className = "symbol";
      spanGroup.appendChild(spanIcon);
      spanGroup.appendChild(spanDegrees);
      spanGroup.appendChild(spanCondition);
      buffer.appendChild(spanGroup);
      inner += buffer.innerHTML;
    }
  }
}

attachEvents();
