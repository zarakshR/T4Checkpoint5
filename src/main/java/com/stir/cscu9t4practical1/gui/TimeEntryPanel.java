package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.time.LocalTime;

final class TimeEntryPanel extends JPanel {
    private final LabelledTextPanel hourField = new LabelledTextPanel("Hour", 2);
    private final LabelledTextPanel minuteField = new LabelledTextPanel("Minute", 2);
    private final LabelledTextPanel secondField = new LabelledTextPanel("Second", 2);

    public TimeEntryPanel() {
        add(hourField);
        add(minuteField);
        add(secondField);
    }

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
        hourField.setText(null);
        minuteField.setText(null);
        secondField.setText(null);
    }
}
