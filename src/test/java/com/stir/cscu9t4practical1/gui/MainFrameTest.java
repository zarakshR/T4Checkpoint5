// This is the only GUI class with enough public methods to unit test meaningfully
// Use a mock implementation of TrainingRecordAppModel to check that MainFrame is doing the right thing
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

public class MainFrameTest {

    private static final Entry mockEntry = new RunEntry("Mariam", LocalDateTime.now(), 10.0);
    private static final String mockName = "Mariam";
    private static final LocalDate mockDate = LocalDate.of(1,1,1);
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
        // after we add this here, it should be the 0'th entry. this assumes that requestCreationOfEntry is working, so if this
        //  test fails, make sure that test is working first before expecting to find an issue here.
        // We cannot directly add an Entry to mockTrainingRecord because it will not also get added to the internal list model
        // of MainFrame
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

    // The mock TrainingRecordAppModel. It is constructed with the entries and dates we expect to call from the tests and
    // throws a RuntimeException if the expected entries/dates are not called by MainFrame
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
        public double lookupWeeklyDistance(String name, LocalDate today) {
            // mainFrame must call weekly distance using today's date as the end point
            if (!(name.equals(expectedName) && today.equals(LocalDate.now()))) {
                throw new RuntimeException();
            }

            return 0.0;
        }

        @Override
        public Collection<Entry> getEntries() {
            // no way to mock this as such
            return List.of();
        }
    }
}
