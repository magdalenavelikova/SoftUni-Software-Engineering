package еncapsulationExercise.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;


    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if ( name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        } else {
            this.money -= product.getCost();
            products.add(product);
        }
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        } else {
            StringBuilder output = new StringBuilder();
            output.append(this.name).append(" - ");
            output.append(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
            return output.toString();
        }
    }
}
