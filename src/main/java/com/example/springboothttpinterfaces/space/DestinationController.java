package com.example.springboothttpinterfaces.space;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/destination")
public class DestinationController {
    @GetMapping("/box")
    public String proposeSomething(@RequestParam("suggestion") List<String> suggestions ){
        suggestions.stream().forEach(System.out::println);
        return "Thank you for your suggestions: " + suggestions;
    }


}
