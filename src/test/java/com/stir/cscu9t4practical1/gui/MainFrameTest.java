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

    private static final Entry mockEntry = new RunEntry("Mariam", LocalDateTime.now(), 10.0);
    private static final String mockName = "Mariam";
    private static final LocalDate mockDate = LocalDate.of(1,1,1);
    private static final LocalDate mockToday = LocalDate.of(9,9,9);
    private static final TrainingRecordAppModel mockTrainingRecord
            = new TrainingRecordAppModelMock(mockEntry, mockName, mockDate);
    private static final MainFrame mainFrame = new MainFrame(mockTrainingRecord);

    @Test
    public void testRequestCreationOfEntry() {
        assertDoesNotThrow(() -> mainFrame.requestCreationOfEntry(mockEntry));
    }

    // we can't test the following without stubs
    // some of these will create GUI message dialogs, just click OK and proceed
    @Test
    public void testRequestLog() {
        assertDoesNotThrow(() -> mainFrame.requestLog("Hello, World!"));
    }

    @Test
    public void testRequestRemovalOfEntryAtIndex() {
        mainFrame.requestCreationOfEntry(mockEntry);
        assertDoesNotThrow(() -> mainFrame.requestRemovalOfEntryAtIndex(0));
    }

    @Test
    public void testRequestSearchByName() {
        assertDoesNotThrow(() -> mainFrame.requestSearchByName(mockName));
    }

    @Test
    public void testRequestSearchByDate() {
        assertDoesNotThrow(() -> mainFrame.requestSearchByDate(mockDate));
    }

    @Test
    public void testRequestShowWeeklyDistance() {
        assertDoesNotThrow(() -> mainFrame.requestShowWeeklyDistance(mockName));
    }

    @Test
    public void testRequestReinitializeRecords() {
        assertDoesNotThrow(() -> mainFrame.requestReinitializeRecords());
    }

    @Test
    public void testHandleInvalidInput() {
        assertDoesNotThrow(() -> mainFrame.handleInvalidInput(new InvalidFieldsException("FIELD", "VALUE")));
    }

    private record TrainingRecordAppModelMock(Entry expectedEntry, String expectedName, LocalDate expectedDate)
            implements TrainingRecordAppModel {

        @Override
        public void addEntry(Entry e) throws RuntimeException {
            if (!(e.equals(expectedEntry))) {
                throw new RuntimeException();
            }
        }

        @Override
        public void removeEntry(Entry e) {
            if (!(e.equals(expectedEntry))) {
                throw new RuntimeException();
            }
        }

        @Override
        public Collection<Entry> lookupEntriesByName(String name) {
            if (!(name.equals(expectedName))) {
                throw new RuntimeException();
            }

            return List.of();
        }

        @Override
        public Collection<Entry> lookupEntriesByDay(LocalDate date) {
            if (!(date.equals(expectedDate))) {
                throw new RuntimeException();
            }

            return List.of();
        }

        @Override
        public Double lookupWeeklyDistance(String name, LocalDate today) {
            if (!(name.equals(expectedName) && today.equals(LocalDate.now()))) {
                throw new RuntimeException();
            }

            return 0.0;
        }

        @Override
        public Collection<Entry> getEntries() {
            return List.of();
        }
    }
}
