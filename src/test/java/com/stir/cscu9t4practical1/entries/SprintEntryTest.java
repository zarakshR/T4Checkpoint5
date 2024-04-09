/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 @author saemundur */
public class SprintEntryTest {

    final static LocalDateTime dateTime = LocalDateTime.of(
            2003, 2, 1, 0, 16, 7, 0
    );
    final static SprintEntry instance = new SprintEntry("Alice", dateTime, 300, 4, 2);

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
    public void testToString() {
        String expResult = "Alice sprinted 4 x 300.0m in 0:16:7 with 2 minutes recovery on 1/2/2003\n";
        assertEquals(expResult, instance.toString());
    }

}
