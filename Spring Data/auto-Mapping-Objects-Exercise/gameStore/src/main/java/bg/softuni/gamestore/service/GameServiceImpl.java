package bg.softuni.gamestore.service;

import bg.softuni.gamestore.model.dto.AllGamesDto;
import bg.softuni.gamestore.model.dto.DetailGameDto;
import bg.softuni.gamestore.model.dto.GameAddDto;
import bg.softuni.gamestore.model.entity.Game;
import bg.softuni.gamestore.repository.GameRepository;
import bg.softuni.gamestore.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final UserServiceImpl userService;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper mapper, ValidationUtil validationUtil, UserServiceImpl userService) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (!isLoggedUser()) return;

        if (!isValidEntity(gameAddDto)) return;
        Game game = mapper.map(gameAddDto, Game.class);
        gameRepository.save(game);

    }



    @Override
    public void editGame(long id, BigDecimal price, double size) {
        if (!isLoggedUser()) return;
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            System.out.println("There is no game with this ID.");
            return;
        }
        if (size < 0 && price.compareTo(BigDecimal.ZERO) != 0) {
            System.out.println("Enter positive price and size");
            return;

        }
        game.get().setPrice(price);
        game.get().setSize(size);
        gameRepository.save(game.get());
        System.out.println("Edited " + game.get().getTitle());

    }

    @Override
    public void deleteGame(long id) {
        if (!isLoggedUser()) return;
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            System.out.println("There is no game with this ID.");
            return;
        }
        gameRepository.delete(game.get());
    }

    @Override
    public List<AllGamesDto> allGames() {
        if (!isLoggedUser()){
           return new ArrayList<>();
        }
        return gameRepository.findAll().stream()
                .map(g -> mapper.map(g, AllGamesDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public DetailGameDto detailGame(String title) {
        Game game = gameRepository.findGameByTitle(title);
        DetailGameDto detailGameDto=null;
        if (!isLoggedUser()){
            return detailGameDto;
        }
        if(game!=null){
            detailGameDto=mapper.map(game,DetailGameDto.class);
        }
        return detailGameDto;
    }


    private <E> boolean isValidEntity(E entity) {
        Set<ConstraintViolation<E>> violations = validationUtil.violation(entity);
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return false;
        }
        return true;
    }
    private boolean isLoggedUser() {
        if (userService.getLoggedInUser() == null) {
            System.out.println("Please login");
            return false;
        }
        return true;
    }
}
