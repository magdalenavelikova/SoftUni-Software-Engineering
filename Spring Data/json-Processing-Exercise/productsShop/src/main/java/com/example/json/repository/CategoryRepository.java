package com.example.json.repository;

import com.example.json.model.dto.CategoryProductsSummaryDto;
import com.example.json.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT new com.example.json.model.dto.CategoryProductsSummaryDto" +
            "(c.name, count (p.id), avg(p.price), sum(p.price))" +
            "from Product  p " +
            "JOIN p.categories c " +
            "group by c.id " +
            "order by count (p.id)"

    )
    Optional<List<CategoryProductsSummaryDto>> getCategorySummary();
}
