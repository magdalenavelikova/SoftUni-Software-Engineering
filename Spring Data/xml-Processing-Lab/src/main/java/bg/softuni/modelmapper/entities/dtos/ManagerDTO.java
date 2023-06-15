package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "managers")
@XmlAccessorType(XmlAccessType.FIELD)

public class ManagerDTO extends BaseEmployeeDTO {

    @XmlElementWrapper(name = "subordinates")
    @XmlElement(name = "employee")
    @Expose
    private List<EmployeeDTO> subordinates;

    public ManagerDTO() {

    }


    public List<EmployeeDTO> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeDTO> subordinates) {
        this.subordinates = subordinates;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!subordinates.isEmpty()) {
            stringBuilder.append(super.toString() + " | Employees: " + subordinates.size()).append(System.lineSeparator());
            this.subordinates.stream().forEach(employeeDTO -> stringBuilder.append("    Subordinate: " + employeeDTO.toString()).append(System.lineSeparator()));
        }
        return stringBuilder.toString().trim();
    }
}
