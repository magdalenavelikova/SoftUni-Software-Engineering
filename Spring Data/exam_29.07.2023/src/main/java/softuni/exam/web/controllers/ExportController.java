package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.StarService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final StarService starService;

    @Autowired
    public ExportController(StarService starService) {
        this.starService = starService;
    }


    @GetMapping("/red-giant-stars")
    public ModelAndView exportNonObservedStarsByDistanceAsc() {
        String exportedStars = this.starService.exportStars();

        return super.view("export/export-red-giant-stars.html", "exportedStars", exportedStars);
    }
}
