package com.example.springdatademo.repositories;

import com.example.springdatademo.models.Account;
import com.example.springdatademo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);
}
