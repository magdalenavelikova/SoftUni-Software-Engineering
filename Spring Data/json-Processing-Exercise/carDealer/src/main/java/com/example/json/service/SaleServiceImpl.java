package com.example.json.service;

import com.example.json.model.dto.SaleDto;
import com.example.json.model.entity.Part;
import com.example.json.model.entity.Sale;
import com.example.json.repository.CustomerRepository;
import com.example.json.repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;


    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, CustomerRepository customerRepository, ModelMapper mapper) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public void seedSales() {

//applied (discounts can be 0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).
        if (saleRepository.count() == 0) {
            Set<Sale> sales = new HashSet<>();
            double discount;
            Double[] discounts = {0.0, 0.05, 0.10, 0.15, 0.20, 0.30, 0.40, 0.50};

            for (int i = 0; i < customerRepository.count(); i++) {
                Sale sale = new Sale();
                sale.setCar(carService.findRandomCar());
                sale.setCustomer(customerService.findRandomSCustomer());
                discount = discounts[new Random().nextInt(discounts.length - 1)];
                if (sale.getCustomer().isYoungDriver()==true) {
                    discount += 0.05;
                }
                sale.setDiscount(discount);
                sales.add(sale);
            }
            saleRepository.saveAll(sales);
        }


    }

    @Override
    public List<SaleDto> salesWithAppliedDiscount() {
        return saleRepository.findAll()
                .stream()
                .map(sale ->{
                    SaleDto saleDto = mapper.map(sale, SaleDto.class);
                    BigDecimal priceOfCar = sale.getCar().getParts().stream()
                            .map(Part::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    BigDecimal priceWithDiscount=priceOfCar.subtract(priceOfCar.multiply(BigDecimal.valueOf(sale.getDiscount())));
                    saleDto.setPrice(priceOfCar.setScale(2, RoundingMode.CEILING));
                    saleDto.setPriceWithDiscount(priceWithDiscount);

                    return saleDto;
                } )
                .collect(Collectors.toList());


    }
}
