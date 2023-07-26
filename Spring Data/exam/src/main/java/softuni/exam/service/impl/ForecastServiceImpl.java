package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastWrapperDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_XML;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static final String FILENAME = "forecasts.xml";
    private final ForecastRepository forecastRepository;

    private final CityRepository cityRepository;

    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final ModelMapper mapper;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper mapper) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        if (forecastRepository.count() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(RESOURCES_FILE_PATH_XML + FILENAME));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        if (forecastRepository.count() == 0) {
            ForecastWrapperDto forecastWrapperDto = xmlParser
                    .fromFile(RESOURCES_FILE_PATH_XML + FILENAME, ForecastWrapperDto.class);
            forecastWrapperDto.getForecasts().stream()
                    .filter(forecastSeedDto -> {
                                boolean isValid = validationUtil.isValid(forecastSeedDto);
                                Optional<City> city = cityRepository.findById(forecastSeedDto.getCity());
                                boolean isValidCityId = city.isPresent();
                                boolean isNewRecord = false;
                                if (isValidCityId) {
                                    isNewRecord = forecastRepository.
                                            findByDayOfWeekAndCity(forecastSeedDto.getDayOfWeek(), city.get()).isEmpty();
                                }

                                if (isValid && isValidCityId && isNewRecord) {
                                    stringBuilder.append(String.format("Successfully imported forecast %s - %.0f",
                                                    forecastSeedDto.getDayOfWeek(), forecastSeedDto.getMaxTemperature()))
                                            .append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid forecast").append(System.lineSeparator());
                                }
                                return (isValid && isValidCityId && isNewRecord);
                            }
                    )
                    .map(forecastSeedDto -> {
                                Forecast forecast = mapper.map(forecastSeedDto, Forecast.class);
                                Optional<City> city = cityRepository.findById(forecastSeedDto.getCity());
                                if (city.isPresent()) {
                                    forecast.setCity(city.get());
                                }
                                return forecast;
                            }
                    )
                    .forEach(forecastRepository::save);
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();
        //      •	Filter only forecasts from sunday and from cities with less than 150000 citizens,
//    order them by max temperature in descending order, then by the forecast id in ascending order.

        forecastRepository
                .findAllByDayOfWeekEqualsAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, 150000)
                .stream().forEach(forecast -> {
                    sb.append(String.format("City: %s", forecast.getCity().getCityName())).append(System.lineSeparator());
                    sb.append(String.format("-min temperature: %.2f", forecast.getMinTemperature())).append(System.lineSeparator());
                    sb.append(String.format("--max temperature: %.2f", forecast.getMaxTemperature())).append(System.lineSeparator());
                    sb.append(String.format("---sunrise: %s", forecast.getSunrise())).append(System.lineSeparator());
                    sb.append(String.format("----sunset: %s", forecast.getSunset())).append(System.lineSeparator());


                });




        return sb.toString().trim();
    }
}
