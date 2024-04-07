package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunEntryTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");
    final static ZonedDateTime zonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 16, 7, 0, TimeZone.getTimeZone("GMT").toZoneId());
    final static RunEntry instance = new RunEntry("Alice", zonedDateTime, 3);


    @Test
    public void testGetEntry() {
        String expResult = "Alice ran 3.0 km in 0:16:7 on 1/2/2003\n";
        assertEquals(expResult, instance.formattedEntry());
    }
}
