package bg.softuni.kotlin.kotlin.web

import bg.softuni.kotlin.kotlin.service.GreeterService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class GreeterController(val greeterService: GreeterService) {

    @GetMapping("/greet")
    fun greet(@RequestParam(name="name") name : String,
        model: Model) : String {

        model.addAttribute("greeting", greeterService.generateGreeting(name))

        return "greet"
    }

}