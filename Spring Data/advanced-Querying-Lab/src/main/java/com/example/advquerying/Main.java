package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Component
public class Main implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose task /1-11/: ");
        int task = Integer.parseInt(bufferedReader.readLine());
        while (task != 0) {

            switch (task) {
                case 1 -> {
                    System.out.println("1. Select Shampoos by Size");
                    System.out.println("Input size:");
                    String sizeName = bufferedReader.readLine();
                    try {
                        Size size = Size.valueOf(sizeName);
                        printShampooByGivenSize(size);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("2. Select Shampoos by Size or Label");
                    System.out.println("Input size:");
                    String sizeName = bufferedReader.readLine();
                    System.out.println("Input label id:");
                    Long labelId = Long.parseLong(bufferedReader.readLine());
                    try {
                        Size size = Size.valueOf(sizeName);
                        printShampoosBySizeOrLabel(size, labelId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("3. Select Shampoos by Price");
                    System.out.println("Input price:");
                    BigDecimal price = new BigDecimal(bufferedReader.readLine());
                    printShampoosWithPriceHigherThan(price);
                }
                case 4 -> {
                    System.out.println("4.Select Ingredients by Name");
                    System.out.println("Input first letter:");
                    String letters = bufferedReader.readLine();
                    printIngredientsWhichNameStartsWithLetters(letters);
                }
                case 5 -> {
                    System.out.println("5.Select Ingredients by Names");
                    System.out.println("Input Ingredients: ");
                    Set<String> ingredients = new HashSet<>();
                    String row;
                    while ((row = bufferedReader.readLine()) != null && !row.isBlank()) {
                        ingredients.add(row);
                    }
                    printIngredientsByNames(ingredients);

                }
                case 6 -> {
                    System.out.println("6.Count Shampoos by Price");
                    System.out.println("Input price: ");
                    BigDecimal price = new BigDecimal(bufferedReader.readLine());
                    printCountOfShampoosWithPriceLowerThan(price);

                }
                case 7 -> {
                    System.out.println("7. Select Shampoos by Ingredients");
                    System.out.println("Input Ingredients: ");
                    Set<String> ingredients = new HashSet<>();
                    String row;
                    while ((row = bufferedReader.readLine()) != null && !row.isBlank()) {
                        ingredients.add(row);
                    }
                    printShampoosWithIngredients(ingredients);

                }
                case 8 -> {
                    System.out.println("8. Select Shampoos by Ingredients Count");
                    System.out.println("Input Ingredients Count: ");
                    int count = Integer.parseInt(bufferedReader.readLine());
                    printShampoosWithIngredientsLessThan(count);
                }
                case 9 -> {
                    System.out.println("9. Delete Ingredients by Name");
                    System.out.println("Input Ingredient Name: ");
                    String name = bufferedReader.readLine();
                    this.ingredientService.deleteIngredient(name);

                }
                case 10 -> {
                    System.out.println("10. Update Ingredients by Price");
                    this.ingredientService.updateIngredientsPrice();
                }
                case 11 -> {
                    System.out.println("11. Update Ingredients by Names");
                    System.out.println("Input Ingredient Name: ");
                    String name = bufferedReader.readLine();
                    this.ingredientService.updateIngredientsPriceByName(name);
                }
                default -> throw new IllegalStateException("Unexpected value: " + task);
            }
            System.out.println();
            System.out.println("Choose task /1-11/: ");
            System.out.println("For exit press 0: ");
            task = Integer.parseInt(bufferedReader.readLine());

        }
    }

    private void printShampoosWithIngredientsLessThan(int count) {
        shampooService.findShampoosWithIngredientsLessThan(count).forEach(System.out::println);
    }

    private void printShampoosWithIngredients(Set<String> ingredients) {
        shampooService.findShampoosWithIngredients(ingredients).forEach(System.out::println);
    }

    private void printCountOfShampoosWithPriceLowerThan(BigDecimal price) {
        System.out.println("Count of shampoos: " + shampooService.findCountOfShampoosWithPriceLowerThan(price));
    }

    private void printIngredientsByNames(Set<String> ingredients) {
        this.ingredientService.findIngredientsIngredientsByNames(ingredients).forEach(System.out::println);
    }

    private void printIngredientsWhichNameStartsWithLetters(String letters) {
        this.ingredientService.findIngredientsWhichNameStartsWithLetters(letters).forEach(System.out::println);
    }

    private void printShampoosWithPriceHigherThan(BigDecimal price) {
        this.shampooService.findShampoosWithPriceHigherThan(price).forEach(System.out::println);
    }

    private void printShampoosBySizeOrLabel(Size size, long labelId) {
        this.shampooService.findShampoosBySizeOrLabel(size, labelId).forEach(System.out::println);
    }

    private void printShampooByGivenSize(Size size) {
        this.shampooService.findShampooByGivenSize(size).forEach(System.out::println);
    }
}
