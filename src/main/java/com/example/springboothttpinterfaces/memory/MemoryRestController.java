package com.example.springboothttpinterfaces.memory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryRestController {

    @GetMapping("/other/memory")
    public MemoryStats getMemoryStats() {
        return MemoryStats.create();
    }
}
