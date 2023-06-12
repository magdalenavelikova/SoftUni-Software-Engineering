package com.example.json.repository;

import com.example.json.model.dto.UsersAndProductsDto;
import com.example.json.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u " +
            "JOIN u.soldProducts p "+
            "WHERE   p.buyer IS NOT NULL" +
            " order by u.lastName,u.firstName"
    )

    List<User> findAllBySoldProducts();

  //  List<User> findAllBySoldProductsBuyerIsNotNull();


    @Query("SELECT u " +
            "FROM User u " +
            "JOIN u.soldProducts p " +
            "WHERE p.buyer IS NOT NULL " +
            "order by size(u.soldProducts) DESC, u.lastName ")
    Optional<List<User>> usersAndProducts();



}
