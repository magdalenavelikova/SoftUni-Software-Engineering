package bg.softuni.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

  @GetMapping("/hello/{id}/test")
  public String hello(Model model,
                      @PathVariable("id") Integer id) {
    model.addAttribute("num", id);
    return "hello";
  }
}
