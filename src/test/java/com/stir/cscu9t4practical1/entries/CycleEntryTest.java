/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleEntryTest {

    final static LocalDateTime dateTime = LocalDateTime.of(
            2003, 2, 1, 0, 16, 7, 0
    );
    final static CycleEntry instance = new CycleEntry("Alice", dateTime, 3, CycleEntry.TERRAIN.ASPHALT,
            CycleEntry.TEMPO.MODERATE);

    @Test
    public void testGetTerrain() {
        CycleEntry.TERRAIN expResult = CycleEntry.TERRAIN.ASPHALT;
        CycleEntry.TERRAIN result = instance.getTerrain();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTempo() {
        CycleEntry.TEMPO expResult = CycleEntry.TEMPO.MODERATE;
        CycleEntry.TEMPO result = instance.getTempo();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        String expResult = "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n";
        assertEquals(expResult, instance.toString());
    }

}
