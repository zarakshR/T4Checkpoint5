package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Write tests for this
public class AddEntryPanel extends JPanel implements ActionListener {

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
        runEntryType.addActionListener(this);
        cycleEntryType = new JRadioButton("Cycle");
        cycleEntryType.addActionListener(this);
        swimEntryType = new JRadioButton("Swim");
        swimEntryType.addActionListener(this);
        sprintEntryType = new JRadioButton("Sprint");
        sprintEntryType.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) entryPanel.getLayout();

        if (e.getSource() == runEntryType) {
            cardLayout.show(entryPanel, "RUN");
        }
        if (e.getSource() == cycleEntryType) {
            cardLayout.show(entryPanel, "CYCLE");
        }
        if (e.getSource() == swimEntryType) {
            cardLayout.show(entryPanel, "SWIM");
        }
        if (e.getSource() == sprintEntryType) {
            cardLayout.show(entryPanel, "SPRINT");
        }
    }
}
