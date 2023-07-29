package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.OfferService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final OfferService offerService;

    @Autowired
    public ExportController(OfferService offerService) {

        this.offerService = offerService;
    }


    @GetMapping("/best-offers")
    public ModelAndView exportOffersByAreaAndPrice() {
        String offersOrderByAreaThenPrice = this.offerService.exportOffers();

        return super.view("export/export-offers-by-area-then-price.html", "offersByAreaThenPrice", offersOrderByAreaThenPrice);
    }
}
