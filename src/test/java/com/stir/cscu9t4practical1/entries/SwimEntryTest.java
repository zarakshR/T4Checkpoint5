/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 @author saemundur */
public class SwimEntryTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");
    final static ZonedDateTime zonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 16, 7, 0, TimeZone.getTimeZone("GMT").toZoneId());
    final static SwimEntry outdoorSwimEntry = new SwimEntry("Alice", zonedDateTime, 3, SwimEntry.LOCATION.OUTDOORS);

    /**
     Test of getLocation method, of class SwimEntry
     */
    @Test
    public void testGetLocation() {
        assertEquals(SwimEntry.LOCATION.OUTDOORS, outdoorSwimEntry.getLocation());

        SwimEntry poolSwimEntry = new SwimEntry("Alice", zonedDateTime, 3, SwimEntry.LOCATION.POOL);
        assertEquals(SwimEntry.LOCATION.POOL, poolSwimEntry.getLocation());
    }

    /**
     Test of getEntry method, of class SwimEntry.
     */
    @Test
    public void testToString() {
        String expResult = "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n";
        assertEquals(expResult, outdoorSwimEntry.toString());
    }

}
