package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.ForecastService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final ForecastService forecastService;

    @Autowired
    public ExportController(ForecastService forecastService) {

        this.forecastService = forecastService;
    }


    @GetMapping("/best-offers")
    public ModelAndView exportOffersByAreaAndPrice() {
        String sundayForecasts = this.forecastService.exportForecasts();

        return super.view("export/export-sunday-forecasts.html", "sundayForecasts", sundayForecasts);
    }
}
