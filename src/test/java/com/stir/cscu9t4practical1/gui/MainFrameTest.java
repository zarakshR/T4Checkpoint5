// This is the only GUI class with enough public methods to unit test meaningfully
// Unfortunately we don't have stub implementations for entries.* so we can't do much for most tests except call a function and
// check that it doesn't throw
package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.entries.RunEntry;
import com.stir.cscu9t4practical1.entries.TrainingRecordAppModel;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainFrameTest {

    private static final TrainingRecordAppModel mockTrainingRecord = new TrainingRecordAppModelMock();
    private static final MainFrame mainFrame = new MainFrame(mockTrainingRecord);
    private static final Entry mockEntry = new RunEntry("Mariam", LocalDateTime.now(), 10.0);

    @Test
    public void testRequestCreationOfEntry() {
        mainFrame.requestCreationOfEntry(mockEntry);
        assertTrue(mockTrainingRecord.getEntries().contains(mockEntry));
    }

    // we can't test the following without stubs
    // some of these will create GUI message dialogs, just click OK and proceed
    @Test
    public void testRequestLog() {
        assertDoesNotThrow(() -> mainFrame.requestLog("Hello, World!"));
    }

    @Test
    public void testRequestRemovalOfEntryAtIndex() {
        assertDoesNotThrow(() -> mainFrame.requestRemovalOfEntryAtIndex(0));
    }

    @Test
    public void testRequestSearchByName() {
        assertDoesNotThrow(() -> mainFrame.requestSearchByName("Mariam"));
    }

    @Test
    public void testRequestSearchByDate() {
        assertDoesNotThrow(() -> mainFrame.requestSearchByDate(LocalDate.now()));
    }

    @Test
    public void testRequestShowWeeklyDistance() {
        assertDoesNotThrow(() -> mainFrame.requestShowWeeklyDistance("Mariam"));
    }

    @Test
    public void testRequestReinitializeRecords() {
        assertDoesNotThrow(() -> mainFrame.requestReinitializeRecords());
    }

    @Test
    public void testHandleInvalidInput() {
        assertDoesNotThrow(() -> mainFrame.handleInvalidInput(new InvalidFieldsException("FIELD", "VALUE")));
    }

    private static class TrainingRecordAppModelMock implements TrainingRecordAppModel {

        @Override
        public void addEntry(Entry e) {

        }

        @Override
        public void removeEntry(Entry e) {

        }

        @Override
        public Collection<Entry> lookupEntriesByName(String name) {
            return List.of();
        }

        @Override
        public Collection<Entry> lookupEntriesByDay(LocalDate date) {
            return List.of();
        }

        @Override
        public Double lookupWeeklyDistance(String name, LocalDate today) {
            return 0.0;
        }

        @Override
        public Collection<Entry> getEntries() {
            return List.of();
        }
    }
}
