/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 @author saemundur */
public class TrainingRecordTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");
    final static ZonedDateTime aliceZonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 16, 7, 0, tz.toZoneId());
    final static RunEntry alice = new RunEntry("Alice", aliceZonedDateTime, 3);
    final static ZonedDateTime bobZonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 14, 15, 0, tz.toZoneId());
    final static RunEntry bob = new RunEntry("Bob", bobZonedDateTime, 3);
    final static ZonedDateTime claireZonedDateTime1 = ZonedDateTime.of(
            2010, 3, 7, 0, 26, 20, 0, tz.toZoneId()
    );
    final static RunEntry claire1 = new RunEntry("Claire", claireZonedDateTime1, 7);
    final static ZonedDateTime claireZonedDateTime2 = ZonedDateTime.of(
            2010, 3, 11, 0, 24, 55, 0, tz.toZoneId()
    );
    final static RunEntry claire2 = new RunEntry("Claire", claireZonedDateTime2, 7);

    static TrainingRecord instance;

    @BeforeAll
    public static void setUp() {
        instance = new TrainingRecord();
    }

    @AfterEach
    public void tearDown() {
        instance.clearAllEntries();
    }

    @Test
    public void testAddEntry() {
        instance.addEntry(alice);
        assertEquals(1, instance.getNumberOfEntries());
    }

    @Test
    public void testAddEntryUnique() {
        instance.addEntry(alice);
        instance.addEntry(alice);
        assertEquals(1, instance.getNumberOfEntries());
    }

    @Test
    public void testGetNumberOfEntries() {
        assertEquals(0, instance.getNumberOfEntries());
        instance.addEntry(alice);
        assertEquals(1, instance.getNumberOfEntries());
        instance.addEntry(bob);
        assertEquals(2, instance.getNumberOfEntries());
        instance.addEntry(claire1);
        assertEquals(3, instance.getNumberOfEntries());
        instance.addEntry(claire2);
        assertEquals(4, instance.getNumberOfEntries());
    }

    @Test
    public void testLookupEntriesByDate() {
        instance.addEntry(alice);
        instance.addEntry(bob);
        instance.addEntry(claire1);
        instance.addEntry(claire2);
        Vector<Entry> expected = new Vector<Entry>(List.of(alice, bob));
        Collection<Entry> result = instance.lookupEntriesByDay(ZonedDateTime.of(
                2003, 2, 1, 0, 0, 0, 0, tz.toZoneId()));
        assertIterableEquals(expected, result);
    }

    @Test
    public void testLookupEntriesByName() {
        instance.addEntry(claire1);
        instance.addEntry(claire2);
        Vector<Entry> expected = new Vector<Entry>(List.of(claire1, claire2));
        Collection<Entry> result = instance.lookupEntriesByName(claire1.getName());
        assertIterableEquals(expected, result);
    }

    @Test
    public void testGetEntries() {
        instance.addEntry(alice);
        instance.addEntry(bob);
        instance.addEntry(claire1);
        instance.addEntry(claire2);
        Vector<Entry> expected = new Vector<Entry>(List.of(alice, bob, claire1, claire2));
        assertTrue(instance.getEntries().containsAll(expected));
        expected.removeAll(instance.getEntries());
        assertEquals(new Vector<Entry>(), expected);
    }
}
