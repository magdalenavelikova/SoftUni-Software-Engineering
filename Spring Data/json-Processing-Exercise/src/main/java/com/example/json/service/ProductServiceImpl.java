package com.example.json.service;

import com.example.json.model.dto.ProductSeedDto;
import com.example.json.model.dto.ProductsBetweenPriceRangeWithoutBuyerDto;
import com.example.json.model.entity.Product;
import com.example.json.repository.ProductRepository;
import com.example.json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper mapper;
    private static final String FILENAME = "products.json";
    private final ProductRepository productRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper mapper, ProductRepository productRepository, Gson gson, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void importProducts() throws IOException {

        if (productRepository.count() == 0) {
            List<Product> collect = Arrays.stream(
                            this.gson.fromJson(Files.readString(Path.of(
                                    RESOURCES_FILE_PATH + FILENAME)), ProductSeedDto[].class)
                    )
                    .toList()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Product product = mapper.map(productSeedDto, Product.class);

                        if (product.getPrice().compareTo(BigDecimal.valueOf(500)) < 0) {
                            product.setBuyer(userService.findRandomUser());
                        }
                        product.setSeller(userService.findRandomUser());

                        product.setCategories(categoryService.randomSetOfCategories());
                        return product;

                    }).collect(Collectors.toList());
            collect.forEach(productRepository::save);
        }

    }

    @Override
    public List<ProductsBetweenPriceRangeWithoutBuyerDto> productsInRange(BigDecimal min, BigDecimal max) {


        List<ProductsBetweenPriceRangeWithoutBuyerDto> collect = productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(min, max).stream()
                .map(p -> {
                    ProductsBetweenPriceRangeWithoutBuyerDto productsBetweenPriceRangeWithoutBuyerDto = mapper.map(p, ProductsBetweenPriceRangeWithoutBuyerDto.class);
                    productsBetweenPriceRangeWithoutBuyerDto.setSellerFullName(String.format("%s %S", p.getSeller().getFirstName(), p.getSeller().getLastName()));
                    return productsBetweenPriceRangeWithoutBuyerDto;
                }).collect(Collectors.toList());
        return collect;
    }
}
