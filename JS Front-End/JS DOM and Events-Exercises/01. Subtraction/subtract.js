function subtract() {
  const first = document.getElementById("firstNumber").value;
  const second = document.getElementById("secondNumber").value;
  document.getElementById("result").textContent =
    Number(first) - Number(second);
}
