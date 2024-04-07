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
public class CycleEntryTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");
    final static ZonedDateTime zonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 16, 7, 0, TimeZone.getTimeZone("GMT").toZoneId());
    final static CycleEntry instance = new CycleEntry("Alice", zonedDateTime, 3, CycleEntry.Terrain.ASPHALT,
            CycleEntry.Tempo.MODERATE);

    /**
     Test of getTerrain method, of class CycleEntry.
     */
    @Test
    public void testGetTerrain() {
        CycleEntry.Terrain expResult = CycleEntry.Terrain.ASPHALT;
        CycleEntry.Terrain result = instance.getTerrain();
        assertEquals(expResult, result);
    }

    /**
     Test of getTempo method, of class CycleEntry.
     */
    @Test
    public void testGetTempo() {
        CycleEntry.Tempo expResult = CycleEntry.Tempo.MODERATE;
        CycleEntry.Tempo result = instance.getTempo();
        assertEquals(expResult, result);
    }

    /**
     Test of getEntry method, of class CycleEntry.
     */
    @Test
    public void testGetEntry() {
        String expResult = "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n";
        String result = instance.formattedEntry();
        assertEquals(expResult, result);
    }

}
