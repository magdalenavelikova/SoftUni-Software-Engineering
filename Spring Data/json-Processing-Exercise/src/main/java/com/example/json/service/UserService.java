package com.example.json.service;


import com.example.json.model.entity.User;

import java.io.IOException;

public interface UserService {
    void importUsers() throws IOException;
    User findRandomUser();
}
