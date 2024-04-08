package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Write tests for this
public class AddEntryPanel extends JPanel implements ActionListener {

    private final EntryPanel entryPanel;

    private final ButtonGroup entryType;
    private final JRadioButton runEntrySelector;
    private final JRadioButton cycleEntrySelector;
    private final JRadioButton swimEntrySelector;
    private final JRadioButton sprintEntrySelector;

    private final JButton addButton;

    public AddEntryPanel() {
        entryPanel = new EntryPanel();

        entryType = new ButtonGroup();
        runEntrySelector = new JRadioButton("Run");
        runEntrySelector.addActionListener(this);
        cycleEntrySelector = new JRadioButton("Cycle");
        cycleEntrySelector.addActionListener(this);
        swimEntrySelector = new JRadioButton("Swim");
        swimEntrySelector.addActionListener(this);
        sprintEntrySelector = new JRadioButton("Sprint");
        sprintEntrySelector.addActionListener(this);

        entryType.add(runEntrySelector);
        entryType.add(cycleEntrySelector);
        entryType.add(swimEntrySelector);
        entryType.add(sprintEntrySelector);

        addButton = new JButton("Add");
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
    public void actionPerformed(ActionEvent e) {
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
            System.out.println("entryPanel = " + entryPanel.emitEntry());
        }
    }
}
