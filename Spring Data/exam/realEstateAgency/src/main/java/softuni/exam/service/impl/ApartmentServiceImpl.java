package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentWrapperDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_XML;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private static String APARTMENTS_FILE_PATH = RESOURCES_FILE_PATH_XML + "apartments.xml";
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil, TownRepository townRepository) {
        this.apartmentRepository = apartmentRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() != 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        if (apartmentRepository.count() == 0) {
            xmlParser
                    .fromFile(APARTMENTS_FILE_PATH, ApartmentWrapperDto.class)
                    .getApartments().stream()
                    .filter(apartmentSeedDto -> {
                                {
                                    boolean isValid = validationUtil.isValid(apartmentSeedDto);
                                    boolean isValidTown =
                                            townRepository.findFirstByTownName(apartmentSeedDto.getTown())
                                                    .isPresent();
                                    boolean isUnique = apartmentRepository.
                                            findFirstByTown_TownNameAndArea(apartmentSeedDto.getTown(),
                                                    apartmentSeedDto.getArea()).isEmpty();


                                    if (isValid && isUnique && isValidTown) {
                                        stringBuilder.append(String.format("Successfully imported apartment %s - %s",
                                                        apartmentSeedDto.getApartmentType(), apartmentSeedDto.getArea()))
                                                .append(System.lineSeparator());
                                    } else {
                                        stringBuilder.append("Invalid apartment").append(System.lineSeparator());
                                    }
                                    return (isValid && isUnique && isValidTown);
                                }
                            }
                    )
                    .map(apartmentSeedDto -> {
                                Apartment apartment = mapper.map(apartmentSeedDto, Apartment.class);
                                apartment.setTown(townRepository.findFirstByTownName(
                                                apartmentSeedDto.getTown())
                                        .get());
                                return apartment;
                            }
                    )
                    .forEach(apartmentRepository::save);
        }

        return stringBuilder.toString().trim();
    }
}
