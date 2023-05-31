package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose task /1-11/: ");
        int task = Integer.parseInt(scanner.nextLine());
        while (task != 0) {

            switch (task) {
                case 1 -> {
                    System.out.println("1. Select Shampoos by Size");
                    System.out.println("Input size:");
                    String sizeName = scanner.nextLine();
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
                    String sizeName = scanner.nextLine();
                    System.out.println("Input label id:");
                    Long labelId = Long.parseLong(scanner.nextLine());
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
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    printShampoosWithPriceHigherThen(price);
                }
                case 4 -> {
                    System.out.println("4.Select Ingredients by Name");
                    System.out.println("Input first letter:");
                    String letters = scanner.nextLine();
                    printIngredientsWhichNameStartsWithLetters(letters);
                }
                case 5 -> {
                    System.out.println("5.Select Ingredients by Names");
                    System.out.println("Input Ingredients:");
                    Set<String> ingredients = new HashSet<>();
                    String row = "";
                    ingredients.add("Lavender");
                    ingredients.add("Herbs");
                    ingredients.add("Apple");

//                    while ((row = scanner.nextLine()) != null) {
//                        ingredients.add(row);
//                    }
                    printIngredientsIngredientsbyNames(ingredients);

                }
                default -> throw new IllegalStateException("Unexpected value: " + task);
            }
            System.out.println("Choose task /1-11/: ");
            System.out.println("For exit press 0: ");
            task = Integer.parseInt(scanner.nextLine());


        }


//
//
//
//

    }

    private void printIngredientsIngredientsbyNames(Set<String> ingredients) {
        this.ingredientService.findIngredientsIngredientsByNames(ingredients).forEach(System.out::println);
    }

    private void printIngredientsWhichNameStartsWithLetters(String letters) {
        this.ingredientService.findIngredientsWhichNameStartsWithLetters(letters).forEach(System.out::println);
    }

    private void printShampoosWithPriceHigherThen(BigDecimal price) {
        this.shampooService.findShampoosWithPriceHigherThen(price).forEach(System.out::println);
    }

    private void printShampoosBySizeOrLabel(Size size, long labelId) {
        this.shampooService.findShampoosBySizeOrLabel(size, labelId).forEach(System.out::println);
    }

    private void printShampooByGivenSize(Size size) {
        this.shampooService.findShampooByGivenSize(size).forEach(System.out::println);
    }
}
