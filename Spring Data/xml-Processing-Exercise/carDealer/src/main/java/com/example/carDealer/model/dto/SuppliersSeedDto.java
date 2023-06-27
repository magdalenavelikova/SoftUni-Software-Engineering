package com.example.carDealer.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


    @Getter
    @Setter
    @NoArgsConstructor
    @XmlRootElement(name = "suppliers")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class SuppliersSeedDto {
        @XmlElement(name = "supplier")
        private List<SupplierSeedDto> supplierDtoList;


    }

