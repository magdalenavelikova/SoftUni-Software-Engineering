package bg.softuni.modelmapper.entities.dtos;

import java.util.ArrayList;
import java.util.List;

public class ManagerDTO extends BaseEmployeeDTO {

    private List<EmployeeDTO> subordinates;

    public ManagerDTO() {
        this.subordinates = new ArrayList<>();
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
