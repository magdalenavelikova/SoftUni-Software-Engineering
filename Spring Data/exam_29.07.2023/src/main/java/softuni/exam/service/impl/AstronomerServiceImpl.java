package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerWrapperDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_XML;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private static String ASTRONOMERS_FILE_PATH = RESOURCES_FILE_PATH_XML + "astronomers.xml";
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;

    public AstronomerServiceImpl(ModelMapper mapper, XmlParser xmlParser,
                                 ValidationUtil validationUtil, AstronomerRepository astronomerRepository, StarRepository starRepository) {
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() != 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
//        •	If an astronaut with the same full name (first name and last name) already exists in the DB return "Invalid astronomer".
//•	If an astronaut is observing star that doesn't exist in the DB return "Invalid astronomer ".
        StringBuilder stringBuilder = new StringBuilder();
        if (astronomerRepository.count() == 0) {
            AstronomerWrapperDto astronomerWrapperDto = xmlParser
                    .fromFile(ASTRONOMERS_FILE_PATH, AstronomerWrapperDto.class);
            astronomerWrapperDto.getAstronomers().stream()
                    .filter(astronomerSeedDto -> {
                                boolean isValid = validationUtil.isValid(astronomerSeedDto);
                                boolean isValidAstronaut = astronomerRepository.findFirstByFirstNameAndLastName(astronomerSeedDto.getFirstName(),
                                        astronomerSeedDto.getLastName()).isEmpty();
                                boolean isValidStar =
                                        starRepository.findById(astronomerSeedDto.getObservingStarId())
                                                .isPresent();
                                if (isValid && isValidStar && isValidAstronaut) {
                                    stringBuilder.append(String.format("Successfully imported astronomer %s %s - %.2f",
                                                    astronomerSeedDto.getFirstName()
                                                    , astronomerSeedDto.getLastName()
                                                    , astronomerSeedDto.getAverageObservationHours()))
                                            .append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid astronomer").append(System.lineSeparator());
                                }
                                return (isValid && isValidStar && isValidAstronaut);
                            }
                    )
                    .map(astronomerSeedDto -> {
                                Astronomer astronomer = mapper.map(astronomerSeedDto, Astronomer.class);
                                astronomer.setObservingStar(starRepository.findById(astronomerSeedDto.getObservingStarId()).get());

                                return astronomer;
                            }
                    )
                    .forEach(astronomerRepository::save);
        }

        return stringBuilder.toString().trim();

    }
}
