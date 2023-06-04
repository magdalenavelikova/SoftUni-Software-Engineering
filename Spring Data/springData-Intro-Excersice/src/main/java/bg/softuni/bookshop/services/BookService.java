package bg.softuni.bookshop.services;

import bg.softuni.bookshop.models.AgeRestriction;
import bg.softuni.bookshop.models.EditionType;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {


    void seedBooks() throws IOException;


    List<String> findBooksTitlesByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findGoldenBooks(EditionType gold, int copies);

    List<String> findBooksByPrice(BigDecimal lower, BigDecimal higher);

    List<String> findNotReleasedBooks(LocalDate start, LocalDate end);

    List<String> findBooksReleasedBeforeDate(LocalDate date);

    List<String> findBooksTitle(String contains);


    List<String> findBookTitlesWithAuthor(String startsWith);

    int countOfBooks(int length);

    List<String> findBook(String title);

    @Transactional
    int updateBookCopies(LocalDate dateAfter, int addCopies);

    @Transactional
    int deleteBooks(int copies);

    @Transactional
    int storedProcedureCall(String firstName, String lastName);
}
