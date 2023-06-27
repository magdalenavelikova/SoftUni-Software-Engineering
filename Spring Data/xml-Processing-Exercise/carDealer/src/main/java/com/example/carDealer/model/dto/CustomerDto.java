package com.example.carDealer.model.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDto {
    @SerializedName("Id")
    private Long id;
    @SerializedName("Name")
    private String name;
    @SerializedName("BirthDate")
    @XmlElement(name = "birth-date")
    private String birthDate;
    @SerializedName("IsYoungDriver")
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;
    @SerializedName("Sales")
    @XmlElement(name = "sales")
    private Set<SaleDto> sales;
}
