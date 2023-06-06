package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.ManagerDTO;
import bg.softuni.modelmapper.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class Main implements CommandLineRunner {
    private final EmployeeService employeeService;
    //ModelMapper modelMapper = new ModelMapper();

    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
     /* if i want my fieldName is with custom name

      PropertyMap<Employee,EmployeeDTO> propertyMap=new PropertyMap<Employee, EmployeeDTO>() {
            @Override
            protected void configure() {
                map().setAddressCity(source.getAddress().getCity());
            }
        };
        modelMapper.addMappings(propertyMap);
        ---OR---

         TypeMap<Employee,EmployeeDTO> typeMap=modelMapper.createTypeMap(Employee.class, EmployeeDTO.class);
        typeMap.addMappings(mapper-> mapper.map( Employee::getFirstName, EmployeeDTO::setFirstName));
        typeMap.validate();
        EmployeeDTO employeeDTO = typeMap.map(employee);

        --- if fieldName are the same
          Address address = new Address("Bulgaria", "Sofia");
        Employee employee = new Employee("First", "Last", BigDecimal.valueOf(2000L), address);
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        System.out.println(employeeDTO);

        */

        System.out.println(employeeService.findOne(2L));

        System.out.println(employeeService.findOneManager(2L));
        employeeService.findAllManager().stream().map(ManagerDTO::toString)
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);
    }
}
