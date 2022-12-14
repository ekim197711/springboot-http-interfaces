package com.example.springboothttpinterfaces.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfiguration {
    @Bean
    public SpaceShipClient spaceShipClient()  {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient)).build();
        return factory.createClient(SpaceShipClient.class);
    }
}
