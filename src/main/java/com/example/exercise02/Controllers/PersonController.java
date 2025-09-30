package com.example.exercise02.Controllers;

import com.example.exercise02.DTOS.PersonDTO;
import com.example.exercise02.Services.HobbyService;
import com.example.exercise02.Services.PersonService;
import com.example.exercise02.domain.mysql.Person;
import com.example.exercise02.domain.mysql.Hobby;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;
    private final HobbyService hobbyService;

    public PersonController(PersonService personService, HobbyService hobbyService) {
        this.personService = personService;
        this.hobbyService = hobbyService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "hobbyIds",
                new CustomCollectionEditor(List.class) {
                    @Override
                    protected Object convertElement(Object element) {
                        if (element != null) {
                            return element.toString(); // o Long.valueOf(element.toString())
                        }
                        return null;
                    }
                });
    }

    @RequestMapping("/persons")
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "persons";
    }

    @GetMapping("/persons/create")
    public String showForm(Model model) {
        model.addAttribute("person", new PersonDTO());
        model.addAttribute("hobbies", hobbyService.findAll());
        return "PersonForm";
    }

    @PostMapping("/persons/save")
    public String savePerson(@ModelAttribute PersonDTO person) {
        System.out.println("HobbyIds recibidos: " + person.getHobbyIds());
        personService.savePerson(
                person.getName(),
                person.getEmail(),
                person.getPhone(),
                person.getBirthDate(),
                person.getHobbyIds()
        );
        return "redirect:/persons";
    }
}
