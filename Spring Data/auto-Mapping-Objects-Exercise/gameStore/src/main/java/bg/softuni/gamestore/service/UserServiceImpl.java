package bg.softuni.gamestore.service;

import bg.softuni.gamestore.model.dto.OwnedGamesDto;
import bg.softuni.gamestore.model.dto.UserLoginDto;
import bg.softuni.gamestore.model.dto.UserRegisterDto;
import bg.softuni.gamestore.model.entity.User;
import bg.softuni.gamestore.repository.UserRepository;
import bg.softuni.gamestore.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("Wrong confirm password!");
            return;
        }
        if (isValidEntity(userRegisterDto)) return;
        User user = mapper.map(userRegisterDto, User.class);
        userRepository.save(user);
        System.out.println(userRegisterDto.getFullName() + " was registered");
    }

    @Override
    public List<OwnedGamesDto> printOwnedGames(User loggedInUser) {

        return userRepository.findAllByUser(loggedInUser.getId()).stream()
                .map(game -> mapper.map(game, OwnedGamesDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        if (isValidEntity(userLoginDto)) return;

        Optional<User> user = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        if (user.isEmpty()) {
            System.out.println("Incorrect username / password");
            return;
        }
        loggedInUser = user.get();
        System.out.printf("Successfully logged in %s%n", user.get().getFullName());

    }

    @Override
    public void logoutUser() {
        if (loggedInUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }
        System.out.printf("User %s successfully logged out%n", loggedInUser.getFullName());
        loggedInUser = null;
    }

    private <E> boolean isValidEntity(E entity) {
        Set<ConstraintViolation<E>> violations = validationUtil.violation(entity);
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return true;
        }
        return false;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
