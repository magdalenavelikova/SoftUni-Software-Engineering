function shoppingList(input) {
    let products = input.shift().split("!");
    let setOfProducts = new Set();
    products.forEach(p => setOfProducts.add(p));

    while (input.length > 0) {
        let commandLine = input.shift().split(" ");
        let command = commandLine.shift();
        let product = commandLine.shift();
        if (command === "Urgent") {
            if (!setOfProducts.has(product)) {
                products.unshift(product);
                setOfProducts.add(product);
            }
        } else if (command === "Unnecessary") {
            if (setOfProducts.has(product)) {
                let index = products.indexOf(product);
                products.splice(index, 1);
                setOfProducts.delete(product);
            }
        } else if (command === "Correct") {
            if (setOfProducts.has(product)) {
                let index = products.indexOf(product);
                let newProduct = commandLine.shift();
                products.splice(index, 1, newProduct);
                setOfProducts.delete(product);
                setOfProducts.add(newProduct);
            }
        }else if(command==="Rearrange"){
            if (setOfProducts.has(product)) {
                let index = products.indexOf(product);

                products.splice(index, 1);
                products.push(product);
            }
        }
    }



console.log(products.join(", "));

}

shoppingList((["Milk!Pepper!Salt!Water!Banana",
        "Urgent Salt",
        "Unnecessary Grapes",
        "Correct Pepper Onion",
        "Rearrange Grapes",
        "Correct Tomatoes Potatoes",
        "Go Shopping!"]));
shoppingList(
    (["Tomatoes!Potatoes!Bread",
        "Unnecessary Milk",
        "Urgent Tomatoes",
        "Go Shopping!"])
)