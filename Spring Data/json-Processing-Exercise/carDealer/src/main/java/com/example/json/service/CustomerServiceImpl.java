package com.example.json.service;

import com.example.json.model.dto.CustomerDto;
import com.example.json.model.dto.CustomerSeedDto;
import com.example.json.model.dto.CustomerWithTotalSalesDto;
import com.example.json.model.entity.Customer;
import com.example.json.model.entity.Part;
import com.example.json.repository.CustomerRepository;
import com.example.json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String FILENAME = "customers.json";
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(Gson gson, ModelMapper mapper, ValidationUtil validationUtil, CustomerRepository customerRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedCustomers() throws IOException {

        if (customerRepository.count() == 0) {
            Arrays.stream(gson.fromJson(Files.readString(Path.of(RESOURCES_FILE_PATH + FILENAME)), CustomerSeedDto[].class))
                    .toList()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(customerSeedDto -> mapper.map(customerSeedDto, Customer.class))
                    .forEach(customerRepository::save);

        }
    }

    @Override
    public Customer findRandomSCustomer() {
        long randomId = ThreadLocalRandom
                .current().nextLong(2, customerRepository.count() + 1);

        return customerRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<CustomerDto> orderedCustomers() {
        return customerRepository.findAllByOrderByBirthDateAscIsYoungDriverDesc()
                .stream()
                .map(c -> mapper.map(c, CustomerDto.class))
                .collect(Collectors.toList());


    }

    @Override
    public List<CustomerWithTotalSalesDto> totalSalesByCustomer() {
    return     customerRepository.findAllBySalesIsNotNull().stream()
                .map(customer -> {
                    CustomerWithTotalSalesDto customerWithTotalSalesDto = mapper.map(customer, CustomerWithTotalSalesDto.class);
                    customerWithTotalSalesDto.setBoughtCars(customer.getSales().size());

                    BigDecimal spentMoney = customer.getSales().stream()
                            .map(sale -> {
                                BigDecimal priceOfCar = sale.getCar().getParts().stream()
                                        .map(Part::getPrice)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                                return priceOfCar.subtract(priceOfCar.multiply(BigDecimal.valueOf(sale.getDiscount())));

                            }).reduce(BigDecimal.ZERO, BigDecimal::add);

                    customerWithTotalSalesDto.setSpentMoney(spentMoney.setScale(2, RoundingMode.CEILING));
                    return customerWithTotalSalesDto;
                }).collect(Collectors.toList());

    }
}
