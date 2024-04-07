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
public class EntryTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");
    final static ZonedDateTime zonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 16, 7, 0, TimeZone.getTimeZone("GMT").toZoneId());
    final static RunEntry instance = new RunEntry("Alice", zonedDateTime, 3);

    /**
     Test of getName method, of class Entry.
     */
    @Test
    public void testGetName() {
        assertEquals("Alice", instance.getName());
    }

    /**
     Test of getDay method, of class Entry.
     */
    @Test
    public void testGetDay() {
        assertEquals(1, instance.getDay());
    }

    /**
     Test of getMonth method, of class Entry.
     */
    @Test
    public void testGetMonth() {
        assertEquals(2, instance.getMonth());
    }

    /**
     Test of getYear method, of class Entry.
     */
    @Test
    public void testGetYear() {
        assertEquals(2003, instance.getYear());
    }

    /**
     Test of getHour method, of class Entry.
     */
    @Test
    public void testGetHour() {
        assertEquals(0, instance.getHour());
    }

    /**
     Test of getMin method, of class Entry.
     */
    @Test
    public void testGetMin() {
        assertEquals(16, instance.getMin());
    }

    /**
     Test of getSec method, of class Entry.
     */
    @Test
    public void testGetSec() {
        assertEquals(7, instance.getSec());
    }

    /**
     Test of getDistance method, of class Entry.
     */
    @Test
    public void testGetDistance() {
        assertEquals(3.0, instance.getDistance(), 0.0);
    }

}