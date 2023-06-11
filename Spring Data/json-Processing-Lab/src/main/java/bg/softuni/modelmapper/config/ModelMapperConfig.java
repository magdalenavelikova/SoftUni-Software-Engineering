package bg.softuni.modelmapper.config;
import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeCreateDto;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Employee, EmployeeDTO>() {
            @Override
            protected void configure() {
                map().setAddressCity(source.getAddress().getCity());

            }
        });


        return modelMapper;
    }
}
