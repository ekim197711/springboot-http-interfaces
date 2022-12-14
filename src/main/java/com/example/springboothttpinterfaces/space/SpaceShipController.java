package com.example.springboothttpinterfaces.space;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/space")
public class SpaceShipController {
    @GetMapping("/ships")
    List<SpaceShip> ships(){
        return List.of(
                new SpaceShip("Hawk", "Mike", 50, ",Moon"),
                new SpaceShip("Eagle", "Paulina", 34, ",Jupiter"),
                new SpaceShip("Swan", "Brian", 80, "Mars")
        );
    }

    @GetMapping( "/shipswithheader")
    List<SpaceShip> shipswithheader(@RequestHeader(name = "mike")String headerValue)
    {
        System.out.println("Header Value: " + headerValue);
        return ships();
    }
    @GetMapping("/fromCaptain")
    Optional<SpaceShip> fromCaptain(@RequestParam String captain){
        return ships().stream().filter(s -> s.captain().equalsIgnoreCase(captain)).findFirst();
    }
    @GetMapping("/fromDestination/{destination}")
    Optional<SpaceShip> fromDestination(@PathVariable String destination){
        return ships().stream().filter(s -> s.destination().equalsIgnoreCase(destination)).findFirst();
    }

}
