package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarSeedDto;
import softuni.exam.models.entity.Star;
import softuni.exam.models.enums.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

@Service
public class StarServiceImpl implements StarService {
    private final StarRepository starRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ConstellationRepository constellationRepository;

    public StarServiceImpl(StarRepository starRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil, ConstellationRepository constellationRepository) {
        this.starRepository = starRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.constellationRepository = constellationRepository;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() != 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + "stars.json"));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (starRepository.count() == 0) {
            stream(this.gson.fromJson(readStarsFileContent(), StarSeedDto[].class))
                    .filter(starSeedDto -> {
                                boolean isValid = validationUtil.isValid(starSeedDto);
                                boolean isUnique = starRepository.findFirstByName(starSeedDto.getName()).isEmpty();

                                if (isValid && isUnique) {
                                    stringBuilder.append(String.format("Successfully imported star %s - %.2f light years",
                                            starSeedDto.getName(), starSeedDto.getLightYears())).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid star").append(System.lineSeparator());
                                }
                                return (isValid && isUnique);
                            }
                    )
                    .map(starSeedDto -> {
                        Star star = mapper.map(starSeedDto, Star.class);
                        star.setConstellation(constellationRepository.findById(starSeedDto.getConstellation()).get());
                        return star;
                    })
                    .forEach(starRepository::save);
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String exportStars() {
        StringBuilder sb = new StringBuilder();

        starRepository.findNotObservedStars(0, StarType.RED_GIANT).stream().forEach(star -> {
            sb.append(String.format("Star: %s",
                    star.getName())).append(System.lineSeparator());
            sb.append(String.format("   *Distance: %.2f light years",
                    star.getLightYears())).append(System.lineSeparator());
            sb.append(String.format("   **Description: %s",
                    star.getDescription())).append(System.lineSeparator());
            sb.append(String.format("   ***Constellation: %s",
                    star.getConstellation().getName())).append(System.lineSeparator());


        });

        return sb.toString().trim();
    }
}
