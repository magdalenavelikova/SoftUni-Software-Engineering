package bg.softuni.gamestore.repository;

import bg.softuni.gamestore.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    Game findGameByTitle(String title);
}
