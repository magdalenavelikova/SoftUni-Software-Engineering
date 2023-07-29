package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.TownService;
import softuni.exam.service.OfferService;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final TownService townService;
    private final OfferService offerService;
    private final AgentService agentService;
    private final ApartmentService apartmentService;

    @Autowired
    public ImportController(TownService townService, OfferService offerService, AgentService agentService, ApartmentService apartmentService) {
        this.townService = townService;
        this.offerService = offerService;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
    }


    @GetMapping("/json")
    public ModelAndView importJson() {

        boolean[] areImported = new boolean[]{
                this.townService.areImported(),
                this.agentService.areImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }


    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.apartmentService.areImported(),
                this.offerService.areImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }


    @GetMapping("/apartments")
    public ModelAndView importApartments() throws IOException {
        String apartmentsXmlFileContent = this.apartmentService.readApartmentsFromFile();
        return super.view("xml/import-apartments", "apartments", apartmentsXmlFileContent);
    }

    @PostMapping("/apartments")
    public ModelAndView importApartmentsConfirm() throws JAXBException, IOException {
        System.out.println(this.apartmentService.importApartments());

        return super.redirect("/import/xml");
    }

    @GetMapping("/offers")
    public ModelAndView importOffers() throws IOException {
        String offersXmlFileContent = this.offerService.readOffersFileContent();

        return super.view("xml/import-offers", "offers", offersXmlFileContent);
    }

    @PostMapping("/offers")
    public ModelAndView importOffersConfirm() throws JAXBException, FileNotFoundException, IOException {
        System.out.println(this.offerService.importOffers());

        return super.redirect("/import/xml");
    }

    @GetMapping("/towns")
    public ModelAndView importTowns() throws IOException {
        String fileContent = this.townService.readTownsFileContent();

        return super.view("json/import-towns", "towns", fileContent);
    }

    @PostMapping("/towns")
    public ModelAndView importTownsConfirm() throws IOException {
        System.out.println(this.townService.importTowns());
        return super.redirect("/import/json");
    }

    @GetMapping("/agents")
    public ModelAndView importAgents() throws IOException {
        String fileContent = this.agentService.readAgentsFromFile();

        return super.view("json/import-agents", "agents", fileContent);
    }

    @PostMapping("/agents")
    public ModelAndView importAgentsConfirm() throws IOException, JAXBException {
        System.out.println(this.agentService.importAgents());
        return super.redirect("/import/json");
    }
}
