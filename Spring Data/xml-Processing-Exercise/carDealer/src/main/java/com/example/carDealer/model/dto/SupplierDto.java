package com.example.carDealer.model.dto;


import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierDto {
    @SerializedName("Id")
    @XmlAttribute
    private Long id;
    @SerializedName("Name")
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "parts-count")
    private int partsCount;
}
