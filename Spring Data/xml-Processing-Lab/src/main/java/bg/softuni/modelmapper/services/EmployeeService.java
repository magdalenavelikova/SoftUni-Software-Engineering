package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.dtos.EmployeeCreateDto;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeResponseDto;
import bg.softuni.modelmapper.entities.dtos.ManagerDTO;

import java.util.List;


public interface EmployeeService {
    EmployeeDTO findOne(Long id);
    ManagerDTO findOneManager(Long id);

    List<ManagerDTO> findAllManagers();
    List<EmployeeDTO> findAllEmployees();
    EmployeeResponseDto save(EmployeeCreateDto employeeCreateDto);
}
