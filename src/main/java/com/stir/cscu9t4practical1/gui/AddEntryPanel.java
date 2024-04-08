package com.stir.cscu9t4practical1.gui;

import javax.swing.*;

// TODO: Write tests for this
public class AddEntryPanel extends JPanel {

    private final EntryPanel entryPanel;

    private final ButtonGroup entryType;
    private final JRadioButton runEntryType;
    private final JRadioButton cycleEntryType;
    private final JRadioButton swimEntryType;
    private final JRadioButton sprintEntryType;

    private final JButton addButton;

    public AddEntryPanel() {
        entryPanel = new EntryPanel();

        entryType = new ButtonGroup();
        runEntryType = new JRadioButton("Run");
        cycleEntryType = new JRadioButton("Cycle");
        swimEntryType = new JRadioButton("Swim");
        sprintEntryType = new JRadioButton("Sprint");
        entryType.add(runEntryType);
        entryType.add(cycleEntryType);
        entryType.add(swimEntryType);
        entryType.add(sprintEntryType);

        addButton = new JButton("Add");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(entryPanel);
        add(runEntryType);
        add(cycleEntryType);
        add(swimEntryType);
        add(sprintEntryType);
        add(addButton);
    }
}
