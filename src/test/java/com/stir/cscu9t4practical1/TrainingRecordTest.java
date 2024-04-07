/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.TimeZone;

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
    public void testLookupEntry() {
        instance.addEntry(alice);
        instance.addEntry(bob);
        instance.addEntry(claire1);
        instance.addEntry(claire2);

        assertNotNull(instance.lookupEntry(7, 3, 2010));
        assertNull(instance.lookupEntry(1, 2, 1999));
    }

    @Test
    public void testGetNumberOfEntries() {
        assertEquals(instance.getNumberOfEntries(), 0);
        instance.addEntry(alice);
        assertEquals(instance.getNumberOfEntries(), 1);
        instance.addEntry(bob);
        assertEquals(instance.getNumberOfEntries(), 2);
        instance.addEntry(claire1);
        assertEquals(instance.getNumberOfEntries(), 3);
        instance.addEntry(claire2);
        assertEquals(4, instance.getNumberOfEntries());
    }


    @Test
    public void testLookupEntries() {
        String expectResultsNone = "Sorry couldn't find anything for this date";
        String expectResults = "Alice ran 3.0 km in 0:16:7 on 1/2/2003\n" +
                "Bob ran 3.0 km in 0:14:15 on 1/2/2003\n";
        Entry a = alice;
        Entry b = bob;
        instance.addEntry(a);
        instance.addEntry(b);
        int d = 1;
        int m = 2;
        int y = 2003;
        String resultSuccess = instance.lookupEntries(d, m, y);
        String resultNone = instance.lookupEntries(d, m, 1999);
        assertEquals(expectResultsNone, resultNone);
        assertEquals(expectResults, resultSuccess);
    }

}
