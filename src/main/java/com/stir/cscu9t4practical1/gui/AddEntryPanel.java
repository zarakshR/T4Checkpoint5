package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 AddEntryPanel contains an EntryPanel and allows the user to switch between adding different types of Entrys while instructing
 EntryPanel to show fields appropriate to the selected Entry type
 */
final class AddEntryPanel extends JPanel implements ActionListener {

    private final TrainingRecordAppController controller;

    private final EntryPanel entryPanel = new EntryPanel();

    private final JRadioButton runEntrySelector = new JRadioButton("Run");
    private final JRadioButton cycleEntrySelector = new JRadioButton("Cycle");
    private final JRadioButton swimEntrySelector = new JRadioButton("Swim");
    private final JRadioButton sprintEntrySelector = new JRadioButton("Sprint");

    private final JButton addButton = new JButton("Add Entry");

    /**
     Instantiates a new Add entry panel.

     @param parentFrame the controller that handles adding entries
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

        addButton.addActionListener(this);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(entryPanel);
        add(runEntrySelector);
        add(cycleEntrySelector);
        add(swimEntrySelector);
        add(sprintEntrySelector);
        add(addButton);
    }

    // refer to EntryPanel.java for an explanation of why we have to manually keep track of the currently shown card
    @Override
    public void actionPerformed(final ActionEvent e) {
        CardLayout cardLayout = (CardLayout) entryPanel.getLayout();

        if (e.getSource() == runEntrySelector) {
            cardLayout.show(entryPanel, "RUN");
            entryPanel.setCurrentlyShowing("RUN");
        }
        if (e.getSource() == cycleEntrySelector) {
            cardLayout.show(entryPanel, "CYCLE");
            entryPanel.setCurrentlyShowing("CYCLE");
        }
        if (e.getSource() == swimEntrySelector) {
            cardLayout.show(entryPanel, "SWIM");
            entryPanel.setCurrentlyShowing("SWIM");
        }
        if (e.getSource() == sprintEntrySelector) {
            cardLayout.show(entryPanel, "SPRINT");
            entryPanel.setCurrentlyShowing("SPRINT");
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
