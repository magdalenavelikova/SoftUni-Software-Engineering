function fruit(fruit, amount, price) {
    console.log(`I need $${((amount * price) / 1000).toFixed(2)} to buy ${(amount / 1000).toFixed(2)} kilograms ${fruit}.`)
}

fruit('orange', 2500, 1.80);