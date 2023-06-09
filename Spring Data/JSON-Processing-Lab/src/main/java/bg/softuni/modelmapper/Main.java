package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.dtos.EmployeeCreateDto;
import bg.softuni.modelmapper.entities.dtos.EmployeeResponseDto;
import bg.softuni.modelmapper.entities.dtos.ManagerDTO;
import bg.softuni.modelmapper.services.EmployeeService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;


@Component
public class Main implements CommandLineRunner {
    private final EmployeeService employeeService;
    private final Gson gson;
    //ModelMapper modelMapper = new ModelMapper();

    public Main(EmployeeService employeeService, Gson gson) {
        this.employeeService = employeeService;
        this.gson = gson;
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

      /*  System.out.println(employeeService.findOne(2L));

        System.out.println(employeeService.findOneManager(2L));
        employeeService.findAllManager().stream().map(ManagerDTO::toString)
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);
        */

        /*================== JSON LAB ========================================*/

//        Scanner sc = new Scanner(System.in);
//        System.out.println("====== Find Manager By Id =====");
//        System.out.println("Enter Id:");
//        Long id = Long.parseLong(sc.nextLine());
//
//        ManagerDTO manager = this.employeeService.findOneManager(id);
//        String toJson = this.gson.toJson(manager);
//        System.out.println(toJson);
//
//        System.out.println("====== Find All Manager  =====");
//        List<ManagerDTO> allManager = this.employeeService.findAllManager();
//        toJson = this.gson.toJson(allManager);
//        System.out.println(toJson);
//
//
//        System.out.println("====== Save new Employee from Json from console =====");
//        System.out.println("{\"firstName\":\"Daniel\",\"lastName\":\"Sempre\",\"salary\":1100,\"city\":\"Sofia\"}");
//        System.out.println("Enter valid json:");
//        String json = sc.nextLine();
//        EmployeeCreateDto employeeCreateDto = this.gson.fromJson(json, EmployeeCreateDto.class);
//        EmployeeResponseDto employeeResponseDto = this.employeeService.save(employeeCreateDto);
//        System.out.println(this.gson.toJson(employeeResponseDto));
//
//        System.out.println("====== Save new Employee from Json file =====");
//
//        employeeCreateDto = this.gson.fromJson(new FileReader("src/main/resources/test.json"), EmployeeCreateDto.class);
//        employeeResponseDto = this.employeeService.save(employeeCreateDto);
//        System.out.println();
//        System.out.println(this.gson.toJson(employeeResponseDto));

        System.out.println("====== Save all Employee in Json file =====");

        this.gson.toJson(
                this.employeeService.findAllManager(),
                new FileWriter("src/main/resources/all.json")

        );

    }
}
