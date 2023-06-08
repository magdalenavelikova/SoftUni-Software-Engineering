package bg.softuni.gamestore.service;

import bg.softuni.gamestore.model.dto.OwnedGamesDto;
import bg.softuni.gamestore.model.dto.UserLoginDto;
import bg.softuni.gamestore.model.dto.UserRegisterDto;
import bg.softuni.gamestore.model.entity.User;

import java.util.List;

public interface UserService {
       void registerUser(UserRegisterDto userRegisterDto);

       void loginUser(UserLoginDto userLoginDto);

       void logoutUser();
       List<OwnedGamesDto> printOwnedGames(User loggedInUser);
}
