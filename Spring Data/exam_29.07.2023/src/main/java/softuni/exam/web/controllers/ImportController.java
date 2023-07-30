package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final StarService starService;
    private final AstronomerService astronomerService;
    private final ConstellationService constellationService;

    @Autowired
    public ImportController(StarService starService, ConstellationService constellationService,AstronomerService astronomerService) {
        this.starService = starService;
        this.astronomerService = astronomerService;
        this.constellationService = constellationService;
    }


    @GetMapping("/json")
    public ModelAndView importJson() {

        boolean[] areImported = new boolean[]{
                this.constellationService.areImported(),
                this.starService.areImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }


    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.astronomerService.areImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }


    @GetMapping("/astronomers")
    public ModelAndView importAstronomers() throws IOException {
        String astronomersXmlFileContent = this.astronomerService.readAstronomersFromFile();

        return super.view("xml/import-astronomers", "astronomers", astronomersXmlFileContent);
    }

    @PostMapping("/astronomers")
    public ModelAndView importAstronomersConfirm() throws JAXBException, IOException {
        System.out.println(this.astronomerService.importAstronomers());

        return super.redirect("/import/xml");
    }

    @GetMapping("/constellations")
    public ModelAndView importConstellations() throws IOException {
        String fileContent = this.constellationService.readConstellationsFromFile();

        return super.view("json/import-constellations", "constellations", fileContent);
    }

    @PostMapping("/constellations")
    public ModelAndView importConstellationsConfirm() throws IOException {
        System.out.println(this.constellationService.importConstellations());
        return super.redirect("/import/json");
    }

    @GetMapping("/stars")
    public ModelAndView importStars() throws IOException {
        String fileContent = this.starService.readStarsFileContent();

        return super.view("json/import-stars", "stars", fileContent);
    }

    @PostMapping("/stars")
    public ModelAndView importStarsConfirm() throws IOException, JAXBException {
        System.out.println(this.starService.importStars());
        return super.redirect("/import/json");
    }
}
