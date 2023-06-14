package com.example.json.repository;

import com.example.json.model.entity.Customer;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByOrderByBirthDateAscIsYoungDriverDesc();
    List<Customer> findAllBySalesIsNotNull();
}
