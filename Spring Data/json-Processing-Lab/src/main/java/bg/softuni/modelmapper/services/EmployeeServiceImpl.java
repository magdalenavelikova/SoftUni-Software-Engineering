package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeCreateDto;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeResponseDto;
import bg.softuni.modelmapper.entities.dtos.ManagerDTO;
import bg.softuni.modelmapper.repositories.AddressRepository;
import bg.softuni.modelmapper.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;

        this.modelMapper = modelMapper;
        this.addressRepository = addressRepository;
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
    public ManagerDTO findOneManager(Long id) {
        ;
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (employee.isPresent()) {
            return modelMapper.map(employee, ManagerDTO.class);
        } else {
            throw new IllegalArgumentException("There is no Manager with ID: " + id);
        }

    }

    @Override
    public List<ManagerDTO> findAllManager() {

        return modelMapper.map(
                this.employeeRepository.findAll(),
                new TypeToken<List<ManagerDTO>>() {
                }.getType()
        );

    }

    @Override
    public EmployeeResponseDto save(EmployeeCreateDto employeeCreateDto) {
        Address address = addressRepository.getAddressByCity(employeeCreateDto.getAddressCity());
        if (address == null) {
            address = new Address("Bulgaria", employeeCreateDto.getAddressCity());
            addressRepository.save(address);
        }
        Employee employee = modelMapper.map(employeeCreateDto, Employee.class);
        employee.setAddress(address);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeResponseDto.class);

    }
}
