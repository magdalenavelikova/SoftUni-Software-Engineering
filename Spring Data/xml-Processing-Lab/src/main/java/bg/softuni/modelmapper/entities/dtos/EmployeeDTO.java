package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"firstName", "lastName", "addressCity","salary"})
public class EmployeeDTO extends BaseEmployeeDTO{
@Expose
@XmlAttribute
    private BigDecimal salary;


    public EmployeeDTO() {
    }



    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return super.toString() + " Salary: " +this.getSalary();
    }
}
