package bg.softuni.gamestore;

import bg.softuni.gamestore.model.dto.*;
import bg.softuni.gamestore.service.GameService;
import bg.softuni.gamestore.service.UserService;
import bg.softuni.gamestore.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

@Component
public class Main implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final UserServiceImpl userServiceImpl;
    private final GameService gameService;

    public Main(UserService userService, UserServiceImpl userServiceImpl, GameService gameService) {
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Enter a command:");
            String[] commandLine = bufferedReader.readLine().split("\\|");
            switch (commandLine[0]) {
                case "RegisterUser" ->
                        userService.registerUser(new UserRegisterDto(commandLine[1], commandLine[2], commandLine[3], commandLine[4]));
                case "LoginUser" -> userService.loginUser(new UserLoginDto(commandLine[1], commandLine[2]));
                case "Logout" -> userService.logoutUser();
                case "AddGame" -> {
                    if (!isLoggedUser()) return;

                    gameService.addGame(
                            new GameAddDto(
                                    commandLine[1],
                                    new BigDecimal(commandLine[2]),
                                    Double.parseDouble(commandLine[3]),
                                    commandLine[4],
                                    commandLine[5],
                                    commandLine[6],
                                    commandLine[7])
                    );
                }
                case "EditGame" -> {
                    if (!isLoggedUser()) return;

                    gameService.editGame(
                            Long.parseLong(commandLine[1]),
                            new BigDecimal(commandLine[2].split("=")[1]),
                            Double.parseDouble(commandLine[3].split("=")[1])
                    );
                }
                case "DeleteGame" -> {
                    if (!isLoggedUser()) return;

                    gameService.deleteGame(Long.parseLong(commandLine[1]));

                }
                case "AllGames" -> printAllGames();
                case "DetailGame" -> printDetailGame(commandLine[1]);
                case "OwnedGames" -> printOwnedGames();
            }
        }
    }

    private void printOwnedGames() {
        if (!isLoggedUser()) return;
        List<OwnedGamesDto> ownedGames = userService.printOwnedGames(userServiceImpl.getLoggedInUser());
        if (ownedGames.isEmpty()) {
            System.out.println("You don't own any games");
            return;
        }

        ownedGames.forEach(System.out::println);
    }

    private void printDetailGame(String title) {
        if (!isLoggedUser()) return;
        DetailGameDto detailGameDto = gameService.detailGame(title);
        if (detailGameDto == null) {
            System.out.println("There is no such game");
            return;
        }
        System.out.println(detailGameDto);
    }

    private void printAllGames() {
        if (!isLoggedUser()) return;

        List<AllGamesDto> allGames = gameService.allGames();
        if (allGames.isEmpty()) {
            return;
        }
        allGames.forEach(System.out::println);
    }

    private boolean isLoggedUser() {
        if (userServiceImpl.getLoggedInUser() == null) {
            System.out.println("Please login");
            return false;
        }
        return true;
    }

}
