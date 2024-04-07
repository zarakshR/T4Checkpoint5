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
public class CycleEntryTest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");

    public CycleEntryTest() {
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
     Test of getName method, of class CycleEntry.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.MODERATE);
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     Test of getDay method, of class CycleEntry.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.GRAVEL, CycleEntry.Tempo.MODERATE);
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     Test of getMonth method, of class CycleEntry.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.MOUNTAIN, CycleEntry.Tempo.FAST);
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     Test of getYear method, of class CycleEntry.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.GRAVEL, CycleEntry.Tempo.SLOW);
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     Test of getHour method, of class CycleEntry.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.FAST);
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     Test of getMin method, of class CycleEntry.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.MODERATE);
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     Test of getSec method, of class CycleEntry.
     */
    @Test
    public void testGetSec() {
        System.out.println("getSec");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.MODERATE);
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     Test of getDistance method, of class CycleEntry.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.MODERATE);
        double expResult = 3.0;
        double result = instance.getDistance();
        assertEquals(result, expResult, 0.0);
    }

    /**
     Test of getTerrain method, of class CycleEntry.
     */
    @Test
    public void testGetTerrain() {
        System.out.println("getTerrain");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.MODERATE);
        CycleEntry.Terrain expResult = CycleEntry.Terrain.ASPHALT;
        CycleEntry.Terrain result = instance.getTerrain();
        assertEquals(expResult, result);
    }

    /**
     Test of getTempo method, of class CycleEntry.
     */
    @Test
    public void testGetTempo() {
        System.out.println("getTempo");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.MODERATE);
        CycleEntry.Tempo expResult = CycleEntry.Tempo.MODERATE;
        CycleEntry.Tempo result = instance.getTempo();
        assertEquals(expResult, result);
    }

    /**
     Test of getEntry method, of class CycleEntry.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        Entry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, tz, 3, CycleEntry.Terrain.ASPHALT, CycleEntry.Tempo.MODERATE);
        String expResult = "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n";
        String result = instance.formattedEntry();
        assertEquals(expResult, result);
    }

}
