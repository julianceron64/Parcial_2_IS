package com.example.exercise02.Controllers;

import com.example.exercise02.Services.HobbyService;
import com.example.exercise02.domain.mongo.Hobby;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HobbyController {

    private final HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @RequestMapping("/hobbies")
    public String listHobbies(Model model) {
        model.addAttribute("hobbies", hobbyService.findAll());
        return "hobbies"; // hobbies.html en templates
    }

    @GetMapping("/hobbies/create")
    public String showForm(Model model) {
        model.addAttribute("hobby", new Hobby());
        return "formHobby"; // formulario para hobby
    }

    @PostMapping("/hobbies/save")
    public String saveHobby(Hobby hobby) {
        hobbyService.save(hobby);
        return "redirect:/hobbies";
    }
}
