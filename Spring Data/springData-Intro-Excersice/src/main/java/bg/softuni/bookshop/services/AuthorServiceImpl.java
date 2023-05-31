package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.Author;
import bg.softuni.bookshop.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(row -> {
                    String[] data = row.split("\\s+");
                    Author author = new Author(data[0], data[1]);
                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, authorRepository.count() + 1);

        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public Set<Author> findAllAuthorsByBookCount() {
        return authorRepository.findAuthorsByBooksSizeDesc();
    }
}
