package com.example.json.service;

import com.example.json.model.dto.CategoryProductsSummaryDto;
import com.example.json.model.dto.CategorySeedDto;
import com.example.json.model.entity.Category;
import com.example.json.repository.CategoryRepository;
import com.example.json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper mapper;
    private static final String FILENAME = "categories.json";
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;


    public CategoryServiceImpl(ModelMapper mapper, CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil) {
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public void importCategories() throws IOException {
        if(categoryRepository.count()==0){
            Arrays.stream(
                            this.gson.fromJson(Files.readString(Path.of(
                                    RESOURCES_FILE_PATH + FILENAME)), CategorySeedDto[].class)
                    )
                    .toList()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(categorySeedDto -> mapper.map(categorySeedDto, Category.class))
                    .forEach(categoryRepository::save);
        }
    }

    @Override
    public Set<Category> randomSetOfCategories() {
        Set<Category> categorySet=new HashSet<>();
        int catCount= ThreadLocalRandom.current().nextInt(1,3);
        long total=categoryRepository.count();
        for (int i = 0; i < catCount; i++) {
            long randomId= ThreadLocalRandom
                    .current().nextLong(1,total+1);
            categorySet.add(categoryRepository.findById(randomId).orElse(null));

        }
        return categorySet;
    }

    @Override
    public List<CategoryProductsSummaryDto> categoriesByProductsCount() {


        return categoryRepository.getCategorySummary().orElseThrow(NoSuchElementException::new);

    }

}
