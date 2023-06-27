package com.example.carDealer.model.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWithTotalSalesDto {
    @SerializedName("fullName")
    @XmlAttribute(name  ="full-name")
   private String name;
    @XmlAttribute(name = "bought-cars")
   private int boughtCars;
    @XmlAttribute(name = "spent-money")
   private BigDecimal spentMoney;

}
