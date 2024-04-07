/*
 * Test class for TrainingRecordGUI
 * It is not finished as we're not expecting you to implement GUI testing
 * However, you're welcome to use this starter template and extend it and add
 * test for public methods you implement in TrainingRecordGUI.java
 */
package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.RunEntry;
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
    final static RunEntry alice = new RunEntry("Alice", aliceZonedDateTime, 3);

    static TrainingRecordGUI instance;

    @BeforeAll
    public static void setUpClass() {
        instance = new TrainingRecordGUI();
    }

    @Test
    public void testMain() {
        TrainingRecordGUI.main(null);
    }

    @Test
    public void testActionPerformed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    }

    @Test
    public void testBlankDisplay() {
        instance.blankDisplay();
    }

    @Test
    public void testAddEntry() {
        instance.fillDisplay(alice);
        String message = instance.addEntry("generic");
        assertEquals(message, "Record added\n");
    }

    @Test
    public void testButtonsPresentInGUI() throws IllegalAccessException, IllegalArgumentException {
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
