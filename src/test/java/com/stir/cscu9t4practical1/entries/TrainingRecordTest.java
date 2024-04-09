/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1.entries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class TrainingRecordTest {

    final static LocalDateTime aliceDateTime = LocalDateTime.of(
            2003, 2, 1, 0, 16, 7, 0
    );
    final static RunEntry alice = new RunEntry("Alice", aliceDateTime, 3);
    final static LocalDateTime bobDateTime = LocalDateTime.of(
            2003, 2, 1, 0, 14, 15, 0
    );
    final static RunEntry bob = new RunEntry("Bob", bobDateTime, 3);
    final static LocalDateTime claireDateTime1 = LocalDateTime.of(
            2010, 3, 7, 0, 26, 20, 0
    );
    final static RunEntry claire1 = new RunEntry("Claire", claireDateTime1, 7);
    final static LocalDateTime claireDateTime2 = LocalDateTime.of(
            2010, 3, 11, 0, 24, 55, 0
    );
    final static RunEntry claire2 = new RunEntry("Claire", claireDateTime2, 10);
    // A highly specific double value was chosen to make sure we are handling double comparisions properly
    private static final double MARIAM_DISTANCE = 7.35323;
    private static final String MARIAM_NAME = "Mariam";
    static TrainingRecord instance;

    // for testing purposes: just to generate LocalDateTimes with no useful time info
    private static LocalDate dateMocker(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    // MARIAM the mock athlete: generates RunEntry instances that differ *only* in terms of their dates
    //  All RunEntries generated with this are guaranteed to have:
    //      name = MARIAM_NAME,
    //      time = 0:0:0,
    //      distance = MARIAM_DISTANCE
    // you can rename MARIAM_NAME and MARIAM_DISTANCE to be MOCK_NAME and MOCK_DISTANCE if it seems more professional to you,
    //  but I think this has more character :)
    private static RunEntry makeMariam(int year, int month, int day) {
        return new RunEntry(MARIAM_NAME, LocalDateTime.of(year, month, day, 0, 0, 0), MARIAM_DISTANCE);
    }

    private static <E> boolean orderIndependentIterableEquality(Collection<E> c1, Collection<E> c2) {
        return (c1.size() == c2.size()) && c1.containsAll(c2) && c2.containsAll(c1);
    }

    // we need to create a new TrainingRecord instance before each test since we don't have mocks
    @BeforeEach
    public void setUp() {
        instance = new TrainingRecord();
    }

    @Test
    public void testLookupEntriesByDate() {
        instance.addEntry(alice);
        instance.addEntry(bob);
        instance.addEntry(claire1);
        instance.addEntry(claire2);
        Vector<Entry> expected = new Vector<Entry>(List.of(alice, bob));
        Collection<Entry> result = instance.lookupEntriesByDay(LocalDate.of(
                2003, 2, 1));
        assertTrue(orderIndependentIterableEquality(expected, result));
    }

    @Test
    public void testLookupEntriesByDateNonExistent() {
        instance.addEntry(alice);
        instance.addEntry(bob);
        LocalDate probablyNotInRecord = LocalDate.of(9999, 1, 1);
        Assertions.assertIterableEquals(new Vector<Entry>(), instance.lookupEntriesByDay(probablyNotInRecord));
    }

    @Test
    public void testLookupEntriesByName() {
        instance.addEntry(alice);
        instance.addEntry(claire1);
        instance.addEntry(bob);
        instance.addEntry(claire2);
        Vector<Entry> expected = new Vector<Entry>(List.of(claire1, claire2));
        Collection<Entry> result = instance.lookupEntriesByName(claire1.getName());
        assertTrue(orderIndependentIterableEquality(expected, result));
    }

    @Test
    public void testLookupEntriesByNameNonExistent() {
        instance.addEntry(bob);
        instance.addEntry(claire1);
        assertIterableEquals(new Vector<Entry>(), instance.lookupEntriesByName("Alice"));
    }

    @Test
    // checks when dates within one week
    public void testGetWeeklyDistanceWithinOneWeek() {
        instance.addEntry(makeMariam(2020, 1, 1));
        double totalDistance = instance.lookupWeeklyDistance(MARIAM_NAME, dateMocker(2020, 1, 7));
        assertEquals(MARIAM_DISTANCE, totalDistance, 0.001);
    }

    @Test
    // checks when dates not within one week
    public void testGetWeeklyDistanceOutwithOneWeek() {
        instance.addEntry(makeMariam(2020, 1, 1));
        double totalDistance = instance.lookupWeeklyDistance(MARIAM_NAME, dateMocker(2020, 1, 8));
        assertEquals(0.0, totalDistance, 0.001);
    }

    @Test
    // checks when dates within one week across a year boundary, e.g. - 2020-12-31 to 2021-01-01 should match
    public void testGetWeeklyDistanceAcrossYearBoundary() {
        instance.addEntry(makeMariam(2020, 12, 31));
        double totalDistance = instance.lookupWeeklyDistance(MARIAM_NAME, dateMocker(2021, 1, 1));
        assertEquals(MARIAM_DISTANCE, totalDistance, 0.001);
    }

    @Test
    public void testGetWeeklyDistanceSumsCorrectly() {
        instance.addEntry(makeMariam(1, 1, 4)); // this should not count, so MARIAM_DISTANCE * 2 is expected
        instance.addEntry(makeMariam(2020, 1, 1));
        instance.addEntry(makeMariam(2020, 1, 2));
        double totalDistance = instance.lookupWeeklyDistance(MARIAM_NAME, dateMocker(2020, 1, 3));
        assertEquals(MARIAM_DISTANCE * 2, totalDistance, 0.001);
    }

    @Test
    public void testGetEntries() {
        instance.addEntry(alice);
        instance.addEntry(bob);
        instance.addEntry(claire1);
        instance.addEntry(claire2);
        Vector<Entry> expected = new Vector<Entry>(List.of(alice, bob, claire1, claire2));
        Collection<Entry> result = instance.getEntries();
        assertTrue(orderIndependentIterableEquality(expected, result));
    }
}
