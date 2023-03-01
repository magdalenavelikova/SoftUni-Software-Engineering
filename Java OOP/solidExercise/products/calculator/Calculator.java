package solidExercise.products.calculator;

import solidExercise.products.Product;

import java.util.List;

public interface Calculator {

    double calculateTotal(List<Product> products);
    double calculateAverage(List<Product> products);
}
