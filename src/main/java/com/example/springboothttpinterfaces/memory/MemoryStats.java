package com.example.springboothttpinterfaces.memory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoryStats {
    private Long maxMemory;
    private Long freeMemory;
    private Long totalMemory;
    private Integer processors;

    public static MemoryStats create() {
        return new MemoryStats(
                Runtime.getRuntime().maxMemory(),
                Runtime.getRuntime().freeMemory(),
                Runtime.getRuntime().totalMemory(),
                Runtime.getRuntime().availableProcessors()
        );
    }
}
