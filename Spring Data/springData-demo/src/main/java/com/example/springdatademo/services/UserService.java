package com.example.springdatademo.services;

import com.example.springdatademo.exeptions.UserNameAllreadyExistsExeption;
import com.example.springdatademo.exeptions.UserNotFoundException;
import com.example.springdatademo.models.User;

import java.math.BigDecimal;

public interface UserService {
    void registerUser(String username,int age, BigDecimal initialAmount)throws UserNameAllreadyExistsExeption;
    void addAccount(BigDecimal amount, Long id) throws UserNotFoundException;
}
