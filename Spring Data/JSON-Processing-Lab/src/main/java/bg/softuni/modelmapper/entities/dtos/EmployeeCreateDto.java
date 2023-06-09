package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class EmployeeCreateDto extends BaseEmployeeDTO{
    @Expose
    private BigDecimal salary;
}
