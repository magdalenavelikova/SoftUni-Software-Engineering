package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final ModelMapper mapper;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper mapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() != 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
         return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + "towns.json"));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        if (townRepository.count() == 0) {
            stream(this.gson.fromJson(readTownsFileContent(), TownSeedDto[].class))
                    .filter(townSeedDto -> {
                                boolean isValid = validationUtil.isValid(townSeedDto);
                                boolean isUnique = townRepository.findFirstByTownName(townSeedDto.getTownName()).isEmpty();

                                if (isValid && isUnique) {
                                    stringBuilder.append(String.format("Successfully imported town %s - %s",
                                            townSeedDto.getTownName(), townSeedDto.getPopulation())).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid town").append(System.lineSeparator());
                                }
                                return (isValid && isUnique);
                            }
                    )
                    .map(townSeedDto -> mapper.map(townSeedDto, Town.class))
                    .forEach(townRepository::save);
        }
        return stringBuilder.toString().trim();
    }

}
