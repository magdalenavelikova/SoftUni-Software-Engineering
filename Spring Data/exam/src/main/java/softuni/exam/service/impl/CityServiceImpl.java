package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private static final String FILENAME = "cities.json";
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        if (cityRepository.count() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + FILENAME));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        if (cityRepository.count() == 0) {
            stream(this.gson.fromJson(readCitiesFileContent(), CitySeedDto[].class)
            ).toList().stream()
                    .filter(citySeedDto -> {
                                boolean isValid = validationUtil.isValid(citySeedDto);
                                boolean isUnique = cityRepository.findByCityName(citySeedDto.getCityName()) == null;
                                boolean isValidCountryId = countryRepository.findById(citySeedDto.getCountry()).isPresent();
                                if (isValid && isUnique && isValidCountryId) {
                                    stringBuilder.append(String.format("Successfully imported city %s - %d",
                                            citySeedDto.getCityName(), citySeedDto.getPopulation())).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid city").append(System.lineSeparator());
                                }
                                return (isValid && isUnique && isValidCountryId);
                            }
                    )
                    .map(citySeedDto -> {
                                City city = mapper.map(citySeedDto, City.class);
                                Optional<Country> country = countryRepository.findById(citySeedDto.getCountry());
                                if (country.isPresent()) {
                                    city.setCountry(country.get());
                                }
                                return city;
                            }

                    )
                    .forEach(cityRepository::save);
        }
        return stringBuilder.toString().trim();
    }
}
