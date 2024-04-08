package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class AddEntryPanel extends JPanel {

    private final EntryDefinitionPanel entryDefinitionPanel;

    public AddEntryPanel() {
        entryDefinitionPanel = new EntryDefinitionPanel();

        setLayout(new BorderLayout());
        add(entryDefinitionPanel, BorderLayout.CENTER);
    }
}
