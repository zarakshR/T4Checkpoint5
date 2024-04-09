package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SprintEntryTest {

    final static LocalDateTime dateTime = LocalDateTime.of(
            2003, 2, 1, 0, 16, 7, 0
    );
    final static SprintEntry instance = new SprintEntry("Alice", dateTime, 300, 4, 2);

    @Test
    public void testGetRepetitions() {
        assertEquals(4, instance.getRepetitions());
    }

    @Test
    public void testGetRecovery() {
        assertEquals(2, instance.getRecovery());
    }

    @Test
    public void testToString() {
        String expResult = "Alice sprinted 4 x 300.0m in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        assertEquals(expResult, instance.toString());
    }

}
