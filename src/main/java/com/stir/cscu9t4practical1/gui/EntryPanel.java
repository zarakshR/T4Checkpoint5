package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.*;

import javax.swing.*;
import java.awt.*;
import java.time.ZonedDateTime;

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
    private EntryFieldsPanel getActivePanel() {
        return switch (currentlyShowing) {
            case "RUN" -> runEntryPanel;
            case "CYCLE"-> cycleEntryPanel;
            case "SWIM" -> swimEntryPanel;
            case "SPRINT" -> sprintEntryPanel;
            default -> throw new RuntimeException("Attempted to access entry panel for unknown entry key: " + currentlyShowing);
        };
    }

    public Entry emitEntry() {
        return getActivePanel().emitEntry();
    }

    public void clearFields() {
        getActivePanel().clearFields();
    }

    // TODO: all the classes return dummy value for testing purposes. change them to parse from the date field
    // TODO: add error checking with exceptions
    private abstract static class EntryFieldsPanel extends JPanel {

        protected final LabelledTextPanel nameField;
        protected final LabelledTextPanel dateField;
        protected final LabelledTextPanel distanceField;

        private EntryFieldsPanel() {
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

    private static final class RunFieldsPanel extends EntryFieldsPanel {

        private RunFieldsPanel() {
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
    }

    private static final class CycleFieldsPanel extends EntryFieldsPanel {

        private final LabelledTextPanel terrainField;
        private final LabelledTextPanel tempoField;

        private CycleFieldsPanel() {
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

    private static final class SwimFieldsPanel extends EntryFieldsPanel {

        private final LabelledTextPanel locationField;

        private SwimFieldsPanel() {
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

    private static final class SprintFieldsPanel extends EntryFieldsPanel {

        private final LabelledTextPanel repetitionsField;
        private final LabelledTextPanel recoveryField;

        private SprintFieldsPanel() {
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
