package com.example.springboothttpinterfaces.space;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/space")
@Slf4j
public class SpaceShipController {
    @GetMapping("/ships")
    List<SpaceShip> ships() {
        List<SpaceShip> shipList = List.of(
                new SpaceShip("Hawk", "Mike", 50, ",Moon"),
                new SpaceShip("Eagle", "Paulina", 34, ",Jupiter"),
                new SpaceShip("Swan", "Brian", 80, "Mars")
        );
        log.info("Return list of ships {}", shipList);
        return shipList;
    }

    @GetMapping("/shipswithheader")
    List<SpaceShip> shipswithheader(@RequestHeader(name = "mike") String headerValue) {
        log.info("Header Value {}", headerValue);
        return ships();
    }

    @GetMapping("/ships-bad-request")
    ResponseEntity<List<SpaceShip>> shipsBadRequest() {
        log.info("Trigger bad request");
        return ResponseEntity.badRequest().body(List.of());
    }

    @GetMapping("/ships-internal-server-error")
    ResponseEntity<List<SpaceShip>> shipsInternal() {
        log.info("Trigger internal server error");
        return ResponseEntity.internalServerError().body(List.of());
    }

    @GetMapping("/fromCaptain")
    Optional<SpaceShip> fromCaptain(@RequestParam String captain) {
        log.info("From captaint");
        return ships().stream().filter(s -> s.captain().equalsIgnoreCase(captain)).findFirst();
    }

    @GetMapping("/fromDestination/{destination}")
    Optional<SpaceShip> fromDestination(@PathVariable String destination) {
        return ships().stream().filter(s -> s.destination().equalsIgnoreCase(destination)).findFirst();
    }

}
