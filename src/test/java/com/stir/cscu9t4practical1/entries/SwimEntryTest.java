package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwimEntryTest {

    final static LocalDateTime dateTime = LocalDateTime.of(
            2003, 2, 1, 0, 16, 7, 0
    );
    final static SwimEntry outdoorSwimEntry = new SwimEntry("Alice", dateTime, 3, SwimEntry.LOCATION.OUTDOORS);
    final static SwimEntry poolSwimEntry = new SwimEntry("Alice", dateTime, 3, SwimEntry.LOCATION.POOL);

    @Test
    public void testGetLocation() {
        assertEquals(SwimEntry.LOCATION.OUTDOORS, outdoorSwimEntry.getLocation());

        SwimEntry poolSwimEntry = new SwimEntry("Alice", dateTime, 3, SwimEntry.LOCATION.POOL); // TODO
        assertEquals(SwimEntry.LOCATION.POOL, poolSwimEntry.getLocation());
    }

    @Test
    public void testToStringOutdoors() {
        String expResult = "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n";
        assertEquals(expResult, outdoorSwimEntry.toString());
    }

    @Test
    public void testToStringPool() {
        String expResult = "Alice swam 3.0 km in a pool in 0:16:7 on 1/2/2003\n";
        assertEquals(expResult, poolSwimEntry.toString());
    }
}
