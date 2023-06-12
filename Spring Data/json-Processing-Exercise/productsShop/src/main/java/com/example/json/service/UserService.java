package com.example.json.service;


import com.example.json.model.dto.UsersAndProductsDto;
import com.example.json.model.dto.UserWithSoldProductsDto;
import com.example.json.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void importUsers() throws IOException;
    User findRandomUser();

    List<UserWithSoldProductsDto> soldProduct();

    UsersAndProductsDto usersAndProducts();
}
