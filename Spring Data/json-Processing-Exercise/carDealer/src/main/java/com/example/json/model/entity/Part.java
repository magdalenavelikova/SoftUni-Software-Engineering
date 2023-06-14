package com.example.json.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
    private String name;
    private BigDecimal price;
    private Integer quantity;
    @ManyToOne
    private Supplier supplier;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return id == part.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
