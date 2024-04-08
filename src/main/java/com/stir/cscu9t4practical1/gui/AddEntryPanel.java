package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class AddEntryPanel extends JPanel {

    private final EntryDefinitionPanel entryDefinitionPanel;
    private final JButton addButton;

    public AddEntryPanel() {
        entryDefinitionPanel = new EntryDefinitionPanel();
        addButton = new JButton("Add");

        setLayout(new BorderLayout());
        add(entryDefinitionPanel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }
}
