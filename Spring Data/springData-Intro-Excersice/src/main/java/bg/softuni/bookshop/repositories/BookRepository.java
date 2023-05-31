package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);
    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);
    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String firstName, String lastName);
}
