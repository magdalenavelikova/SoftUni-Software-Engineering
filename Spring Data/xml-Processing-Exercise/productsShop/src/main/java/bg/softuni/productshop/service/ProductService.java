package bg.softuni.productshop.service;


import bg.softuni.productshop.excetption.UnableToConvertException;
import bg.softuni.productshop.model.dto.ProductsInRangeDto;
import bg.softuni.productshop.model.dto.ProductsXmlDto;
import bg.softuni.productshop.util.FormatConverter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProductsFromJSON(FormatConverter converter, String typeFormat) throws IOException, UnableToConvertException;

    List<ProductsInRangeDto> productsInRange(BigDecimal valueOf, BigDecimal valueOf1);

    void seedProductsFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException;

    ProductsXmlDto productsInRangeForXML(BigDecimal valueOf, BigDecimal valueOf1);
}
