package com.example.json.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class CarSeedDto {

    @Size(min = 3)
    private String make;
    @Size(min = 3)
    private String model;
    @Positive
   private BigInteger travelledDistance;
}
