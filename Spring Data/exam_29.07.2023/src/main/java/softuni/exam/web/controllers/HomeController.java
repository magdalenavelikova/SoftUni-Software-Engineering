package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;

@Controller
public class HomeController extends BaseController {

    private final StarService starService;
    private final AstronomerService astronomerService;
    private final ConstellationService constellationService;

    @Autowired
    public HomeController(StarService starService,ConstellationService constellationService,AstronomerService astronomerService) {
        this.starService = starService;
        this.astronomerService = astronomerService;
        this.constellationService = constellationService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.starService.areImported() &&
                this.constellationService.areImported() &&
                this.starService.areImported()  &&
                this.astronomerService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
