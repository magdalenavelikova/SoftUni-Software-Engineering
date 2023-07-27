package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.TasksService;


@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final TasksService tasksService;

    @Autowired
    public ExportController(TasksService tasksService) {


        this.tasksService = tasksService;
    }


    @GetMapping("/coupe-tasks")
    public ModelAndView exportTasksByTypeOrderByPrice() {
        String tasksByTypeOrderByPrice = this.tasksService.getCoupeCarTasksOrderByPrice();

        return super.view("export/export-tasks-by-type-order-by-price.html", "tasksByTypeOrderByPrice", tasksByTypeOrderByPrice);
    }
}
