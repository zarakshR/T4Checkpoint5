/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 @author saemundur */
public class EntryTest {

    final static LocalDateTime dateTime = LocalDateTime.of(
            2003, 2, 1, 0, 16, 7, 0
    );
    final static RunEntry instance = new RunEntry("Alice", dateTime, 3);

    @Test
    public void testGetDateTime() {
        assertEquals(dateTime, instance.getLocalDateAndTime());
    }

    /**
     Test of getDistance method, of class Entry.
     */
    @Test
    public void testGetDistance() {
        assertEquals(3.0, instance.getDistance(), 0.0);
    }

    @Test
    public void testEquality() {
        assertTrue(instance.equals(instance));
    }

    @Test
    public void testNameAndDateEquality() {
        RunEntry instance2 = new RunEntry("Alice", dateTime, 10);
        assertEquals(instance, instance2);
    }
}
