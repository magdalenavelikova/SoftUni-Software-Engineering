package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.PartsService;
import softuni.exam.service.TasksService;
import softuni.exam.service.MechanicsService;
import softuni.exam.service.CarsService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final PartsService partsService;
    private final TasksService tasksService;
    private final MechanicsService mechanicsService;
    private final CarsService carsService;

    @Autowired
    public ImportController(PartsService partsService, TasksService tasksService, MechanicsService mechanicsService, CarsService carsService) {
        this.partsService = partsService;
        this.tasksService = tasksService;
        this.mechanicsService = mechanicsService;
        this.carsService = carsService;
    }


    @GetMapping("/json")
    public ModelAndView importJson() {

        boolean[] areImported = new boolean[]{
                this.partsService.areImported(),
                this.mechanicsService.areImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }


    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.carsService.areImported(),
                this.tasksService.areImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }


    @GetMapping("/cars")
    public ModelAndView importCars() throws IOException {
        String carsXmlFileContent = this.carsService.readCarsFromFile();
        return super.view("xml/import-cars", "cars", carsXmlFileContent);
    }

    @PostMapping("/cars")
    public ModelAndView importCarsConfirm() throws JAXBException, IOException {
        System.out.println(this.carsService.importCars());

        return super.redirect("/import/xml");
    }

    @GetMapping("/tasks")
    public ModelAndView importTasks() throws IOException {
        String tasksXmlFileContent = this.tasksService.readTasksFileContent();

        return super.view("xml/import-tasks", "tasks", tasksXmlFileContent);
    }

    @PostMapping("/tasks")
    public ModelAndView importTasksConfirm() throws JAXBException, FileNotFoundException, IOException {
        System.out.println(this.tasksService.importTasks());

        return super.redirect("/import/xml");
    }

    @GetMapping("/parts")
    public ModelAndView importParts() throws IOException {
        String fileContent = this.partsService.readPartsFileContent();

        return super.view("json/import-parts", "parts", fileContent);
    }

    @PostMapping("/parts")
    public ModelAndView importPartsConfirm() throws IOException {
        System.out.println(this.partsService.importParts());
        return super.redirect("/import/json");
    }

    @GetMapping("/mechanics")
    public ModelAndView importMechanics() throws IOException {
        String fileContent = this.mechanicsService.readMechanicsFromFile();

        return super.view("json/import-mechanics", "mechanics", fileContent);
    }

    @PostMapping("/mechanics")
    public ModelAndView importMechanicsConfirm() throws IOException, JAXBException {
        System.out.println(this.mechanicsService.importMechanics());
        return super.redirect("/import/json");
    }
}
