package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.*;
import bg.softuni.bookshop.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(row -> {
                    String bookInfo[] = row.split("\\s+");
                    Book book = createBookFromInfo(bookInfo);
                    bookRepository.save(book);
                });

    }

    @Override
    public List<String> findBooksTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction).stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findGoldenBooks(EditionType gold, int copies) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(gold, copies).stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksByPrice(BigDecimal lower, BigDecimal higher) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lower, higher).stream()
                .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findNotReleasedBooks(LocalDate start, LocalDate end) {
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(start, end).stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksReleasedBeforeDate(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateBefore(date).stream()
                .map(book -> String.format("%s %.2f", book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksTitle(String contains) {
        return this.bookRepository.findAllByTitleContaining(contains).stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findBookTitlesWithAuthor(String startsWith) {
        return this.bookRepository.findAllByAuthor_LastNameStartsWith(startsWith).stream()
                .map(book -> String.format("%s (%s %S)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int countOfBooks(int length) {
        return this.bookRepository.findAll()
                .stream().filter(book -> book.getTitle().length() > length)
                .collect(Collectors.toList()).size();
    }

    @Override
    public List<String> findBook(String title) {
        return this.bookRepository.findBook(title).stream()
                .map(row -> row.replace(",", " "))
                .collect(Collectors.toList());
    }

    @Override
    public int updateBookCopies(LocalDate dateAfter, int addCopies) {
        return this.bookRepository.updateBookCopies(dateAfter, addCopies);
    }

    @Override
    public int deleteBooks(int copies) {
        return this.bookRepository.deleteBooks(copies);
    }

    @Override
    public int storedProcedureCall(String firstName, String lastName) {
        return this.bookRepository.storedProcedureCall(firstName, lastName);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();
        return new Book(title, editionType, price, copies, releaseDate, ageRestriction, author, categories);

    }
}
