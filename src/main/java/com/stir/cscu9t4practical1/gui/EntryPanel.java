package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.*;

import javax.swing.*;
import java.awt.*;
import java.time.ZonedDateTime;

// TODO: Write tests for this
public class EntryPanel extends JPanel {

    private final JPanel blankPanel = new JPanel();
    private final RunTypePanel runEntryPanel = new RunTypePanel();
    private final CycleTypePanel cycleEntryPanel = new CycleTypePanel();
    private final SwimTypePanel swimEntryPanel = new SwimTypePanel();
    private final SprintTypePanel sprintEntryPanel = new SprintTypePanel();

    // CardLayout does not have an API for determining what the currently showing card is so we have to manually keep track of it
    private String currentlyShowing;

    public EntryPanel() {
        setLayout(new CardLayout());

        // CardLayout shows the first added card by default, so this will show a blank panel until the user selects one.
        // do not add a string key to the blank panel to ensure that it cannot be shown once the user has selected any entry panel
        add(blankPanel);
        add(runEntryPanel, "RUN");
        add(cycleEntryPanel, "CYCLE");
        add(swimEntryPanel, "SWIM");
        add(sprintEntryPanel, "SPRINT");
    }

    public void setCurrentlyShowing(String currentlyShowing) {
        this.currentlyShowing = currentlyShowing;
    }

    // this is really hacky, but we have no choice since CardLayout doesn't do this for us. hopefully failing early with an
    //  exception will alert us early in case something goes wrong.
    public Entry emitEntry() {
        switch (currentlyShowing) {
            case "RUN":
                return runEntryPanel.emitEntry();
            case "CYCLE":
                return cycleEntryPanel.emitEntry();
            case "SWIM":
                return swimEntryPanel.emitEntry();
            case "SPRINT":
                return sprintEntryPanel.emitEntry();
            default:
                throw new RuntimeException("Attempted to emit entry for unknown entry key: " + currentlyShowing);
        }
    }

    public void clearFields() {
        switch (currentlyShowing) {
            case "RUN":
                runEntryPanel.clearFields();
                break;
            case "CYCLE":
                cycleEntryPanel.clearFields();
                break;
            case "SWIM":
                swimEntryPanel.clearFields();
                break;
            case "SPRINT":
                sprintEntryPanel.clearFields();
                break;
            default:
                throw new RuntimeException("Attempted to clear fields for unknown entry key: " + currentlyShowing);
        }
    }

    // TODO: all the classes return dummy value for testing purposes. change them to parse from the date field
    // TODO: add error checking with exceptions
    private abstract static class EntryTypePanel extends JPanel {

        protected final LabelledTextPanel nameField;
        protected final LabelledTextPanel dateField;
        protected final LabelledTextPanel distanceField;

        private EntryTypePanel() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            this.nameField = new LabelledTextPanel("Name");
            this.dateField = new LabelledTextPanel("Date");
            this.distanceField = new LabelledTextPanel("Distance");
            add(nameField);
            add(dateField);
            add(distanceField);
        }

        abstract Entry emitEntry();

        void clearFields() {
            this.nameField.getTextField().setText(null);
            this.dateField.getTextField().setText(null);
            this.distanceField.getTextField().setText(null);
        }
    }

    private final static class RunTypePanel extends EntryTypePanel {

        private RunTypePanel() {
            super();
        }

        @Override
        Entry emitEntry() {
            return new RunEntry(
                    nameField.getTextField().getText(),
                    ZonedDateTime.now(),
                    Double.parseDouble(distanceField.getTextField().getText())
            );
        }

        @Override
        void clearFields() {
            super.clearFields();
        }
    }

    private final static class CycleTypePanel extends EntryTypePanel {

        private final LabelledTextPanel terrainField;
        private final LabelledTextPanel tempoField;

        private CycleTypePanel() {
            super();
            this.terrainField = new LabelledTextPanel("Terrain");
            this.tempoField = new LabelledTextPanel("Tempo");
            add(terrainField);
            add(tempoField);
        }

        @Override
        Entry emitEntry() {
            return new CycleEntry(
                    nameField.getTextField().getText(),
                    ZonedDateTime.now(),
                    Double.parseDouble(distanceField.getTextField().getText()),
                    CycleEntry.Terrain.ASPHALT,
                    CycleEntry.Tempo.MODERATE
            );
        }

        @Override
        void clearFields() {
            super.clearFields();
            this.terrainField.getTextField().setText(null);
            this.tempoField.getTextField().setText(null);
        }
    }

    private final static class SwimTypePanel extends EntryTypePanel {

        private final LabelledTextPanel locationField;

        private SwimTypePanel() {
            super();
            this.locationField = new LabelledTextPanel("Location");
            add(locationField);
        }

        @Override
        Entry emitEntry() {
            return new SwimEntry(
                    nameField.getTextField().getText(),
                    ZonedDateTime.now(),
                    Double.parseDouble(distanceField.getTextField().getText()),
                    SwimEntry.LOCATION.OUTDOORS
            );
        }

        @Override
        void clearFields() {
            super.clearFields();
            this.locationField.getTextField().setText(null);
        }
    }

    private final static class SprintTypePanel extends EntryTypePanel {

        private final LabelledTextPanel repetitionsField;
        private final LabelledTextPanel recoveryField;

        private SprintTypePanel() {
            super();
            this.repetitionsField = new LabelledTextPanel("Terrain");
            this.recoveryField = new LabelledTextPanel("Tempo");
            add(repetitionsField);
            add(recoveryField);
        }

        @Override
        Entry emitEntry() {
            return new SprintEntry(
                    nameField.getTextField().getText(),
                    ZonedDateTime.now(),
                    Double.parseDouble(distanceField.getTextField().getText()),
                    Integer.parseInt(repetitionsField.getTextField().getText()),
                    Integer.parseInt(recoveryField.getTextField().getText())
            );
        }

        @Override
        void clearFields() {
            super.clearFields();
            this.repetitionsField.getTextField().setText(null);
            this.recoveryField.getTextField().setText(null);
        }
    }
}
