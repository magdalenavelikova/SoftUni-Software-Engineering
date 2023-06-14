package com.example.json.model.dto;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@JsonPropertyOrder({"make", "model", "travelledDistance", "parts"})
public class CarWithPartsDto  {
    @SerializedName("Make")
    private String make;

    @SerializedName("Model")
    private String model;

    @SerializedName("TravelledDistance")
    private BigInteger travelledDistance;
     Set<PartDto> parts;
}
