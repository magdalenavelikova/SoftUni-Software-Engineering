package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

public class EmployeeResponseDto extends EmployeeCreateDto {
    @Expose
    private Long id;
}
