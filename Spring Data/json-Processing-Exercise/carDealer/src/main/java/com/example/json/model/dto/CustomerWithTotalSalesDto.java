package com.example.json.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class CustomerWithTotalSalesDto {
    @SerializedName("fullName")
    String name;
    int boughtCars;
    BigDecimal spentMoney;

}
