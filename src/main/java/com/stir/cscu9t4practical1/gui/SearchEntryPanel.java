package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class SearchEntryPanel extends JPanel {

    private EntryDefinitionPanel entryDefinitionPanel;

    public SearchEntryPanel() {
        entryDefinitionPanel = new EntryDefinitionPanel();

        setLayout(new BorderLayout());
        add(entryDefinitionPanel, BorderLayout.CENTER);
    }
}
