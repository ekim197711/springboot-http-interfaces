package com.example.springboothttpinterfaces.space;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CargoControllerTest {
    @LocalServerPort
    int localPort;


    @Test
    void cargo() {
        RestTemplate rt = new RestTemplate();
        String response = rt.getForObject("http://localhost:" + localPort + "/other/cargo", String.class);
        System.out.println(response);
    }
}
