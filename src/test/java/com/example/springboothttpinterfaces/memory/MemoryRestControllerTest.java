package com.example.springboothttpinterfaces.memory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemoryRestControllerTest {

    @Autowired
    MemoryRestController memoryRestController;

    @Test
    void getMemoryStats() {
        MemoryStats memoryStats = memoryRestController.getMemoryStats();
        Assertions.assertNotNull(memoryStats);
        Assertions.assertNotNull(memoryStats.getFreeMemory());
        Assertions.assertNotNull(memoryStats.getTotalMemory());
        Assertions.assertNotNull(memoryStats.getMaxMemory());
        Assertions.assertNotNull(memoryStats.getProcessors());
    }
}