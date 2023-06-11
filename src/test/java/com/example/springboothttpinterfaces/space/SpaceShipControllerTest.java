package com.example.springboothttpinterfaces.space;

import com.example.springboothttpinterfaces.client.SpaceShipClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpaceShipControllerTest {

    @Autowired
    SpaceShipClient spaceShipClient;

    private static String securityHeader() {
        return "Basic "
                + Base64.getEncoder().encodeToString("mike:kissme".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void ships() {
        try {
            List<SpaceShip> ships = spaceShipClient.shipswithheader(securityHeader(), "Some fun string");
            Assertions.assertFalse(ships.isEmpty());
            ships.forEach(System.out::println);
        } catch (WebClientRequestException e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    void shipsBadRequest() {
        try {
            List<SpaceShip> ships = spaceShipClient.shipsBadRequest(securityHeader());
            Assertions.fail("We should get a Bad Request Error");
        } catch (WebClientRequestException e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } catch (WebClientResponseException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(400, e.getStatusCode().value());
        }
    }

    @Test
    void shipsInternalServerError() {
        try {
            List<SpaceShip> ships = spaceShipClient.shipsInternalServerError(securityHeader());
            Assertions.fail("We should get an Internal server Error");
        } catch (WebClientRequestException e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } catch (WebClientResponseException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(500, e.getStatusCode().value());
        }
    }
}