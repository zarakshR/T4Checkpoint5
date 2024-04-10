package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class AddEntryPanel extends JPanel implements ActionListener {

    private final TrainingRecordAppController controller;

    private final EntryPanel entryPanel = new EntryPanel();

    private final JRadioButton runEntrySelector = new JRadioButton("Run");
    private final JRadioButton cycleEntrySelector = new JRadioButton("Cycle");
    private final JRadioButton swimEntrySelector = new JRadioButton("Swim");
    private final JRadioButton sprintEntrySelector = new JRadioButton("Sprint");

    private final JButton addButton = new JButton("Add Entry");

    /**
     Create an <code>AddEntryPanel</code> with the given controller implementation

     @param parentFrame the {@link TrainingRecordAppController} of the running app
     */
    AddEntryPanel(final TrainingRecordAppController parentFrame) {
        controller = parentFrame;

        ButtonGroup entryType = new ButtonGroup();
        entryType.add(runEntrySelector);
        entryType.add(cycleEntrySelector);
        entryType.add(swimEntrySelector);
        entryType.add(sprintEntrySelector);

        runEntrySelector.addActionListener(this);
        cycleEntrySelector.addActionListener(this);
        swimEntrySelector.addActionListener(this);
        sprintEntrySelector.addActionListener(this);

        // addButton should be disabled when the program first starts up
        addButton.setEnabled(false);
        addButton.addActionListener(this);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(entryPanel);
        add(runEntrySelector);
        add(cycleEntrySelector);
        add(swimEntrySelector);
        add(sprintEntrySelector);
        add(addButton);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == runEntrySelector) {
            addButton.setEnabled(true); // enable addButton once the user selects anything
            entryPanel.setEntryType("RUN");
        }
        if (e.getSource() == cycleEntrySelector) {
            addButton.setEnabled(true); // enable addButton once the user selects anything
            entryPanel.setEntryType("CYCLE");
        }
        if (e.getSource() == swimEntrySelector) {
            addButton.setEnabled(true); // enable addButton once the user selects anything
            entryPanel.setEntryType("SWIM");
        }
        if (e.getSource() == sprintEntrySelector) {
            addButton.setEnabled(true); // enable addButton once the user selects anything
            entryPanel.setEntryType("SPRINT");
        }
        if (e.getSource() == addButton) {
            try {
                controller.requestCreationOfEntry(entryPanel.emitEntry());
                entryPanel.clearFields();
            } catch (InvalidFieldsException ex) {
                controller.handleInvalidInput(ex);
            }
        }
    }
}
