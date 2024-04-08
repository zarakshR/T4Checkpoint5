package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Write tests for this
public class AddEntryPanel extends JPanel implements ActionListener {

    private final MainFrame mainFrame;

    private final EntryPanel entryPanel = new EntryPanel();

    private final JRadioButton runEntrySelector = new JRadioButton("Run");
    private final JRadioButton cycleEntrySelector = new JRadioButton("Cycle");
    private final JRadioButton swimEntrySelector = new JRadioButton("Swim");
    private final JRadioButton sprintEntrySelector = new JRadioButton("Sprint");

    private final JButton addButton = new JButton("Add Entry");

    public AddEntryPanel(MainFrame parentFrame) {
        mainFrame = parentFrame;

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
            mainFrame.addEntry(entryPanel.emitEntry());
            entryPanel.clearFields();
        }
    }
}
