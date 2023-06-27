package com.example.carDealer.repository;

import com.example.carDealer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByOrderByBirthDateAscIsYoungDriverDesc();
    List<Customer> findAllBySalesIsNotNull();
}
