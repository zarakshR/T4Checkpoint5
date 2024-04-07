/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 @author saemundur */
public class SprintEntryTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");
    final static ZonedDateTime zonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 16, 7, 0, TimeZone.getTimeZone("GMT").toZoneId());
    final static SprintEntry instance = new SprintEntry("Alice", zonedDateTime, 300, 4, 2);

    /**
     Test of getRepetitions method of class SprintEntry
     */
    @Test
    public void testGetRepetitions() {
        assertEquals(4, instance.getRepetitions());
    }

    /**
     Test of getRecovery method of class SprintEntry
     */
    @Test
    public void testGetRecovery() {
        assertEquals(2, instance.getRecovery());
    }

    /**
     Test of getEntry method, of class SprintEntry.
     */
    @Test
    public void testGetEntry() {
        String expResult = "Alice sprinted 4 x 300.0m in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        assertEquals(expResult, instance.formattedEntry());
    }

}
