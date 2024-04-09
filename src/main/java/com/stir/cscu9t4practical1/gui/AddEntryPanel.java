package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import javax.swing.*;
import java.awt.*;
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
            entryPanel.setEntryType("RUN");
        }
        if (e.getSource() == cycleEntrySelector) {
            entryPanel.setEntryType("CYCLE");
        }
        if (e.getSource() == swimEntrySelector) {
            entryPanel.setEntryType("SWIM");
        }
        if (e.getSource() == sprintEntrySelector) {
            entryPanel.setEntryType("SPRINT");
        }
        if (e.getSource() == addButton) {
            try {
                controller.addEntry(entryPanel.emitEntry());
                entryPanel.clearFields();
            } catch (NullPointerException ex) {
                // NullPointerException is thrown iff blank panel is still active in which case do nothing
            } catch (InvalidFieldsException ex) {
                controller.handleInvalidInput(ex);
            }
        }
    }
}
