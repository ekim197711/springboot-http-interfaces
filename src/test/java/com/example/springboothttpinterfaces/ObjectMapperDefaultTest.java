package com.example.springboothttpinterfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ObjectMapperDefaultTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void objectMapper() throws JsonProcessingException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("mydate", ZonedDateTime.of(
                LocalDateTime.of(2023, 1, 1, 2, 3,
                        4, 5123123)
                , ZoneId.of("CET")));
        String s = objectMapper.writeValueAsString(map);
        String expected = "{\"mydate\":\"2023-01-01T02:03:04.005123123+01:00\"}";
        Assertions.assertEquals(expected, s);
    }
}