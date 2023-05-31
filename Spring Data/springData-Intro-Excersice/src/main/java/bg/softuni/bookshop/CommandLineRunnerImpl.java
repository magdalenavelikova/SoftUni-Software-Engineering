package bg.softuni.bookshop;

import bg.softuni.bookshop.models.Author;
import bg.softuni.bookshop.models.Book;
import bg.softuni.bookshop.services.AuthorService;
import bg.softuni.bookshop.services.BookService;
import bg.softuni.bookshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;


    public CommandLineRunnerImpl(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        printAllBookTitleAfterYear(2000);
        printAllAuthorNamesWithBooksBeforeYear(1999);
        printAuthorsByBookCount();
        printAllBooksByAuthor();

    }

    private void printAllBooksByAuthor() {
        bookService.findAllBookByAuthor("George", "Powell").forEach(System.out::println);
    }

    private void printAuthorsByBookCount() {
        System.out.println("============ Authors Ordered By Books  ==================");
      authorService.findAllAuthorsByBookCount().stream()
              .map(author -> String.format("%s %s countOfBooks: %d", author.getFirstName(),author.getLastName(),author.getBooks().size()))
              .forEach(System.out::println);

    }

    private void printAllAuthorNamesWithBooksBeforeYear(int year) {
        System.out.println("============ Authors with books realized before 1999 year ==================");
        bookService.findAllAuthorNamesWithBooksBeforeYear(year).forEach(System.out::println);
    }

    private void printAllBookTitleAfterYear(int year) {
        System.out.println("============ Books realized after 2000 year ==================");
        bookService.findAllBookAfterYear(year).stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
