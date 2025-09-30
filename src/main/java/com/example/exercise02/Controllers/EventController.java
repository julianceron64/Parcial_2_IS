package com.example.exercise02.Controllers;

import com.example.exercise02.DTOS.EventDTO;
import com.example.exercise02.DTOS.PersonDTO;
import com.example.exercise02.Services.EventService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/save")
    public String addEvent(@RequestParam String name,
                           @RequestParam String location,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
            {
        eventService.saveEvent(name, location, date);
        return "redirect:/events";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("event", new EventDTO());
        return "EventForm";
    }

    @RequestMapping()
    public String listPersons(Model model) {
        model.addAttribute("events", eventService.findAllEvents());
        return "events";
    }

}
