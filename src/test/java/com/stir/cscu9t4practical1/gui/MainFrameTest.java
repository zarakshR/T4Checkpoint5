// This is the only GUI class with enough public methods to unit test meaningfully
// Unfortunately we don't have stub implementations for entries.* so we can't do much for most tests except call a function and
// check that it doesn't throw
package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.entries.RunEntry;
import com.stir.cscu9t4practical1.entries.TrainingRecord;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainFrameTest {

    private static final TrainingRecord mockTrainingRecord = new TrainingRecord();
    private static final MainFrame mockMainFrame = new MainFrame(mockTrainingRecord);
    private static final Entry mockEntry = new RunEntry("Mariam", LocalDateTime.now(), 10.0);

    private static final Entry alice = new RunEntry("Alice", LocalDateTime.now(), 10.0);
    private static final Entry bob = new RunEntry("Bob", LocalDateTime.now(), 10.0);
    private static final Entry charlie = new RunEntry("Charlie", LocalDateTime.now(), 10.0);
    // extra Charlies for everyone
    private static final Entry charlie2 = new RunEntry("Charlie", LocalDateTime.of(1, 1, 1, 1, 1, 1, 1), 10.0);
    private static final Entry david = new RunEntry("David", LocalDateTime.now(), 10.0);

    static {
        mockTrainingRecord.addEntry(alice);
        mockTrainingRecord.addEntry(bob);
        mockTrainingRecord.addEntry(charlie);
        mockTrainingRecord.addEntry(charlie2);
        mockTrainingRecord.addEntry(david);
    }

    @Test
    public void testRequestCreationOfEntry() {
        mockMainFrame.requestCreationOfEntry(mockEntry);
        assertTrue(mockTrainingRecord.getEntries().contains(mockEntry));
    }

    // we can't test the following without stubs
    // some of these will create GUI message dialogs, just click OK and proceed
    @Test
    public void testRequestLog() {
        assertDoesNotThrow(() -> mockMainFrame.requestLog("Hello, World!"));
    }

    @Test
    public void testRequestRemovalOfEntryAtIndex() {
        assertDoesNotThrow(() -> mockMainFrame.requestRemovalOfEntryAtIndex(0));
    }

    @Test
    public void testRequestSearchByName() {
        assertDoesNotThrow(() -> mockMainFrame.requestSearchByName("Mariam"));
    }

    @Test
    public void testRequestSearchByDate() {
        assertDoesNotThrow(() -> mockMainFrame.requestSearchByDate(LocalDate.now()));
    }

    @Test
    public void testRequestShowWeeklyDistance() {
        assertDoesNotThrow(() -> mockMainFrame.requestShowWeeklyDistance("Mariam"));
    }

    @Test
    public void testRequestReinitializeRecords() {
        assertDoesNotThrow(() -> mockMainFrame.requestReinitializeRecords());
    }

    @Test
    public void testHandleInvalidInput() {
        assertDoesNotThrow(() -> mockMainFrame.handleInvalidInput(new InvalidFieldsException("FIELD", "VALUE")));
    }
}
