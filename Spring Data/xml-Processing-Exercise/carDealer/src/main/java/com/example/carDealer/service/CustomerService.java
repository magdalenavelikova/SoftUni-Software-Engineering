package com.example.carDealer.service;

import com.example.carDealer.excetption.UnableToConvertException;
import com.example.carDealer.model.dto.CustomerDTOForXML;
import com.example.carDealer.model.dto.CustomerDto;
import com.example.carDealer.model.dto.CustomerWithTotalSalesDto;
import com.example.carDealer.model.entity.Customer;
import com.example.carDealer.util.FormatConverter;

import java.util.List;

public interface CustomerService {

    Customer findRandomSCustomer();

    List<CustomerDto> orderedCustomers();

    List<CustomerWithTotalSalesDto> totalSalesByCustomer();

    void seedCustomersFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException;

    void seedCustomersFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException;


}
