package com.example.json.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class PartSeedDto extends BaseEntityDto{
    @Size(min = 3)
    private String name;
    @Positive
    private BigDecimal price;
    @Positive
    private Integer quantity;
}
