package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.excetption.UnableToConvertException;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String FILENAME = "countries.json";
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CountryRepository countryRepository;

    public CountryServiceImpl(
            ModelMapper mapper, Gson gson, ValidationUtil validationUtil,
            CountryRepository countryRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        if (countryRepository.count() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public String readCountriesFromFile() throws IOException {

        return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + FILENAME));
    }


    @Override
    public String importCountries() throws IOException, UnableToConvertException {
        StringBuilder stringBuilder = new StringBuilder();

        if (countryRepository.count() == 0) {
            stream(this.gson.fromJson(readCountriesFromFile(), CountrySeedDto[].class)
            ).toList().stream()
                    .filter(countrySeedDto -> {
                                boolean isValid = validationUtil.isValid(countrySeedDto);
                                boolean isUnique = countryRepository.findByCountryName(countrySeedDto.getCountryName()) == null;
                                if (isValid && isUnique) {
                                    stringBuilder.append(String.format("Successfully imported country %s - %s",
                                            countrySeedDto.getCountryName(), countrySeedDto.getCurrency())).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid country").append(System.lineSeparator());
                                }
                                return isValid && isUnique;
                            }
                    )
                    .map(countrySeedDto -> mapper.map(countrySeedDto, Country.class))
                    .forEach(countryRepository::save);
        }
        return stringBuilder.toString().trim();
    }


}
