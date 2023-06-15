package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.dtos.*;
import bg.softuni.modelmapper.services.EmployeeService;
import bg.softuni.modelmapper.util.FormatConverter;
import bg.softuni.modelmapper.util.FormatConverterFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


@Component
public class Main implements CommandLineRunner {
    private final EmployeeService employeeService;

    //ModelMapper modelMapper = new ModelMapper();
    private final FormatConverterFactory factory;

    public Main(EmployeeService employeeService, FormatConverterFactory factory) {
        this.employeeService = employeeService;

        this.factory = factory;
    }

    @Override
    public void run(String... args) throws Exception {
     /*  fieldName  with custom name

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
//        employeeCreateDto = this.gson.fromJson(new FileReader("src/main/resources/forSeed.json"), EmployeeCreateDto.class);
//        employeeResponseDto = this.employeeService.save(employeeCreateDto);
//        System.out.println();
//        System.out.println(this.gson.toJson(employeeResponseDto));
//
//        System.out.println("====== Save all Employee in Json file =====");
//
//        this.gson.toJson(
//                this.employeeService.findAllManager(),
//                new FileWriter("src/main/resources/all.json")
//
//        );

        /*================== XML LAB ========================================*/

        Scanner sc = new Scanner(System.in);
/* Before we have converter in util
        JAXBContext jaxbContext = JAXBContext.newInstance(ManagerDTO.class, ManagerCollectionDto.class, EmployeeCreateDto.class, EmployeeCollectionDto.class, EmployeeResponseDto.class);
        Marshaller managerMarshaller = jaxbContext.createMarshaller();
        Unmarshaller managerUnmarshaller = jaxbContext.createUnmarshaller();
        managerMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


        System.out.println("====== Find Manager By Id =====");

        System.out.println("Enter Id:");
        Long id = Long.parseLong(sc.nextLine());
        ManagerDTO manager = this.employeeService.findOneManager(id);
        managerMarshaller.marshal(manager, System.out);

        System.out.println("====== Find All Manager  =====");

        ManagerCollectionDto managerCollectionDto = new ManagerCollectionDto(this.employeeService.findAllManagers());
        managerMarshaller.marshal(managerCollectionDto,System.out);

        System.out.println("====== Save new Employee from XML from console =====");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><employee firstName=\"Gosho\" lastName=\"Goshov\" city=\"Sofia\" salary=\"1000.00\"/>");
        System.out.println("Enter valid xml:");

        EmployeeCreateDto employeeCreateDto = (EmployeeCreateDto) managerUnmarshaller.unmarshal(new ByteArrayInputStream(sc.nextLine().getBytes()));
        EmployeeResponseDto employeeResponseDto = this.employeeService.save(employeeCreateDto);
        managerMarshaller.marshal(employeeResponseDto, System.out);

        System.out.println("====== Save new Employee from xml file =====");

        employeeCreateDto = (EmployeeCreateDto) managerUnmarshaller.unmarshal(new FileReader("src/main/resources/forSeed.xml"));
        employeeResponseDto = this.employeeService.save(employeeCreateDto);
        managerMarshaller.marshal(employeeResponseDto, System.out);

        System.out.println("====== Save all Employee in Json file =====");
        List<EmployeeDTO> employees = this.employeeService.findAllEmployees();
        EmployeeCollectionDto employeeCollectionDto = new EmployeeCollectionDto(employees);
        managerMarshaller.marshal(employeeCollectionDto, new FileWriter("src/main/resources/all.xml")

        );
*/
        System.out.println("Enter formatType/json or xml/: ");
        String formatType = sc.nextLine();
        FormatConverter converter = factory.create(formatType);
        converter.setPrettyPrint();

        System.out.println("====== Find Manager By Id =====");

        System.out.println("Enter Id:");
        Long id = Long.parseLong(sc.nextLine());
        ManagerDTO manager = this.employeeService.findOneManager(id);
        System.out.println(converter.serialize(manager));

        System.out.println("====== Find All Manager  =====");

        ManagerCollectionDto managerCollectionDto = new ManagerCollectionDto(this.employeeService.findAllManagers());
        System.out.println(converter.serialize(managerCollectionDto));


        System.out.println("====== Save new Employee from XML from console =====");
        if (formatType.equals("json")) {
            System.out.println("{\"firstName\":\"Daniel\",\"lastName\":\"Sempre\",\"salary\":1100,\"city\":\"Sofia\"}");
        } else {
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><employee firstName=\"Gosho\" lastName=\"Goshov\" city=\"Sofia\" salary=\"1000.00\"/>");
        }
        System.out.println("Enter valid " + formatType + ":");
        String input = sc.nextLine();
        EmployeeCreateDto employeeCreateDto = converter.deserialize(input, EmployeeCreateDto.class);
        EmployeeResponseDto employeeResponseDto = this.employeeService.save(employeeCreateDto);
        System.out.println(converter.serialize(employeeResponseDto));

        System.out.println("====== Save new Employee from xml file =====");

        employeeCreateDto = converter.deserializeFromFile("src/main/resources/forSeed." + formatType, EmployeeCreateDto.class);
        employeeResponseDto = this.employeeService.save(employeeCreateDto);
        System.out.println(converter.serialize(employeeResponseDto));

        System.out.println("====== Save all Employee in Json file =====");
        List<EmployeeDTO> employees = this.employeeService.findAllEmployees();
        EmployeeCollectionDto employeeCollectionDto = new EmployeeCollectionDto(employees);
        converter.serialize(employeeCollectionDto, "src/main/resources/all." + formatType);
    }
}
