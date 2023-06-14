


package com.example.json.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {


    private String make;
    private String model;
    @Column(name = "travelled_distance")
    private BigInteger travelledDistance;
   @ManyToMany(fetch = FetchType.EAGER)
    private Set<Part> parts;


}

