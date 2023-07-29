package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;

import java.util.Optional;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findFirstByFirstName(String firstName);


}
