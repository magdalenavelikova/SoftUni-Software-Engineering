package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Astronomer;

import java.util.Optional;

@Repository
public interface AstronomerRepository extends JpaRepository<Astronomer,Long> {

    Optional<Astronomer> findFirstByFirstNameAndLastName(String firstName, String lastName);
}
