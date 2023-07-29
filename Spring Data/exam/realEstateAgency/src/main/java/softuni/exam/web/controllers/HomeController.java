package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.TownService;
import softuni.exam.service.OfferService;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;

@Controller
public class HomeController extends BaseController {

    private final TownService townService;
    private final OfferService offerService;
    private final AgentService agentService;
    private final ApartmentService apartmentService;

    @Autowired
    public HomeController(TownService townService, OfferService offerService, AgentService agentService, ApartmentService apartmentService) {
        this.townService = townService;
        this.offerService = offerService;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.townService.areImported() &&
                this.offerService.areImported() &&
                this.agentService.areImported() &&
                this.apartmentService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
