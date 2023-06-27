package com.example.carDealer.model.dto;


import com.example.carDealer.model.entity.BaseEntity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class SupplierSeedDto extends BaseEntity {
    @Size(min = 3)
    @XmlAttribute
    private String name;
@XmlAttribute(name = "is-importer")
    private Boolean isImporter;


}
