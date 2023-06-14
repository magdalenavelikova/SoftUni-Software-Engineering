package com.example.json.model.dto;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SaleDto {
    private CarBasicDto car;
    @SerializedName("customerName")
    String name;
    @SerializedName("Discount")
    private Double discount;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;

}
