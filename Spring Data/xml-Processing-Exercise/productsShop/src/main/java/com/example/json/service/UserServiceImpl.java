package com.example.json.service;

import com.example.json.model.dto.*;
import com.example.json.model.entity.User;
import com.example.json.repository.UserRepository;
import com.example.json.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.json.constans.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper mapper;
    private static final String FILENAME = "users.json";
    private final UserRepository userRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;


    public UserServiceImpl(ModelMapper mapper,
                           UserRepository userRepository, Gson gson, ValidationUtil validationUtil) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void importUsers() throws IOException {
        if (userRepository.count() == 0) {
            Arrays.stream(
                            this.gson.fromJson(Files.readString(Path.of(
                                    RESOURCES_FILE_PATH + FILENAME)), UserSeedDto[].class)
                    )
                    .toList()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> mapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count() + 1);

        return userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserWithSoldProductsDto> soldProduct() {

        return userRepository.findAllBySoldProducts().stream()
                .map(u -> {
                            UserWithSoldProductsDto user = mapper.map(u, UserWithSoldProductsDto.class);
                            Set<SoldProductsDto> sold = user.getSoldProducts()
                                    .stream().filter(p -> p.getBuyerLastName() != null)
                                    .collect(Collectors.toSet());
                            user.setSoldProducts(sold);
                            return user;
                        }
                )
                .collect(Collectors.toList());


    }

    @Override
    public UsersAndProductsDto usersAndProducts() {


        List<User> users = userRepository.usersAndProducts().orElseThrow(NoSuchElementException::new);


        List<UsersSoldProductsWithAgeDto> usersSoldProductsList = users.stream()
                .map(u -> {
                    UsersSoldProductsWithAgeDto user = mapper.map(u, UsersSoldProductsWithAgeDto.class);
                    user.setCount(user.getSoldProducts().size());
                    return user;
                })
                .collect(Collectors.toList());


        return new UsersAndProductsDto(usersSoldProductsList);
    }
}
