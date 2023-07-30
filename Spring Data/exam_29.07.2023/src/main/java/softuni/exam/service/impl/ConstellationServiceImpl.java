package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ConstellationRepository constellationRepository;

    public ConstellationServiceImpl(ModelMapper mapper,
                                    Gson gson, ValidationUtil validationUtil,
                                    ConstellationRepository constellationRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.constellationRepository = constellationRepository;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() != 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + "constellations.json"));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (constellationRepository.count() == 0) {
            stream(this.gson.fromJson(readConstellationsFromFile(), ConstellationSeedDto[].class))
                    .filter(constellationSeedDto -> {
                                boolean isValid = validationUtil.isValid(constellationSeedDto);
                                boolean isUnique = constellationRepository.findFirstByName(constellationSeedDto.getName()).isEmpty();

                                if (isValid && isUnique) {
                                    stringBuilder.append(String.format("Successfully imported constellation %s - %s",
                                            constellationSeedDto.getName(), constellationSeedDto.getDescription())).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid constellation").append(System.lineSeparator());
                                }
                                return (isValid && isUnique);
                            }
                    )
                    .map(constellationSeedDto -> mapper.map(constellationSeedDto, Constellation.class))
                    .forEach(constellationRepository::save);
        }
        return stringBuilder.toString().trim();
    }

}
