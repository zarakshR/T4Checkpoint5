// This is the only GUI class with enough public methods to unit test meaningfully
// Unfortunately we don't have stub implementations for entries.* so we can't do much for most tests except call a function and
// check that it doesn't throw
package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.entries.RunEntry;
import com.stir.cscu9t4practical1.entries.TrainingRecord;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainFrameTest {

    private static final TrainingRecord mockTrainingRecord = new TrainingRecord();
    private static final MainFrame mockMainFrame = new MainFrame(mockTrainingRecord);
    private static final Entry mockEntry = new RunEntry("Mariam", LocalDateTime.now(), 10.0);

    private static final Entry alice = new RunEntry("Alice", LocalDateTime.now(), 10.0);
    private static final Entry bob = new RunEntry("Bob", LocalDateTime.now(), 10.0);
    private static final Entry charlie = new RunEntry("Charlie", LocalDateTime.now(), 10.0);
    // extra Charlies for everyone
    private static final Entry charlie2 = new RunEntry("Charlie", LocalDateTime.of(1,1,1,1,1,1,1), 10.0);
    private static final Entry david = new RunEntry("David", LocalDateTime.now(), 10.0);

    static  {
        mockTrainingRecord.addEntry(alice);
        mockTrainingRecord.addEntry(bob);
        mockTrainingRecord.addEntry(charlie);
        mockTrainingRecord.addEntry(charlie2);
        mockTrainingRecord.addEntry(david);
    }

    @Test
    public void testAddEntry() {
        mockMainFrame.addEntry(mockEntry);
        assertTrue(mockTrainingRecord.getEntries().contains(mockEntry));
    }

    // we can't test the following without stubs
    // some of these will create GUI message dialogs, just click OK and proceed
    @Test
    public void testLog() {
        assertDoesNotThrow(() -> mockMainFrame.log("Hello, World!"));
    }

    @Test
    public void testRemoveEntryAtIndex() {
        assertDoesNotThrow(() -> mockMainFrame.removeEntryAtIndex(0));
    }

    @Test
    public void testUpdateWithSearchByName() {
        assertDoesNotThrow(() -> mockMainFrame.updateWithSearchByName("Mariam"));
    }

    @Test
    public void testUpdateWithSearchByDate() {
        assertDoesNotThrow(() -> mockMainFrame.updateWithSearchByDate(LocalDate.now()));
    }

    @Test
    public void testShowWeeklyDistance() {
        assertDoesNotThrow(() -> mockMainFrame.showWeeklyDistance("Mariam"));
    }

    @Test
    public void testReinitializeRecords() {
        assertDoesNotThrow(() -> mockMainFrame.reinitializeRecords());
    }

    @Test
    public void testHandleInvalidInput() {
        assertDoesNotThrow(() -> mockMainFrame.handleInvalidInput(new InvalidFieldsException("FIELD", "VALUE")));
    }
}
