package com.example.json.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor


//@JsonPropertyOrder({"make", "model", "travelledDistance"})
public class CarBasicDto {
    @SerializedName("Make")
    private String make;

    @SerializedName("Model")
    private String model;

    @SerializedName("TravelledDistance")
    private BigInteger travelledDistance;

}
