package com.example.json;

import com.example.json.service.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static com.example.json.constans.GlobalConstants.*;

@Component
public class Main implements CommandLineRunner {
    private final CarService carService;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Gson gson;
    private final BufferedReader bufferedReader;

    public Main(CarService carService, SupplierService supplierService, PartService partService, CustomerService customerService, SaleService saleService, Gson gson) {
        this.carService = carService;
        this.supplierService = supplierService;
        this.partService = partService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {

        seedData();
        System.out.println("===== Query and Export Data ============");
        System.out.println("Enter task /1-6/: ");

        int taskNumber = Integer.parseInt(bufferedReader.readLine());
        while (taskNumber != 0) {
            switch (taskNumber) {
                case 1 -> orderedCustomers();
                case 2 -> carsFromMakeToyota();
                case 3 -> localSuppliers();
                case 4 -> carsWithParts();
                case 5 -> totalSalesByCustomer();
                case 6 -> salesWithAppliedDiscount();

                default -> throw new IllegalStateException("No such task: " + taskNumber);
            }
            System.out.println("Choose task /1-6/: ");
            System.out.println("For exit press 0: ");
            taskNumber = Integer.parseInt(bufferedReader.readLine());
        }
    }

    private void salesWithAppliedDiscount() throws IOException {
        System.out.println("========== Sales with Applied Discount ================");
        writeToFile(SALES_WITH_APPLIED_DISCOUNT_FILE_NAME, saleService.salesWithAppliedDiscount());

    }

    private void totalSalesByCustomer() throws IOException {
        System.out.println("========== Total Sales by Customer ================");
        writeToFile(TOTAL_SALES_BY_CUSTOMER_FILE_NAME, customerService.totalSalesByCustomer());
    }




    private void orderedCustomers() throws IOException {
        System.out.println("========== Ordered Customers ================");
        writeToFile(ORDERED_CUSTOMERS_FILE_NAME, customerService.orderedCustomers());

    }

    private void carsFromMakeToyota() throws IOException {
        System.out.println("========== Cars from Make Toyota ================");
        System.out.println("Enter a make /or press Enter for Toyota/:");
        String input = bufferedReader.readLine();
        String make = input.length() == 0 ? "Toyota" : input;
        writeToFile(CARS_FROM_MAKE_TOYOTA_FILE_NAME,  carService.carsFromMake(make));

    }

    private void localSuppliers() throws IOException {
        System.out.println("========== Local Suppliers ================");
        writeToFile(LOCAL_SUPPLIERS_FILE_NAME,  supplierService.localSuppliers());

    }

    private void carsWithParts() throws IOException {
        System.out.println("========== Cars with Their List of Parts ==================");
        writeToFile(CARS_WITH_PARTS_FILE_NAME, carService.carsWithParts());

    }
    private <E> void writeToFile(String fileName, List<E> entities) throws IOException {
        try (FileWriter fileWriter = new FileWriter(RESOURCES_FILE_PATH + fileName)) {
            this.gson.toJson(
                    entities
                    , fileWriter);
        }
    }
    private void seedData() throws IOException {

        supplierService.seedSuppliers();
        partService.seedParts();
        carService.seedCars();
        customerService.seedCustomers();
        saleService.seedSales();
    }
}
