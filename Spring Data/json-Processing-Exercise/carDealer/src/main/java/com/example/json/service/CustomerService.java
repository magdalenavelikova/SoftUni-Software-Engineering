package com.example.json.service;

import com.example.json.model.dto.CustomerDto;
import com.example.json.model.dto.CustomerWithTotalSalesDto;
import com.example.json.model.entity.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    void seedCustomers() throws IOException;
    Customer findRandomSCustomer();

    List<CustomerDto> orderedCustomers();

    List<CustomerWithTotalSalesDto> totalSalesByCustomer();
}
