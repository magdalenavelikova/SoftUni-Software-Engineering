package bg.softuni.productshop.service;

import bg.softuni.productshop.excetption.UnableToConvertException;
import bg.softuni.productshop.model.dto.ProductSeedDto;
import bg.softuni.productshop.model.dto.ProductsInRangeDto;
import bg.softuni.productshop.model.dto.ProductsSeedDto;
import bg.softuni.productshop.model.dto.ProductsXmlDto;
import bg.softuni.productshop.model.entity.Product;
import bg.softuni.productshop.repository.ProductRepository;
import bg.softuni.productshop.util.FormatConverter;
import bg.softuni.productshop.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.productshop.constans.GlobalConstants.RESOURCES_FILE_PATH;


@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper mapper;
    private static final String FILENAME = "products.";
    private final ProductRepository productRepository;
    private ProductsXmlDto productsXmlDto;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper mapper, ProductRepository productRepository, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProductsFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException {

        if (productRepository.count() == 0) {
            List<ProductSeedDto> products = Arrays.stream(
                    converter.deserializeFromFile(
                            RESOURCES_FILE_PATH + FILENAME + typeFormat,
                            ProductSeedDto[].class)

            ).toList();
            seedToDB(products);
        }

    }

    @Override
    public List<ProductsInRangeDto> productsInRange(BigDecimal min, BigDecimal max) {


        return productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(min, max).stream()
                .map(p -> {
                    ProductsInRangeDto productsInRangeDto = mapper.map(p, ProductsInRangeDto.class);
                    String firstName = p.getSeller().getFirstName();
                    firstName = firstName == null ? "" : firstName;
                    productsInRangeDto.setSellerFullName(String.format("%s %S", firstName, p.getSeller().getLastName()));
                    return productsInRangeDto;
                }).collect(Collectors.toList());

    }

    @Override
    public void seedProductsFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (productRepository.count() == 0) {

            ProductsSeedDto productsSeedDto = converter.deserializeFromFile(
                    RESOURCES_FILE_PATH + FILENAME + typeFormat,
                    ProductsSeedDto.class);

            seedToDB(productsSeedDto.getProducts());

        }
    }

    @Override
    public ProductsXmlDto productsInRangeForXML(BigDecimal min, BigDecimal max) {
        ProductsXmlDto productsXmlDto = new ProductsXmlDto();
        productsXmlDto.setProducts(productsInRange(min, max));
        return productsXmlDto;

    }

    private void seedToDB(List<ProductSeedDto> products) {
        products
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

                }).forEach(productRepository::save);
    }
}
