package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.ManagerDTO;
import bg.softuni.modelmapper.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDTO findOne(Long id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (employee.isPresent()) {
            return modelMapper.map(employee, EmployeeDTO.class);
        } else {
            throw new IllegalArgumentException("There is no Employee with ID: " + id);
        }

    }

    @Override
    public ManagerDTO findOneManager(Long id) {;
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (employee.isPresent()) {
            return modelMapper.map(employee, ManagerDTO.class);
        } else {
            throw new IllegalArgumentException("There is no Manager with ID: " + id);
        }

    }

    @Override
    public List<ManagerDTO> findAllManager() {

      return  modelMapper.map(
              this.employeeRepository.findAll(),
              new TypeToken<List<ManagerDTO>>(){}.getType()
        );

    }
}
