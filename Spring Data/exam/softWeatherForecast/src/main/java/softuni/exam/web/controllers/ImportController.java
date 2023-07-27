package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.excetption.UnableToConvertException;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.service.CountryService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final CityService cityService;
    private final ForecastService forecastService;
    private final CountryService countryService;

    @Autowired
    public ImportController(CityService cityService, ForecastService forecastService, CountryService countryService) {
        this.cityService = cityService;
        this.forecastService = forecastService;
        this.countryService = countryService;
    }


    @GetMapping("/json")
    public ModelAndView importJson() {

        boolean[] areImported = new boolean[]{
                this.countryService.areImported(),
                this.cityService.areImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }


    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.forecastService.areImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }


    @GetMapping("/forecasts")
    public ModelAndView importForecasts() throws IOException {
        String apartmentsXmlFileContent = this.forecastService.readForecastsFromFile();
        return super.view("xml/import-forecasts", "forecasts", apartmentsXmlFileContent);
    }

    @PostMapping("/forecasts")
    public ModelAndView importForecastsConfirm() throws JAXBException, IOException {
        System.out.println(this.forecastService.importForecasts());

        return super.redirect("/import/xml");
    }

    @GetMapping("/offers")
    public ModelAndView importOffers() throws IOException {
        String offersXmlFileContent = this.forecastService.readForecastsFromFile();

        return super.view("xml/import-offers", "offers", offersXmlFileContent);
    }

    @PostMapping("/offers")
    public ModelAndView importOffersConfirm() throws JAXBException, FileNotFoundException, IOException {
        System.out.println(this.forecastService.importForecasts());

        return super.redirect("/import/xml");
    }

    @GetMapping("/countries")
    public ModelAndView importCountries() throws IOException, UnableToConvertException {
        String fileContent = this.countryService.readCountriesFromFile();

        return super.view("json/import-countries", "countries", fileContent);
    }

    @PostMapping("/countries")
    public ModelAndView importCountriesConfirm() throws IOException, UnableToConvertException {
        System.out.println(this.countryService.importCountries());
        return super.redirect("/import/json");
    }

    @GetMapping("/cities")
    public ModelAndView importCities() throws IOException {
        String fileContent = this.cityService.readCitiesFileContent();

        return super.view("json/import-cities", "cities", fileContent);
    }

    @PostMapping("/cities")
    public ModelAndView importCitiesConfirm() throws IOException, JAXBException {
        System.out.println(this.cityService.importCities());
        return super.redirect("/import/json");
    }
}
