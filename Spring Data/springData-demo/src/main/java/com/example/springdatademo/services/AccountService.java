package com.example.springdatademo.services;

import com.example.springdatademo.exeptions.AccountNotFoundException;
import com.example.springdatademo.exeptions.InsufficientFundsException;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal money, Long id) throws InsufficientFundsException, AccountNotFoundException;
    void transferMoney(BigDecimal money, Long id);
    void transferBetweenAccounts(Long from, Long to,BigDecimal amount) throws InsufficientFundsException, AccountNotFoundException;
}
