package com.example.springboothttpinterfaces.client;

import com.example.springboothttpinterfaces.space.SpaceShip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;
import java.util.Optional;

@HttpExchange(url="/space")
public interface SpaceShipClient {
    @HttpExchange(url = "/ships", method = "GET")
    List<SpaceShip> ships();
    @PostExchange("/create")
    void createShip(@RequestBody SpaceShip spaceShip);

    @GetExchange("/fromCaptain")
    Optional<SpaceShip> fromCaptain(@RequestParam("captain") String captain);
    @GetExchange("/fromDestination/{destination}")
    Optional<SpaceShip> fromDestination(@PathVariable String destination);
}
