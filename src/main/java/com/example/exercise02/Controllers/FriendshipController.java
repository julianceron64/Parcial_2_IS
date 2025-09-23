package com.example.exercise02.Controllers;


import org.springframework.web.bind.annotation.*;

import com.example.exercise02.Services.FriendshipService;

import java.util.List;

@RestController
@RequestMapping("/friendships")
public class FriendshipController {

    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    // Crear amistad
    @PostMapping("/{personId}/addFriend/{friendId}")
    public String addFriend(@PathVariable Long personId, @PathVariable Long friendId) {
        friendshipService.addFriend(personId, friendId);
        return "Amistad creada";
    }

    // Participar en un evento
    @PostMapping("/{personId}/joinEvent/{eventId}")
    public String joinEvent(@PathVariable Long personId, @PathVariable Long eventId) {
        friendshipService.addPersonToEvent(personId, eventId);
        return "Persona añadida al evento";
    }

    // Invitar amigos con hobbies comunes
    @PostMapping("/{personId}/invite/{eventId}")
    public String inviteFriends(@PathVariable Long personId,
                                @PathVariable Long eventId,
                                @RequestBody List<String> hobbies) {
        friendshipService.inviteFriendsToEvent(personId, eventId, hobbies);
        return "Amigos invitados";
    }
}
