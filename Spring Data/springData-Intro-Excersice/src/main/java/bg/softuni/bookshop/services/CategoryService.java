package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
