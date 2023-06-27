package com.example.carDealer.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

//@JsonPropertyOrder({"make", "model", "travelledDistance"})
public class CarBasicDto {
    @SerializedName("Make")
    @XmlAttribute
    private String make;

    @SerializedName("Model")
    @XmlAttribute
    private String model;

    @SerializedName("TravelledDistance")
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;

}
