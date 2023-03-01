package solidExercise.products.calculator;

import solidExercise.products.Product;

import java.util.List;

public class WeightCalculator implements Calculator {


    @Override
    public double calculateTotal(List<Product> products) {
        return products.stream().mapToDouble(Product::getKilograms).sum();
    }

    @Override
    public double calculateAverage(List<Product> products) {
        return calculateTotal(products)/products.size();
    }
}
