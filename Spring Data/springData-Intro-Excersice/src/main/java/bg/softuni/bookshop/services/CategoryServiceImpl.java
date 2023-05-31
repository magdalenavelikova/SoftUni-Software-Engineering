package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.Category;
import bg.softuni.bookshop.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.txt";

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(row -> {
                    Category category = new Category(row);
                    categoryRepository.save(category);
                });

    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories=new HashSet<>();
        int randomSize= ThreadLocalRandom.current().nextInt(1,6);
        Long repoSize=categoryRepository.count();
        for (int i = 0; i < randomSize; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, repoSize+1);
            categories.add(categoryRepository.findById(randomId).orElse(null));

        }
        return categories;
    }
}
