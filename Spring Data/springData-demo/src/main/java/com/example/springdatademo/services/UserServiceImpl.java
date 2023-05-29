package com.example.springdatademo.services;

import com.example.springdatademo.exeptions.UserNameAllreadyExistsExeption;
import com.example.springdatademo.exeptions.UserNotFoundException;
import com.example.springdatademo.models.Account;
import com.example.springdatademo.models.User;
import com.example.springdatademo.repositories.AccountRepository;
import com.example.springdatademo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(String username, int age, BigDecimal initialAmount) throws UserNameAllreadyExistsExeption {
        if (this.userRepository.existsByUsername(username)) {
            throw new UserNameAllreadyExistsExeption();
        }
        var user = new User();
        user.setUsername(username);
        user.setAge(age);
        this.userRepository.save(user);
        this.saveAmount(initialAmount, user);

    }

    @Override
    public void addAccount(BigDecimal amount, Long id) throws UserNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        this.saveAmount(amount, user);
    }

    private void saveAmount(BigDecimal initialAmount, User user) {
        var account = new Account();
        account.setBalance(initialAmount);
        account.setUser(user);
        this.accountRepository.save(account);
    }
}
