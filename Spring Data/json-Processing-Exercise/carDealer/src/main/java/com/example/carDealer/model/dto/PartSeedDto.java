package com.example.carDealer.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedDto extends BaseEntityDto{
    @Size(min = 3)
    @XmlAttribute
    private String name;
    @Positive
    @XmlAttribute
    private BigDecimal price;
    @Positive
    @XmlAttribute
    private Integer quantity;
}
