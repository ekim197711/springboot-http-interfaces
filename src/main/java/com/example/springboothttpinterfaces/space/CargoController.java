package com.example.springboothttpinterfaces.space;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/other")
@Slf4j
@RequiredArgsConstructor
public class CargoController {

    @GetMapping("/cargo")
    List<Cargo> cargo() {
        log.warn("Cargo is being loaded ");
        List<Cargo> cargoList = List.of(
                new Cargo("Apples", 10, ZonedDateTime.now().plusMonths(1)),
                new Cargo("PC", 25, ZonedDateTime.now().plusMonths(36)),
                new Cargo("Cookies", 1234, ZonedDateTime.now().plusMonths(5))
        );
        log.info("Return list of cargo {}", cargoList);
        return cargoList;
    }
}
