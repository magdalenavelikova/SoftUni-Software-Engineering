package bg.softuni.modelmapper.entities.dtos;

import java.math.BigDecimal;

public class EmployeeDTO extends BaseEmployeeDTO{

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
