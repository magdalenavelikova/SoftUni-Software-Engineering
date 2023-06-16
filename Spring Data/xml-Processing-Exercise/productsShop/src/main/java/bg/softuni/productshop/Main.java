package bg.softuni.productshop;


import bg.softuni.productshop.excetption.UnableToConvertException;
import bg.softuni.productshop.service.CategoryService;
import bg.softuni.productshop.service.ProductService;
import bg.softuni.productshop.service.UserService;
import bg.softuni.productshop.util.FormatConverter;
import bg.softuni.productshop.util.FormatConverterFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import static bg.softuni.productshop.constans.GlobalConstants.*;


@Component
public class Main implements CommandLineRunner {
    private final CategoryService categoryService;

    private final UserService userService;
    private final ProductService productService;
    private final FormatConverterFactory factory;
    private final BufferedReader bufferedReader;
    private FormatConverter converter;
    private String typeFormat;

    public Main(CategoryService categoryService, UserService userService, ProductService productService, FormatConverterFactory factory) {

        this.categoryService = categoryService;

        this.userService = userService;
        this.productService = productService;
        this.factory = factory;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter valid format /json, xml/: ");
        this.typeFormat = bufferedReader.readLine();
        this.converter = factory.create(typeFormat);
        this.converter.setPrettyPrint();
        if (typeFormat.equals("json")) {
            seedDataFromJSON();
        } else {
            seedDataFromXML();
        }

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


    private void usersAndProducts() throws UnableToConvertException {
        System.out.println("========== Users and Products ================");

        this.converter
                .serialize(userService.usersAndProducts(),
                        RESOURCES_FILE_PATH + USERS_AND_SOLD_PRODUCTS_FILE_NAME + typeFormat);
    }

    private void categoriesByProductsCount() throws UnableToConvertException {
        System.out.println("========== Categories by Products Count ================");
        String fileName=RESOURCES_FILE_PATH + CATEGORIES_BY_PRODUCTS_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter
                    .serializeList(categoryService.categoriesByProductsCount(),
                            fileName);
        }else {
            this.converter
                    .serialize(categoryService.categoriesByProductsCountForXML(),
                            fileName);
        }


    }

    private void successfullySoldProducts() throws UnableToConvertException {
        System.out.println("========== Successfully Sold Products ================");
        String fileName=RESOURCES_FILE_PATH + SUCCESSFULLY_SOLD_PRODUCTS_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter.serializeList(userService.soldProduct(),
                    fileName);
        }else {
            this.converter.serialize(userService.soldProductForXML(),
                    fileName);
        }

    }

    private void productInRange() throws UnableToConvertException {
        System.out.println("========== Products in Range ==================");
        String fileName=RESOURCES_FILE_PATH + PRODUCT_IN_RANGE_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter.serializeList(
                    productService.productsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000)),
                    fileName);
        } else {

            this.converter.serialize(
                    productService.productsInRangeForXML(BigDecimal.valueOf(500), BigDecimal.valueOf(1000)),
                    fileName);
        }


    }

    private void seedDataFromJSON() throws IOException, UnableToConvertException {
        userService.seedUsersFromJSON(this.converter, this.typeFormat);
        categoryService.seedCategoriesFromJSON(this.converter, this.typeFormat);
        productService.seedProductsFromJSON(this.converter, this.typeFormat);
    }

    private void seedDataFromXML() throws UnableToConvertException {
        userService.seedUsersFromXML(this.converter, this.typeFormat);
        categoryService.seedCategoriesFromXML(this.converter, this.typeFormat);
        productService.seedProductsFromXML(this.converter, this.typeFormat);
    }
}
