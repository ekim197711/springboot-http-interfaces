package com.example.springboothttpinterfaces.client;

import com.example.springboothttpinterfaces.space.SpaceShip;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/other")
@RequiredArgsConstructor
public class TryStuffController {
    private final SpaceShipClient spaceShipClient;
    @GetMapping("/trystuff")
    Map<String, String> tryStuff(){
        Map<String, String> result = new HashMap<>();
        result.put("ships",spaceShipClient.ships().toString());
        result.put("fromCaptain", spaceShipClient.fromCaptain("Mike").toString());
        result.put("fromDestination", spaceShipClient.fromDestination("Mars").toString());
        return result;
    }
}
