package com.example.json.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Double discount;
}
