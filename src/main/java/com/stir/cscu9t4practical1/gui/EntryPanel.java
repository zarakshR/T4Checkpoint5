// This is a giant file that handles Entry specific UI functionality
package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.*;
import com.stir.cscu9t4practical1.entries.CycleEntry.TEMPO;
import com.stir.cscu9t4practical1.entries.SwimEntry.LOCATION;
import com.stir.cscu9t4practical1.gui.util.DateEntryPanel;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;
import com.stir.cscu9t4practical1.gui.util.LabelledTextPanel;
import com.stir.cscu9t4practical1.gui.util.TimeEntryPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// TODO: Write tests for this
final class EntryPanel extends JPanel {

    private final RunFieldsPanel runEntryPanel = new RunFieldsPanel();
    private final CycleFieldsPanel cycleEntryPanel = new CycleFieldsPanel();
    private final SwimFieldsPanel swimEntryPanel = new SwimFieldsPanel();
    private final SprintFieldsPanel sprintEntryPanel = new SprintFieldsPanel();

    // CardLayout does not have an API for determining what the currently showing card is so we have to manually keep track of it
    private String currentlyShowing;

    public EntryPanel() {
        setLayout(new CardLayout());

        // CardLayout shows the first added card by default, so this will show a blank panel until the user selects one.
        // do not add a string key to the blank panel to ensure that it cannot be shown once the user has selected any entry panel
        JPanel blankPanel = new JPanel();
        add(blankPanel);

        add(runEntryPanel, "RUN");
        add(cycleEntryPanel, "CYCLE");
        add(swimEntryPanel, "SWIM");
        add(sprintEntryPanel, "SPRINT");
    }

    public void setCurrentlyShowing(final String currentlyShowing) {
        this.currentlyShowing = currentlyShowing;
    }

    // this is really hacky, but we have no choice since CardLayout doesn't do this for us. hopefully failing early with an
    //  exception will alert us early in case something goes wrong.
    // NullPointerException can be thrown iff blank panel is still being shown
    private EntryFieldsPanel getActivePanel() throws NullPointerException {
        return switch (currentlyShowing) {
            case "RUN" -> runEntryPanel;
            case "CYCLE" -> cycleEntryPanel;
            case "SWIM" -> swimEntryPanel;
            case "SPRINT" -> sprintEntryPanel;
            default -> throw new RuntimeException("Attempted to access entry panel for unknown entry key: " + currentlyShowing);
        };
    }

    public Entry emitEntry() throws InvalidFieldsException, NullPointerException {
        return getActivePanel().emitEntry();
    }

    public void clearFields() throws NullPointerException {
        getActivePanel().clearFields();
    }

    // the below class hierarchy is as follows:
    //      abstract EntryFieldsPanel extends JPanel
    //                  |- RunFieldsPanel
    //                  |- CycleFieldsPanel
    //                  |- SwimFieldsPanel
    //                  |- SprintFieldsPanel
    // these panels contain entry fields specific to each entry type (since they may be different) and implement entry type
    //  specific UI functionality (e.g., CycleEntry contains a combo box for terrain and tempo, SprintEntry has text areas for
    //  repetitions and recovery) and are swapped in and out by EntryPanel.
    // these should be the only classes in our UI which concern themselves with the internal details of the various Entry types
    // TODO: bump language level to 17 to get sealed classes
    private abstract static  class EntryFieldsPanel extends JPanel {

        protected final LabelledTextPanel nameField = new LabelledTextPanel("Name", 30);
        protected final DateEntryPanel dateEntryPanel = new DateEntryPanel();
        protected final TimeEntryPanel timeEntryPanel = new TimeEntryPanel();
        protected final LabelledTextPanel distanceField = new LabelledTextPanel("Distance", 30);

        private EntryFieldsPanel() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

            add(nameField);
            add(dateEntryPanel);
            add(timeEntryPanel);
            add(distanceField);
        }

        // There is some ugly and repetitive (but robust) error handling code in the emitEntry implementations below. We could have
        // had simpler code by just throwing the exceptions upward and letting AddEntryPanel handle it, but we get much nicer error
        //  messages this way + AddEntry panel now does not need to concern itself with the implementation details of Entry types
        abstract Entry emitEntry() throws InvalidFieldsException;

