package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.service.CountryService;

@Controller
public class HomeController extends BaseController {

    private final CityService cityService;
    private final ForecastService forecastService;
    private final CountryService countryService;

    @Autowired
    public HomeController(CityService cityService, ForecastService forecastService, CountryService countryService) {
        this.cityService = cityService;
        this.forecastService = forecastService;
        this.countryService = countryService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.cityService.areImported() &&
                this.countryService.areImported() &&
                this.cityService.areImported() &&
                this.forecastService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
