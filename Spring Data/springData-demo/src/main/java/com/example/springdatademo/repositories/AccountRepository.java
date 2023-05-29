package com.example.springdatademo.repositories;

import com.example.springdatademo.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