        void clearFields() {
            this.nameField.setText(null);
            this.dateEntryPanel.clearFields();
            this.timeEntryPanel.clearFields();
            this.distanceField.setText(null);
        }
    }

    private static final class RunFieldsPanel extends EntryFieldsPanel {

        private RunFieldsPanel() {
            super();
        }

        @Override
        Entry emitEntry() throws InvalidFieldsException {
            String name = nameField.getText();
            String distanceText = distanceField.getText();
            double distance;

            if (name.isEmpty()) {
                throw new InvalidFieldsException("Name", name);
            }

            LocalDate date = dateEntryPanel.getDate();
            LocalTime time = timeEntryPanel.getTime();
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            try {
                distance = Double.parseDouble(distanceText);
            } catch (NumberFormatException e) {
                throw new InvalidFieldsException("Distance", distanceText);
            }

            return new RunEntry(name, dateTime, distance);
        }

        @Override
        void clearFields() throws NullPointerException {
            super.clearFields();
        }
    }

    private static final class CycleFieldsPanel extends EntryFieldsPanel {

        private final JComboBox<CycleEntry.TERRAIN> terrainBox = new JComboBox<CycleEntry.TERRAIN>(CycleEntry.TERRAIN.values());
        private final JComboBox<CycleEntry.TEMPO> tempoBox = new JComboBox<CycleEntry.TEMPO>(CycleEntry.TEMPO.values());

        private CycleFieldsPanel() {
            super();
            add(terrainBox);
            add(tempoBox);
        }

        @Override
        Entry emitEntry() throws InvalidFieldsException {
            String name = nameField.getText();
            String distanceText = distanceField.getText();
            double distance;

            if (name.isEmpty()) {
                throw new InvalidFieldsException("Name", name);
            }

            LocalDate date = dateEntryPanel.getDate();
            LocalTime time = timeEntryPanel.getTime();
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            try {
                distance = Double.parseDouble(distanceText);
            } catch (NumberFormatException e) {
                throw new InvalidFieldsException("Distance", distanceText);
            }

            return new CycleEntry(name, dateTime, distance,
                    (CycleEntry.TERRAIN) terrainBox.getSelectedItem(),
                    (TEMPO) tempoBox.getSelectedItem());
        }

        @Override
        void clearFields() throws NullPointerException {
            super.clearFields();
        }
    }

    private static final class SwimFieldsPanel extends EntryFieldsPanel {

        private final JComboBox<LOCATION> locationField = new JComboBox<>(LOCATION.values());

        private SwimFieldsPanel() {
            super();
            add(locationField);
        }

        @Override
        Entry emitEntry() throws InvalidFieldsException {
            String name = nameField.getText();
            String distanceText = distanceField.getText();
            double distance;

            if (name.isEmpty()) {
                throw new InvalidFieldsException("Name", name);
            }

            LocalDate date = dateEntryPanel.getDate();
            LocalTime time = timeEntryPanel.getTime();
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            try {
                distance = Double.parseDouble(distanceText);
                return new SwimEntry(name, dateTime, distance, (LOCATION) locationField.getSelectedItem());
            } catch (NumberFormatException e) {
                throw new InvalidFieldsException("Double", distanceText);
            }
        }

        @Override
        void clearFields() throws NullPointerException {
            super.clearFields();
        }
    }

    private static final class SprintFieldsPanel extends EntryFieldsPanel {

        private final LabelledTextPanel repetitionsField = new LabelledTextPanel("Repetitions", 10);
        private final LabelledTextPanel recoveryField = new LabelledTextPanel("Recovery", 30);

        private SprintFieldsPanel() {
            super();
            add(repetitionsField);
            add(recoveryField);
        }

        @Override
        Entry emitEntry() throws InvalidFieldsException {
            String name;
            String distanceText = distanceField.getText();
            double distance;
            String repetitionsText = repetitionsField.getText();
            int repetitions;
            String recoveryText = recoveryField.getText();
            int recovery;

            name = nameField.getText();
            if (name.isEmpty()) {
                throw new InvalidFieldsException("Name", name);
            }

            LocalDate date = dateEntryPanel.getDate();
            LocalTime time = timeEntryPanel.getTime();
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            try {
                distance = Double.parseDouble(distanceText);
            } catch (NumberFormatException e) {
                throw new InvalidFieldsException("Distance", distanceText);
            }

            try {
                repetitions = Integer.parseInt(repetitionsText);
            } catch (NumberFormatException e) {
                throw new InvalidFieldsException("Repetitions", repetitionsText);
            }

            try {
                recovery = Integer.parseInt(recoveryText);
            } catch (NumberFormatException e) {
                throw new InvalidFieldsException("Recovery", recoveryText);
            }

            return new SprintEntry(name, dateTime, distance, repetitions, recovery);
        }

        @Override
        void clearFields() throws NullPointerException {
            super.clearFields();
            this.repetitionsField.setText(null);
            this.recoveryField.setText(null);
        }
    }

}
