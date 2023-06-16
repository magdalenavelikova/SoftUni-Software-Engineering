package com.example.json;

import com.example.json.service.CategoryService;
import com.example.json.service.ProductService;
import com.example.json.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import static com.example.json.constans.GlobalConstants.*;

@Component
public class Main implements CommandLineRunner {
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final Gson gson;
    private final BufferedReader bufferedReader;

    public Main(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {

        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();
        System.out.println("===== Query and Export Data ============");
        System.out.println("Enter task /1-4/: ");

        int taskNumber = Integer.parseInt(bufferedReader.readLine());
        while (taskNumber != 0) {
            switch (taskNumber) {
                case 1 -> productInRange();
                case 2 -> successfullySoldProducts();
                case 3 -> categoriesByProductsCount();
                case 4 -> usersAndProducts();

                default -> throw new IllegalStateException("No such task: " + taskNumber);
            }
            System.out.println("Choose task /1-4/: ");
            System.out.println("For exit press 0: ");
            taskNumber = Integer.parseInt(bufferedReader.readLine());
        }
    }

    private void usersAndProducts() throws IOException {
        System.out.println("========== Users and Products ================");

        try (FileWriter fileWriter = new FileWriter(RESOURCES_FILE_PATH + USERS_AND_SOLD_PRODUCTS_FILE_NAME)) {
            this.gson.toJson(
                    userService.usersAndProducts()
                    , fileWriter);
        }
    }

    private void categoriesByProductsCount() throws IOException {
        System.out.println("========== Categories by Products Count ================");

        try (FileWriter fileWriter = new FileWriter(RESOURCES_FILE_PATH + CATEGORIES_BY_PRODUCTS_FILE_NAME)) {
            this.gson.toJson(
                    categoryService.categoriesByProductsCount()
                    , fileWriter);
        }
    }

    private void successfullySoldProducts() throws IOException {
        System.out.println("========== Successfully Sold Products ================");

        try (FileWriter fileWriter = new FileWriter(RESOURCES_FILE_PATH + SUCCESSFULLY_SOLD_PRODUCTS_FILE_NAME)) {
            this.gson.toJson(
                    userService.soldProduct()
                    , fileWriter);
        }
    }

    private void productInRange() throws IOException {
        System.out.println("========== Products in Range ==================");

        try (FileWriter fileWriter = new FileWriter(RESOURCES_FILE_PATH + PRODUCT_IN_RANGE_FILE_NAME)) {
            this.gson.toJson(
                    productService.productsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                    , fileWriter);
        }
    }

    private void seedData() throws IOException {
        userService.importUsers();
        categoryService.importCategories();
        productService.importProducts();
    }
}
