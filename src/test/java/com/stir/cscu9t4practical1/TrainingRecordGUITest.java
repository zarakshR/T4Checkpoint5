/*
 * Test class for TrainingRecordGUI
 * It is not finished as we're not expecting you to implement GUI testing
 * However, you're welcome to use this starter template and extend it and add
 * test for public methods you implement in TrainingRecordGUI.java
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.*;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 @author saemundur */
public class TrainingRecordGUITest {

    // use a fixed time zone for tests
    final static TimeZone tz = TimeZone.getTimeZone("GMT");
    final static ZonedDateTime aliceZonedDateTime = ZonedDateTime.of(
            2003, 2, 1, 0, 16, 7, 0, TimeZone.getTimeZone("GMT").toZoneId());
    final static Entry alice = new Entry("Alice", aliceZonedDateTime, 3);

    public TrainingRecordGUITest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     Test of main method, of class TrainingRecordGUI.
     just tests if the class can be initialised without errors
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TrainingRecordGUI.main(args);
    }

    /**
     Test of actionPerformed method, of class TrainingRecordGUI.
     This doesn't test anything but might be used in evaluations
     */
    @Test
    public void testActionPerformed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("Action not performed");
    }

    /**
     Test of blankDisplay method, of class TrainingRecordGUI.
     It just executes the method to see if it doesn't throw an exception
     */
    @Test
    public void testBlankDisplay() {
        System.out.println("blankDisplay");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        instance.blankDisplay();
    }

    /**
     Test of addEntry method, of class TrainingRecordGUI
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = alice;
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals(message, "Record added\n");
    }

    /**
     Test to see if all display requirements have been met
     */
    @Test
    public void testButtonsPresentInGUI() throws IllegalAccessException, IllegalArgumentException {
        System.out.println("Check if you have added the buttons");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Class<?> instanceClass = instance.getClass();
        String[] expectedFields = {"lookUpAllOnDate", "lookUpByDate"}; // TODO: add RemoveEntry when it is ready
        Field[] fields = instanceClass.getDeclaredFields();
        int found = 0;
        for (Field field : fields) {
            if (Arrays.asList(expectedFields).contains(field.getName())) {
                found += 1;
                field.setAccessible(true);
                assertTrue(field.get(instance) instanceof JButton);
            }
        }
        assertEquals(found, expectedFields.length, "Have you added all required buttons?");
    }
}
