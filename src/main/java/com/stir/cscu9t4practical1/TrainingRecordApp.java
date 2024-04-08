package com.stir.cscu9t4practical1;

import com.stir.cscu9t4practical1.entries.RunEntry;
import com.stir.cscu9t4practical1.entries.TrainingRecord;
import com.stir.cscu9t4practical1.gui.MainFrame;

import java.time.ZonedDateTime;

public class TrainingRecordApp {

    private static final TrainingRecord trainingRecord = new TrainingRecord();
    private static MainFrame mainFrame;

    public static void main(String[] args) {

        trainingRecord.addEntry(new RunEntry("Alice", ZonedDateTime.now(), 10.0));
        trainingRecord.addEntry(new RunEntry("Bob", ZonedDateTime.now(), 10.0));
        trainingRecord.addEntry(new RunEntry("Charlie", ZonedDateTime.now(), 10.0));
        trainingRecord.addEntry(new RunEntry("David", ZonedDateTime.now(), 10.0));

        mainFrame = new MainFrame(trainingRecord);
        mainFrame.setVisible(true);
    }
}
