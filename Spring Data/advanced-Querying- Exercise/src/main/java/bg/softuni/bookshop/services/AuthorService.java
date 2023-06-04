package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.Author;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface AuthorService  {


    void seedAuthors() throws IOException;

    Author getRandomAuthor();


    List<String> findAuthorsWithFirstName(String endsWith);


    List<String>  findTotalBookCopies();
}
