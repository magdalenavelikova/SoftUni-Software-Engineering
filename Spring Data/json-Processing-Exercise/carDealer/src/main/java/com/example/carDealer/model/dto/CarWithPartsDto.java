package com.example.carDealer.model.dto;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@JsonPropertyOrder({"make", "model", "travelledDistance", "parts"})
public class CarWithPartsDto  {
    @SerializedName("Make")
    @XmlAttribute
    private String make;

    @SerializedName("Model")
    @XmlAttribute
    private String model;

    @SerializedName("TravelledDistance")
    @XmlAttribute(name="travelled-distance")
    private BigInteger travelledDistance;
    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartDto> parts;
}
