package com.example.json.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class CarDto {
    @SerializedName("Id")
    private Long id;
    @SerializedName("Make")
    private String make;
    @SerializedName("Model")
    private String model;
    @SerializedName("TravelledDistance")

    private BigInteger travelledDistance;
}
