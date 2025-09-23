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
        model.addAttribute("persons", personService.findAll());
        return "persons"; // persons.html en templates
    }

    @GetMapping("/persons/create")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "formPerson"; // formulario
    }

    @PostMapping("/persons/save")
    public String savePerson(Person person) {
        personService.save(person);
        return "redirect:/persons";
    }
}
