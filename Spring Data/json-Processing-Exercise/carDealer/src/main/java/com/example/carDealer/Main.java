package com.example.carDealer;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.*;
import com.example.carDealer.service.*;
import com.example.carDealer.util.FormatConverter;
import com.example.carDealer.util.FormatConverterFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.example.carDealer.constans.GlobalConstants.*;

@Component
public class Main implements CommandLineRunner {
    private final CarService carService;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final FormatConverterFactory factory;
    private final BufferedReader bufferedReader;
    private FormatConverter converter;
    private String typeFormat;

    public Main(CarService carService, SupplierService supplierService, PartService partService, CustomerService customerService, SaleService saleService, FormatConverterFactory factory) {
        this.carService = carService;
        this.supplierService = supplierService;
        this.partService = partService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.factory = factory;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter valid format /json, xml/: ");
        this.typeFormat = bufferedReader.readLine();
        if (this.typeFormat.isEmpty()) {
            this.typeFormat = "xml";
        }
        this.converter = factory.create(typeFormat);
        this.converter.setPrettyPrint();
        if (typeFormat.equals("json")) {
            seedDataFromJSON();
        } else {
            seedDataFromXML();
        }
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

    private void salesWithAppliedDiscount() throws  UnableToConvertException {
        System.out.println("========== Sales with Applied Discount ================");
        String fileName = RESOURCES_FILE_PATH + SALES_WITH_APPLIED_DISCOUNT_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter
                    .serializeList(saleService.salesWithAppliedDiscount(),
                            fileName);
        } else {
            SaleDtoXML saleDtoXML = new SaleDtoXML();
            saleDtoXML.setSales(saleService.salesWithAppliedDiscount());
            this.converter
                    .serialize(saleDtoXML,
                            fileName);
        }


        writeToFile(saleService.salesWithAppliedDiscount(), SALES_WITH_APPLIED_DISCOUNT_FILE_NAME);

    }

    private void totalSalesByCustomer() throws UnableToConvertException {
        System.out.println("========== Total Sales by Customer ================");
        String fileName = RESOURCES_FILE_PATH + TOTAL_SALES_BY_CUSTOMER_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter
                    .serializeList(customerService.totalSalesByCustomer(),
                            fileName);
        } else {
            CustomersWthTotalSalesDtoXML customersWthTotalSalesDtoXML=new CustomersWthTotalSalesDtoXML();
            customersWthTotalSalesDtoXML.setCustomers(customerService.totalSalesByCustomer());
            this.converter
                    .serialize(customersWthTotalSalesDtoXML,
                            fileName);
        }

    }


    private void orderedCustomers() throws UnableToConvertException {
        System.out.println("========== Ordered Customers ================");
        String fileName = RESOURCES_FILE_PATH + ORDERED_CUSTOMERS_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter
                    .serializeList(customerService.orderedCustomers(),
                            fileName);
        } else {
            this.converter
                    .serialize(customerService.orderedCustomersXML(),
                            fileName);
        }

    }

    private void carsFromMakeToyota() throws IOException, UnableToConvertException {
        System.out.println("========== Cars from Make Toyota ================");
        System.out.println("Enter a make /or press Enter for Toyota/:");
        String input = bufferedReader.readLine();
        String make = input.length() == 0 ? "Toyota" : input;
        String fileName = RESOURCES_FILE_PATH + CARS_FROM_MAKE_TOYOTA_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter
                    .serializeList(carService.carsFromMake(make),
                            fileName);
        } else {
            CarDtoXML carDtoXML = new CarDtoXML();
            carDtoXML.setCars(carService.carsFromMake(make));
            this.converter
                    .serialize(carDtoXML,
                            fileName);
        }
    }

    private void localSuppliers() throws  UnableToConvertException {
        System.out.println("========== Local Suppliers ================");
        String fileName = RESOURCES_FILE_PATH + LOCAL_SUPPLIERS_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter
                    .serializeList(supplierService.localSuppliers(),
                            fileName);
        } else {
            SupplierDtoXML supplierDtoXML = new SupplierDtoXML();
            supplierDtoXML.setSuppliers(supplierService.localSuppliers());
            this.converter
                    .serialize(supplierDtoXML,
                            fileName);
        }

    }

    private void carsWithParts() throws  UnableToConvertException {
        System.out.println("========== Cars with Their List of Parts ==================");
        String fileName = RESOURCES_FILE_PATH + CARS_WITH_PARTS_FILE_NAME + typeFormat;
        if (typeFormat.equals("json")) {
            this.converter
                    .serializeList(carService.carsWithParts(),
                            fileName);
        } else {
            CarInfoDtoXML carInfoDtoXML = new CarInfoDtoXML();
            List<CarWithPartsDto> cars = new ArrayList<>();
            carService.carsWithParts().forEach(c -> cars.add(c.getCar()));
            carInfoDtoXML.setCars(cars);
            this.converter
                    .serialize(carInfoDtoXML,
                            fileName);
        }

    }

    private <E> void writeToFile(List<E> entities, String fileName) throws UnableToConvertException {

        this.converter.serialize(
                entities
                , fileName);

    }

    private void seedDataFromJSON() throws UnableToConvertException, IOException {
        supplierService.seedSuppliersFromJSON(this.converter, this.typeFormat);
        partService.seedPartsFromJSON(this.converter, this.typeFormat);
        carService.seedCarsFromJSON(this.converter, this.typeFormat);
        customerService.seedCustomersFromJSON(this.converter, this.typeFormat);
        saleService.seedSales();

    }

    private void seedDataFromXML() throws UnableToConvertException {

        supplierService.seedSuppliersFromXML(this.converter, this.typeFormat);
        partService.seedPartsFromXML(this.converter, this.typeFormat);
        carService.seedCarsFromXML(this.converter, this.typeFormat);
        customerService.seedCustomersFromXML(this.converter, this.typeFormat);
        saleService.seedSales();
    }
}
