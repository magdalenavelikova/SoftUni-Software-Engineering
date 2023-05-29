package com.example.springdatademo;

import com.example.springdatademo.exeptions.InsufficientFundsException;
import com.example.springdatademo.exeptions.UserNameAllreadyExistsExeption;
import com.example.springdatademo.services.AccountService;
import com.example.springdatademo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final AccountService accountService;

    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            this.userService.registerUser("Test", 25, new BigDecimal(1100));
        } catch (UserNameAllreadyExistsExeption e) {
            System.out.println(e.getClass().getSimpleName());
        }

        this.userService.addAccount(new BigDecimal(500), 1L);

        try {
            this.accountService.withdrawMoney(new BigDecimal(500),2L);
        }catch (InsufficientFundsException e){
            System.out.println(e.getClass().getSimpleName());
        }

this.accountService.transferMoney(new BigDecimal(500),3L);
        this.accountService.transferBetweenAccounts(3L,2L,new BigDecimal(100));
    }
}
