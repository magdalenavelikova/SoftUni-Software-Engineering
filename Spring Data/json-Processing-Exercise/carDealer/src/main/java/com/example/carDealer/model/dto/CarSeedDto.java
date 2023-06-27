package com.example.carDealer.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CarSeedDto {

    @Size(min = 3)
    @XmlElement
    private String make;
    @Size(min = 3)
    @XmlElement
    private String model;
    @Positive
    @XmlElement(name = "travelled-distance")
   private BigInteger travelledDistance;
}
