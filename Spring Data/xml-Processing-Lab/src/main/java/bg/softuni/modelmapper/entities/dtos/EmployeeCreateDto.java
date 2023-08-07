package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeCreateDto extends BaseEmployeeDTO{
    @Expose
    @XmlAttribute
    private BigDecimal salary;

    public EmployeeCreateDto() {
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
