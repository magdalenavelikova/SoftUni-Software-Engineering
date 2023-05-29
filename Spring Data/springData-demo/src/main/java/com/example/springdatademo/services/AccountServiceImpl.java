package com.example.springdatademo.services;

import com.example.springdatademo.exeptions.AccountNotFoundException;
import com.example.springdatademo.exeptions.InsufficientFundsException;
import com.example.springdatademo.models.Account;
import com.example.springdatademo.repositories.AccountRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) throws InsufficientFundsException, AccountNotFoundException {
        Account account = this.accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
        throwIfInsufficientFunds(amount, account);
        account.setBalance(account.getBalance().subtract(amount));
        this.accountRepository.save(account);
    }

       @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account account = this.accountRepository.findById(id).orElseThrow();
        account.setBalance(account.getBalance().add(money));
        this.accountRepository.save(account);

    }

    @Override
    @Transactional
    public void transferBetweenAccounts(Long fromId, Long toId, BigDecimal amount) throws InsufficientFundsException, AccountNotFoundException {
        this.transferMoney(amount,toId);
        this.withdrawMoney(amount,fromId);


    }
    private static void throwIfInsufficientFunds(BigDecimal money, Account account) throws InsufficientFundsException {
        if (account.getBalance().compareTo(money) <= 0) {
            throw new InsufficientFundsException();
        }
    }
}
