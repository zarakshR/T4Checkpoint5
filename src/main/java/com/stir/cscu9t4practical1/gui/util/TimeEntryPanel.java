package com.stir.cscu9t4practical1.gui.util;

import javax.swing.*;
import java.time.LocalTime;

/**
 A panel that allows the user to input times in the HH:MM:SS format and provides the ability to generate LocalTime instances
 from data provided by the user
 */
public final class TimeEntryPanel extends JPanel {
    private final LabelledTextPanel hourField = new LabelledTextPanel("Hour", 2);
    private final LabelledTextPanel minuteField = new LabelledTextPanel("Minute", 2);
    private final LabelledTextPanel secondField = new LabelledTextPanel("Second", 2);

    /**
     Create a <code>TimeEntryPanel</code>
     */
    public TimeEntryPanel() {
        add(hourField);
        add(minuteField);
        add(secondField);
    }

    /**
     Attempts to create and return a <code>LocalTime</code> object defined by the user input
     @return the <code>LocalTime</code> object created

     @throws InvalidFieldsException if the user entered invalid input for a field
     */
    public LocalTime getTime() throws InvalidFieldsException {
        int hour;
        String hourText = hourField.getText();
        int minute;
        String minuteText = minuteField.getText();
        int second;
        String secondText = secondField.getText();

        try {
            hour = Integer.parseInt(hourText);
        } catch (NumberFormatException e) {
            throw new InvalidFieldsException("Hour", hourText);
        }

        try {
            minute = Integer.parseInt(minuteText);
        } catch (NumberFormatException e) {
            throw new InvalidFieldsException("Minute", minuteText);
        }

        try {
            second = Integer.parseInt(secondText);
        } catch (NumberFormatException e) {
            throw new InvalidFieldsException("Second", secondText);
        }

        return LocalTime.of(hour, minute, second);
    }

    public void clearFields() {
        hourField.clearText();
        minuteField.clearText();
        secondField.clearText();
    }
}
