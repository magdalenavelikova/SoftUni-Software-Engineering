package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Town;

import java.util.Optional;


@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Optional<Town> findFirstByTownName(String townName);
}
