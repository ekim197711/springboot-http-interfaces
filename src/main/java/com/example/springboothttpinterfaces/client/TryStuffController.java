package com.example.springboothttpinterfaces.client;

import com.example.springboothttpinterfaces.space.SpaceShip;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/other")
@RequiredArgsConstructor
@Slf4j
public class TryStuffController {
    private final SpaceShipClient spaceShipClient;
    @GetMapping("/trystuff/clients")
    Map<String, String> tryStuffSpaceShipClient(){
        Map<String, String> result = new HashMap<>();
        String securityHeader = "Basic "
                + Base64.getEncoder().encodeToString("mike:kissme".getBytes(StandardCharsets.UTF_8));
        log.info("Security header: " + securityHeader);
        result.put("shipswithheader",
                spaceShipClient.shipswithheader(securityHeader, "yes he is fun").toString());
        return result;
    }
    @GetMapping("/trystuff/weather")
    String tryStuffWeather(){
        return "Maybe snow";
    }
}
