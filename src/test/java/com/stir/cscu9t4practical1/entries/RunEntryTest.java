package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunEntryTest {

    final static LocalDateTime dateTime = LocalDateTime.of(
            2003, 2, 1, 0, 16, 7, 0
    );
    final static RunEntry instance = new RunEntry("Alice", dateTime, 3);


    @Test
    public void testToString() {
        String expResult = "Alice ran 3.0 km in 0:16:7 on 1/2/2003\n";
        assertEquals(expResult, instance.toString());
    }
}
