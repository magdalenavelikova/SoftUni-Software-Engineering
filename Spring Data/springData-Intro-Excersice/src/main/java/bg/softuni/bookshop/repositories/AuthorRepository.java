package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.models.Author;
import bg.softuni.bookshop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a ORDER BY SIZE(a.books) DESC ")
    Set<Author> findAuthorsByBooksSizeDesc();
}
