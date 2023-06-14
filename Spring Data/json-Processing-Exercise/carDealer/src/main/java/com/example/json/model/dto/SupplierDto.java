package com.example.json.model.dto;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SupplierDto {
    @SerializedName("Id")
    private Long id;
    @SerializedName("Name")
    private String name;
    private int partsCount;
}
