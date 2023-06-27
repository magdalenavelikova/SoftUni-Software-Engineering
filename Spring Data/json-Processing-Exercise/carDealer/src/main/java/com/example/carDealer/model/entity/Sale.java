package com.example.carDealer.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private Car car;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    private BigDecimal discount;
}
