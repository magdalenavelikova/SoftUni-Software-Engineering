package com.example.json.repository;

import com.example.json.model.entity.Part;
import com.example.json.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
}
