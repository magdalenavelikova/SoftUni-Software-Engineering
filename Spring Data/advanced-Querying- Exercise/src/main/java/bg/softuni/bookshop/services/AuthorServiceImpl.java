package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.Author;
import bg.softuni.bookshop.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
    public List<String> findAuthorsWithFirstName(String endsWith) {

        return this.authorRepository.findAllByFirstNameEndingWith(endsWith).stream()
                .map(author -> String.format("%s %s", author.getFirstName(), author.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findTotalBookCopies() {
        return this.authorRepository.findAuthorsByBooksCopies().stream()
                .map(row -> {
                    String[] split = row.split(",");
                    String concat = split[0] + " " + split[1] + " - " + split[2];
                    return concat;
                })
                .collect(Collectors.toList());
    }


}
