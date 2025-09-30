package com.example.exercise02.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.exercise02.Services.FriendshipService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/friendships")
public class FriendshipController {

    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @PostMapping("/add")
    public String addFriend(
            @RequestParam("personGlobalId") String personGlobalId,
            @RequestParam("friendEmail") String friendEmail,
            @RequestParam("friendPhone") String friendPhone
    ) {
        System.out.println(">> personGlobalId recibido: '" + personGlobalId + "' (length=" + personGlobalId.length() + ")");
        // Llamamos al servicio
        friendshipService.addFriend(UUID.fromString(personGlobalId), friendEmail, friendPhone);

        // Redirigimos al listado de personas
        return "redirect:/persons";
    }

    @GetMapping
    public String showGraph() {
        return "graph"; // Carga templates/graph.html
    }

}

