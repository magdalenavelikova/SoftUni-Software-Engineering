package bg.softuni.bookshop.repositories;

import bg.softuni.bookshop.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByFirstNameEndingWith(String endsWith);

    @Query("SELECT a.firstName,a.lastName,sum (ab.copies) as bcopies FROM Author a JOIN a.books ab  GROUP BY a.id  order by bcopies DESC")
    List<String> findAuthorsByBooksCopies();


}
