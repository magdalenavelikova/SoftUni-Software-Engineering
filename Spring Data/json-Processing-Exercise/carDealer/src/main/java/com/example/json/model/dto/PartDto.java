package com.example.json.model.dto;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class PartDto {
    @SerializedName("Name")

    private String name;
    @SerializedName("Price")
    private BigDecimal price;
}
