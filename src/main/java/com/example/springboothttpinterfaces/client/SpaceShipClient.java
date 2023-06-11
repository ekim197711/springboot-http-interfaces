package com.example.springboothttpinterfaces.client;

import com.example.springboothttpinterfaces.space.SpaceShip;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;
import java.util.Optional;

@HttpExchange(url="/space")
public interface SpaceShipClient {
    @HttpExchange(url = "/ships", method = "GET")
    List<SpaceShip> ships();
    @HttpExchange(url = "/shipswithheader", method = "GET")
    List<SpaceShip> shipswithheader(@RequestHeader(name = "Authorization") String basicAuth,
                                    @RequestHeader(name = "mike") String isFun);
    @HttpExchange(url = "/ships-bad-request", method = "GET")
    List<SpaceShip> shipsBadRequest(@RequestHeader(name = "Authorization") String basicAuth);
    @HttpExchange(url = "/ships-internal-server-error", method = "GET")
    List<SpaceShip> shipsInternalServerError(@RequestHeader(name = "Authorization") String basicAuth);

    @PostExchange("/create")
    void createShip(@RequestBody SpaceShip spaceShip);

    @GetExchange("/fromCaptain")
    Optional<SpaceShip> fromCaptain(@RequestParam("captain") String captain);
    @GetExchange("/fromDestination/{destination}")
    Optional<SpaceShip> fromDestination(@PathVariable String destination);
}
