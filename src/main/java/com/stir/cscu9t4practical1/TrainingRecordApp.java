package com.stir.cscu9t4practical1;

import com.stir.cscu9t4practical1.entries.RunEntry;
import com.stir.cscu9t4practical1.entries.TrainingRecord;
import com.stir.cscu9t4practical1.gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public final class TrainingRecordApp {

    private static final TrainingRecord trainingRecord = new TrainingRecord();
    private static final MainFrame mainFrame = new MainFrame(trainingRecord);

    static {
        // dummy data while testing
        mainFrame.requestCreationOfEntry(new RunEntry("Alice", LocalDateTime.now(), 10.0));
        mainFrame.requestCreationOfEntry(new RunEntry("Bob", LocalDateTime.now(), 10.0));
        mainFrame.requestCreationOfEntry(new RunEntry("Charlie", LocalDateTime.now(), 10.0));
        mainFrame.requestCreationOfEntry(new RunEntry("David", LocalDateTime.now(), 10.0));

        mainFrame.setPreferredSize(new Dimension(800, 400));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle("Training Record Manager Ultimate Pro Edition");
    }

    public static void main(String[] args) {
        mainFrame.setVisible(true);
    }
}
