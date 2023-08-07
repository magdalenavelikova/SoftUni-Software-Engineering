package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class EmployeeResponseDto extends EmployeeCreateDto {
    @Expose
    private Long id;
}
