package bg.softuni.productshop.service;


import bg.softuni.productshop.excetption.UnableToConvertException;
import bg.softuni.productshop.model.dto.CategoriesProductsSummaryXMLDto;
import bg.softuni.productshop.model.dto.CategoryProductsSummaryDto;
import bg.softuni.productshop.model.entity.Category;
import bg.softuni.productshop.util.FormatConverter;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategoriesFromJSON(FormatConverter converter, String typeFormat) throws IOException, UnableToConvertException;

    Set<Category> randomSetOfCategories();

    List<CategoryProductsSummaryDto> categoriesByProductsCount();

    void seedCategoriesFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException;

    CategoriesProductsSummaryXMLDto categoriesByProductsCountForXML();
}
