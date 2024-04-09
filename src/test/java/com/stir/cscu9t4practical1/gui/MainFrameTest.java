package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.entries.RunEntry;
import com.stir.cscu9t4practical1.entries.TrainingRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class MainFrameTest {

    private static TrainingRecord mockTrainingRecord;
    private static MainFrame mockMainFrame;
    private static final Entry mockEntry = new RunEntry("Mariam", LocalDateTime.now(), 10.0);

    Entry alice = new RunEntry("Alice", LocalDateTime.now(), 10.0);
    Entry bob = new RunEntry("Bob", LocalDateTime.now(), 10.0);
    Entry charlie = new RunEntry("Charlie", LocalDateTime.now(), 10.0);
    // extra Charlies for everyone
    Entry charlie2 = new RunEntry("Charlie", LocalDateTime.of(1,1,1,1,1,1,1), 10.0);
    Entry david = new RunEntry("David", LocalDateTime.now(), 10.0);

    @BeforeEach
    public void buildEntries() {
        mockTrainingRecord = new TrainingRecord();

        mockTrainingRecord.addEntry(alice);
        mockTrainingRecord.addEntry(bob);
        mockTrainingRecord.addEntry(charlie);
        mockTrainingRecord.addEntry(charlie2);
        mockTrainingRecord.addEntry(david);

        mockMainFrame = new MainFrame(mockTrainingRecord);
    }

    @Test
    public void testAddEntry() {
        mockMainFrame.addEntry(mockEntry);
        assertTrue(mockTrainingRecord.getEntries().contains(mockEntry));
    }
}
