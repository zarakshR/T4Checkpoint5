package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class EntryPanel extends JPanel {

    private final JPanel blankPanel = new JPanel();
    private final RunTypePanel runEntryPanel = new RunTypePanel();
    private final CycleTypePanel cycleEntryPanel = new CycleTypePanel();
    private final SwimTypePanel swimEntryPanel = new SwimTypePanel();
    private final SprintTypePanel sprintEntryPanel = new SprintTypePanel();

    public EntryPanel() {
        setLayout(new CardLayout());

        add(blankPanel, "BLANK");
        add(runEntryPanel, "RUN");
        add(cycleEntryPanel, "CYCLE");
        add(swimEntryPanel, "SWIM");
        add(sprintEntryPanel, "SPRINT");
    }

    private final static class LabelledTextPanel extends JPanel {

        private final JTextField textField = new JTextField(30);

        public LabelledTextPanel(String labelText) {
            add(new JLabel(labelText));
            add(textField);
        }
    }

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
    }

    private final static class RunTypePanel extends EntryTypePanel {

        private RunTypePanel() {
            super();
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
    }

    private final static class SwimTypePanel extends EntryTypePanel {

        private final LabelledTextPanel locationField;

        private SwimTypePanel() {
            super();
            this.locationField = new LabelledTextPanel("Location");
            add(locationField);
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
    }
}
