package com.example.json.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CustomerSeedDto {
    @Size(min = 3)
    private String name;
    @NotBlank
    private String birthDate;

    private boolean isYoungDriver;
}
