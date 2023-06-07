package bg.softuni.gamestore.service;

import bg.softuni.gamestore.model.dto.UserLoginDto;
import bg.softuni.gamestore.model.dto.UserRegisterDto;

public interface UserService {
       void registerUser(UserRegisterDto userRegisterDto);

       void loginUser(UserLoginDto userLoginDto);

       void logoutUser();
}
