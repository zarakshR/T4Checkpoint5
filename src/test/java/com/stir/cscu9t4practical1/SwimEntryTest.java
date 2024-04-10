/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.*;

import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 @author saemundur */
public class SwimEntryTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");

    public SwimEntryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     Test of getName method, of class SwimEntry.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "outdoors");
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     Test of getDay method, of class SwimEntry.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "pool");
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     Test of getMonth method, of class SwimEntry.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "outdoors");
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     Test of getYear method, of class SwimEntry.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "pool");
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     Test of getHour method, of class SwimEntry.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "pool");
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     Test of getMin method, of class SwimEntry.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "pool");
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     Test of getSec method, of class SwimEntry.
     */
    @Test
    public void testGetSec() {
        System.out.println("getSec");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "pool");
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     Test of getDistance method, of class SwimEntry.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "pool");
        double expResult = 3.0;
        double result = instance.getDistance();
        assertEquals(result, expResult, 0.0);
    }

    /**
     Test of getWhere method, of class SwimEntry
     */
    @Test
    public void testGetWhere() {
        System.out.println("getWhere");
        SwimEntry instanceA = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "outdoors");
        String expResultA = "outdoors";
        String resultA = instanceA.getLocation();
        assertEquals(expResultA, resultA);

        SwimEntry instanceB = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "pool");
        String expResultB = "in a pool";
        String resultB = instanceB.getLocation();
        assertEquals(expResultB, resultB);
    }

    /**
     Test of getEntry method, of class SwimEntry.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        Entry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, tz, "outdoors");
        String expResult = "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n";
        String result = instance.formattedEntry();
        assertEquals(expResult, result);
    }

}
