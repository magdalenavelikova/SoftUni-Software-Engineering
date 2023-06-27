package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.*;
import com.example.carDealer.model.entity.Customer;
import com.example.carDealer.model.entity.Part;
import com.example.carDealer.repository.CustomerRepository;
import com.example.carDealer.util.FormatConverter;
import com.example.carDealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.carDealer.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String FILENAME = "customers.";

    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl( ModelMapper mapper, ValidationUtil validationUtil, CustomerRepository customerRepository) {

        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTOForXML orderedCustomersXML() {
        List<CustomerBasicDto> customerBasicDtoList = customerRepository.findAllByOrderByBirthDateAscIsYoungDriverDesc()
                .stream()
                .map(c -> mapper.map(c, CustomerBasicDto.class))
                .collect(Collectors.toList());
        CustomerDTOForXML customerDTOForXML = new CustomerDTOForXML();
        customerDTOForXML.setCustomers(customerBasicDtoList);
        return customerDTOForXML;
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
        List<CustomerWithTotalSalesDto> customerWithTotalSales = customerRepository.findAllBySalesIsNotNull().stream()
                .map(customer -> {
                    CustomerWithTotalSalesDto customerWithTotalSalesDto = mapper.map(customer, CustomerWithTotalSalesDto.class);
                    customerWithTotalSalesDto.setBoughtCars(customer.getSales().size());

                    BigDecimal spentMoney = customer.getSales().stream()
                            .map(sale -> {
                                BigDecimal priceOfCar = sale.getCar().getParts().stream()
                                        .map(Part::getPrice)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                                return priceOfCar.subtract(priceOfCar.multiply(sale.getDiscount()));

                            }).reduce(BigDecimal.ZERO, BigDecimal::add);

                    customerWithTotalSalesDto.setSpentMoney(spentMoney.setScale(2, RoundingMode.CEILING));
                    return customerWithTotalSalesDto;
                }).collect(Collectors.toList());

        customerWithTotalSales
                .sort(Comparator.comparing(CustomerWithTotalSalesDto::getSpentMoney)
                .thenComparing(CustomerWithTotalSalesDto::getBoughtCars).reversed());
        return customerWithTotalSales;

    }

    @Override
    public void seedCustomersFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (customerRepository.count() == 0) {
            CustomersSeedDto customersSeedDto = converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat, CustomersSeedDto.class);
            seedDto(customersSeedDto.getCustomers());
        }
    }

    @Override
    public void seedCustomersFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (customerRepository.count() == 0) {
            List<CustomerSeedDto> seedDtoList = Arrays.stream(converter.deserializeFromFile(RESOURCES_FILE_PATH + FILENAME + typeFormat, CustomerSeedDto[].class))
                    .toList();
            seedDto(seedDtoList);
        }
    }



    private void seedDto(List<CustomerSeedDto> seedDtoList) {
        seedDtoList.stream()
        .filter(validationUtil::isValid)
        .map(customerSeedDto -> mapper.map(customerSeedDto, Customer.class))
        .forEach(customerRepository::save);
    }



    @Override
    public Customer findRandomSCustomer() {
        long randomId = ThreadLocalRandom
                .current().nextLong(2, customerRepository.count() + 1);

        return customerRepository
                .findById(randomId)
                .orElse(null);
    }
}
