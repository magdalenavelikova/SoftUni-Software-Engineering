package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.models.AgeRestriction;
import bg.softuni.bookshop.models.Book;
import bg.softuni.bookshop.models.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate start, LocalDate end);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByTitleContaining(String contains);

    List<Book> findAllByAuthor_LastNameStartsWith(String startsWith);

    @Query("SELECT b.title, b.editionType, b.ageRestriction,b.price FROM Book b WHERE b.title=:title")
    List<String> findBook(String title);

    @Modifying
    @Query("UPDATE Book b SET b.copies=b.copies+:addCopies WHERE b.releaseDate>:dateAfter")
    int updateBookCopies(LocalDate dateAfter, int addCopies);

    @Modifying
    @Query("delete FROM  Book  b WHERE b.copies<:copies")
    int deleteBooks(int copies);

    @Procedure(procedureName = "total_number_of_books")
    int callProcedure(@Param(value = "first_name") String firstName, @Param(value = "last_name") String lastName);

    /* 14 Task with native SQL
    @Query(value = "CALL total_number_of_books (:first_name, :last_name);", nativeQuery = true)
    int storedProcedureCall(@Param(value = "first_name") String firstName, @Param(value = "last_name") String lastName);
*/
}
