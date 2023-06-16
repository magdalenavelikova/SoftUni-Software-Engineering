package bg.softuni.productshop.service;


import bg.softuni.productshop.excetption.UnableToConvertException;
import bg.softuni.productshop.model.dto.CategoriesProductsSummaryXMLDto;
import bg.softuni.productshop.model.dto.CategoriesSeedDto;
import bg.softuni.productshop.model.dto.CategoryProductsSummaryDto;
import bg.softuni.productshop.model.dto.CategorySeedDto;
import bg.softuni.productshop.model.entity.Category;
import bg.softuni.productshop.repository.CategoryRepository;
import bg.softuni.productshop.util.FormatConverter;
import bg.softuni.productshop.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static bg.softuni.productshop.constans.GlobalConstants.RESOURCES_FILE_PATH;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper mapper;
    private static final String FILENAME = "categories.";
    private final CategoryRepository categoryRepository;

    private final ValidationUtil validationUtil;


    public CategoryServiceImpl(ModelMapper mapper, CategoryRepository categoryRepository, ValidationUtil validationUtil) {
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;

        this.validationUtil = validationUtil;
    }


    @Override
    public void seedCategoriesFromJSON(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (categoryRepository.count() == 0) {
            List<CategorySeedDto> categories = Arrays.stream(
                            converter.deserializeFromFile(
                                    RESOURCES_FILE_PATH + FILENAME + typeFormat,
                                    CategorySeedDto[].class)

                    )
                    .toList();
            seedToDB(categories);
        }
    }

    @Override
    public void seedCategoriesFromXML(FormatConverter converter, String typeFormat) throws UnableToConvertException {
        if (categoryRepository.count() == 0) {
            CategoriesSeedDto categoriesSeedDto = converter.deserializeFromFile(
                    RESOURCES_FILE_PATH + FILENAME + typeFormat,
                    CategoriesSeedDto.class);

            seedToDB(categoriesSeedDto.getCategories());
        }
    }


    private void seedToDB(List<CategorySeedDto> categoriesSeedDto) {
        categoriesSeedDto
                .stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> mapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> randomSetOfCategories() {
        Set<Category> categorySet = new HashSet<>();
        int catCount = ThreadLocalRandom.current().nextInt(1, 3);
        long total = categoryRepository.count();
        for (int i = 0; i < catCount; i++) {
            long randomId = ThreadLocalRandom
                    .current().nextLong(1, total + 1);
            categorySet.add(categoryRepository.findById(randomId).orElse(null));

        }
        return categorySet;
    }

    @Override
    public List<CategoryProductsSummaryDto> categoriesByProductsCount() {


        return categoryRepository.getCategorySummary().orElseThrow(NoSuchElementException::new);

    }

    @Override
    public CategoriesProductsSummaryXMLDto categoriesByProductsCountForXML() {
        CategoriesProductsSummaryXMLDto category = new CategoriesProductsSummaryXMLDto();
        category.setCategories(categoriesByProductsCount());
                return category;
    }

}
