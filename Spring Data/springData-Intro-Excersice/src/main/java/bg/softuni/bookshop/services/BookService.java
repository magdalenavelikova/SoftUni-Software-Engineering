package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {


    void seedBooks() throws IOException;
    List<Book> findAllBookAfterYear(int year);

    List<String> findAllAuthorNamesWithBooksBeforeYear(int year);

    List<String> findAllBookByAuthor(String firstName, String lastName);
}
