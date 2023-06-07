package bg.softuni.gamestore.service;

import bg.softuni.gamestore.model.dto.AllGamesDto;
import bg.softuni.gamestore.model.dto.DetailGameDto;
import bg.softuni.gamestore.model.dto.GameAddDto;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long id, BigDecimal price, double size);

    void deleteGame(long id);

    List<AllGamesDto> allGames();

    DetailGameDto detailGame(String title);
}
