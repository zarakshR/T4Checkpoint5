package com.stir.cscu9t4practical1.gui.util;

import javax.swing.*;
import java.time.LocalDate;

public final class DateEntryPanel extends JPanel {
    private final LabelledTextPanel yearField = new LabelledTextPanel("Year", 4);
    private final LabelledTextPanel monthField = new LabelledTextPanel("Month", 2);
    private final LabelledTextPanel dayField = new LabelledTextPanel("Day", 2);

    public DateEntryPanel() {
        add(yearField);
        add(monthField);
        add(dayField);
    }

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

    public void clearFields() {
        yearField.setText(null);
        monthField.setText(null);
        dayField.setText(null);
    }
}
