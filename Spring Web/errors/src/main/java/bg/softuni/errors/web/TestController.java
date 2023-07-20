package bg.softuni.errors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/testnpe")
  public String testNPE() {
    if (true) {
      throw new NullPointerException("npe");
    }
    return "npe";
  }
}
