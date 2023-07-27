package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicSeedDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

// TODO: Implement all methods
@Service
public class MechanicsServiceImpl implements MechanicsService {

    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final ModelMapper mapper;


    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, PartsRepository partsRepository, Gson gson, ValidationUtil validationUtil, ModelMapper mapper) {
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {

        return mechanicsRepository.count() != 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + "mechanics.json"));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        if (mechanicsRepository.count() == 0) {

            List<MechanicSeedDto> mechanics = stream(this.gson.fromJson(readMechanicsFromFile(), MechanicSeedDto[].class))
                    .collect(Collectors.toList());

            mechanics.stream().filter(mechanicSeedDto -> {
                        boolean isValid = validationUtil.isValid(mechanicSeedDto);
                        boolean isUnique = mechanicsRepository.
                                findByFirstNameOrPhoneOrEmail(
                                        mechanicSeedDto.getFirstName(),
                                        mechanicSeedDto.getPhone(),
                                        mechanicSeedDto.getEmail()
                                ).isEmpty();

                        if (isValid && isUnique) {
                            stringBuilder.append(String.format("Successfully imported mechanic %s %s",
                                    mechanicSeedDto.getFirstName(), mechanicSeedDto.getLastName())).append(System.lineSeparator());
                        } else {
                            stringBuilder.append("Invalid mechanic").append(System.lineSeparator());
                        }
                        return (isValid && isUnique);

                    })
                    .map(mechanicSeedDto -> mapper.map(mechanicSeedDto, Mechanic.class))
                    .forEach(mechanicsRepository::save);
        }
        return stringBuilder.toString().trim();
    }
}
