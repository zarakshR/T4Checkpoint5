package com.stir.cscu9t4practical1.gui.util;

import javax.swing.*;
import java.time.LocalDate;

/**
 A panel that allows the user to input dates in the YYYY/MM/DD format and provides the ability to generate LocalDate instances
 from data provided by the user
 */
public final class DateEntryPanel extends JPanel {

    private final LabelledTextPanel yearField = new LabelledTextPanel("Year", 4);
    private final LabelledTextPanel monthField = new LabelledTextPanel("Month", 2);
    private final LabelledTextPanel dayField = new LabelledTextPanel("Day", 2);

    /**
     Create a <code>DateEntryPanel</code>
     */
    public DateEntryPanel() {
        add(yearField);
        add(monthField);
        add(dayField);
    }

    /**
     Attempts to create and return a <code>LocalDate</code> object defined by the user input

     @return the <code>LocalDate</code> object created

     @throws InvalidFieldsException if the user entered invalid input for a field
     */
    public LocalDate getDate() throws InvalidFieldsException {
        int year;
        String yearText = yearField.getText();
        int month;
        String monthText = monthField.getText();
        int day;
        String dayText = dayField.getText();

        try {
            year = Integer.parseInt(yearText);
        } catch (NumberFormatException e) {
            throw new InvalidFieldsException("Year", yearText);
        }

        try {
            month = Integer.parseInt(monthText);
        } catch (NumberFormatException e) {
            throw new InvalidFieldsException("Month", monthText);
        }

        try {
            day = Integer.parseInt(dayText);
        } catch (NumberFormatException e) {
            throw new InvalidFieldsException("Day", dayText);
        }

        return LocalDate.of(year, month, day);
    }

    /**
     Clear the date entry fields
     */
    public void clearFields() {
        yearField.clearText();
        monthField.clearText();
        dayField.clearText();
    }
}
