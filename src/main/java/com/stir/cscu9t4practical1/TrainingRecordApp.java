package com.stir.cscu9t4practical1;

import com.stir.cscu9t4practical1.entries.RunEntry;
import com.stir.cscu9t4practical1.entries.TrainingRecord;
import com.stir.cscu9t4practical1.gui.MainFrame;

import java.awt.*;
import java.time.LocalDateTime;

public class TrainingRecordApp {

    private static final TrainingRecord trainingRecord = new TrainingRecord();

    public static void main(String[] args) {

        // dummy data while testing
        trainingRecord.addEntry(new RunEntry("Alice", LocalDateTime.now(), 10.0));
        trainingRecord.addEntry(new RunEntry("Bob", LocalDateTime.now(), 10.0));
        trainingRecord.addEntry(new RunEntry("Charlie", LocalDateTime.now(), 10.0));
        trainingRecord.addEntry(new RunEntry("David", LocalDateTime.now(), 10.0));

        MainFrame mainFrame = new MainFrame(trainingRecord);
        mainFrame.setPreferredSize(new Dimension(800, 400));
        mainFrame.setVisible(true);
    }
}
