package com.example.json;

import com.example.json.service.CategoryService;
import com.example.json.service.ProductService;
import com.example.json.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Component
public class Main implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final Gson gson;

    public Main(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {

        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();
        System.out.println("========== – Products in Range ==========================");
        try (FileWriter fileWriter = new FileWriter(RESOURCES_FILE_PATH + "products-in-range.json")) {
            this.gson.toJson(
                    productService.productsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000)), fileWriter);
        }


    }

    private void seedData() throws IOException {
        userService.importUsers();
        categoryService.importCategories();
        productService.importProducts();
    }
}
