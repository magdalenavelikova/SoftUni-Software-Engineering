package com.example.json.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
    @SerializedName("Id")
    private Long id;
    @SerializedName("Name")
    private String name;
    @SerializedName("BirthDate")
    private String birthDate;
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;
    @SerializedName("Sales")
    private Set<SaleDto> sales;
}
