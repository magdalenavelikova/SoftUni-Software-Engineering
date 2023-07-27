package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartSeedDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

// TODO: Implement all methods
@Service
public class PartsServiceImpl implements PartsService {

    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final ModelMapper mapper;

    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ValidationUtil validationUtil, ModelMapper mapper) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() != 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + "parts.json"));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        if (partsRepository.count() == 0) {
            stream(this.gson.fromJson(readPartsFileContent(), PartSeedDto[].class))
                    .filter(partSeedDto -> {
                                boolean isValid = validationUtil.isValid(partSeedDto);
                                boolean isUnique = partsRepository.findByPartName(partSeedDto.getPartName()).isEmpty();

                                if (isValid && isUnique) {
                                    stringBuilder.append(String.format("Successfully imported part %s - %s",
                                            partSeedDto.getPartName(), partSeedDto.getPrice())).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid part").append(System.lineSeparator());
                                }
                                return (isValid && isUnique);
                            }
                    )
                    .map(partSeedDto -> mapper.map(partSeedDto, Part.class))
                    .forEach(partsRepository::save);
        }
        return stringBuilder.toString().trim();
    }
}

