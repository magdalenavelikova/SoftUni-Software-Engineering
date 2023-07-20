package com.softuni.battleships.controllers;

import com.softuni.battleships.models.dtos.CreateShipDTO;
import com.softuni.battleships.services.AuthService;
import com.softuni.battleships.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    private final ShipService shipService;

    private final AuthService authService;

    public ShipController(ShipService shipService, AuthService authService) {
        this.shipService = shipService;
        this.authService = authService;
    }

    @ModelAttribute("createShipDTO")
    public CreateShipDTO initCreateShipDTO() {
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String ships() {
        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDTO createShipDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.shipService.create(createShipDTO)) {
            redirectAttributes.addFlashAttribute("createShipDTO", createShipDTO);
            redirectAttributes.addFlashAttribute(
            "org.springframework.validation.BindingResult.createShipDTO", bindingResult);

            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }
}
