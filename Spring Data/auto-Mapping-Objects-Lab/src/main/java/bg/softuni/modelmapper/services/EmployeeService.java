package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.ManagerDTO;

import java.util.List;


public interface EmployeeService {
    EmployeeDTO findOne(Long id);
    ManagerDTO findOneManager(Long id);

    List<ManagerDTO> findAllManager();
}
