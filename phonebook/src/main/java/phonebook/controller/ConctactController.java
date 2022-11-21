package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ConctactController {
    private List<Contact> contacts;

    public ConctactController() {
        this.contacts = new ArrayList<>();
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;

    }

    @PostMapping("/")
    public String add(Contact contact) {
        this.contacts.add(contact);
        return ("redirect:/");
    }

    @PutMapping("/")
    public String update(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
          if(this.contacts.get(i).getName().equals(contact.getName()))  {
              this.contacts.remove(i);
              this.contacts.add(contact);
          }
        }



        return ("redirect:/");

    }
}
