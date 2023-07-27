package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarWrapperDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_XML;

// TODO: Implement all methods
@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = RESOURCES_FILE_PATH_XML + "cars.xml";

    private final CarsRepository carsRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public CarsServiceImpl(CarsRepository carsRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.carsRepository = carsRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() != 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        if (carsRepository.count() == 0) {
            xmlParser
                    .fromFile(CARS_FILE_PATH, CarWrapperDto.class)
                    .getCars().stream()
                    .filter(carSeedDto -> {
                                {
                                    boolean isValid = validationUtil.isValid(carSeedDto);

                                    boolean isUnique = carsRepository.
                                            findFirstByPlateNumber(carSeedDto.getPlateNumber()).isEmpty();


                                    if (isValid && isUnique) {
                                        stringBuilder.append(String.format("Successfully imported car %s - %s",
                                                        carSeedDto.getCarMake(), carSeedDto.getCarModel()))
                                                .append(System.lineSeparator());
                                    } else {
                                        stringBuilder.append("Invalid car").append(System.lineSeparator());
                                    }
                                    return (isValid && isUnique);
                                }
                            }
                    )
                    .map(carsSeedDto -> mapper.map(carsSeedDto, Car.class)
                    )
                    .forEach(carsRepository::save);
        }

        return stringBuilder.toString().trim();
    }
}