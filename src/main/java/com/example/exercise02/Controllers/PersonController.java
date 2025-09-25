package com.example.exercise02.Controllers;

import com.example.exercise02.Services.PersonService;
import com.example.exercise02.domain.mysql.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/persons")
    public String listPersons(Model model) {
        // Trae todas las personas y las envía a la vista
        model.addAttribute("persons", personService.findAll());
        return "persons"; // persons.html en templates
    }

    @GetMapping("/persons/create")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "PersonForm";
    }

    @PostMapping("/persons/save")
    public String savePerson(@ModelAttribute Person person) {
        personService.savePerson(person.getName(),person.getBirthDate(), person.getHobbyIds());
        return "redirect:/persons";
    }
}
