package com.example.json.model.dto;


import com.example.json.model.entity.BaseEntity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class SupplierSeedDto extends BaseEntity {
    @Size(min = 3)
    private String name;

    private Boolean isImporter;


}
