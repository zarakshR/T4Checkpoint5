package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class SearchEntryPanel extends JPanel {

    // TODO: Remove this: our search panel won't need an EntryDefinitionPanel
    private EntryDefinitionPanel entryDefinitionPanel;
    private JButton searchByEntryButton;
    private JButton searchByDateButton;

    public SearchEntryPanel() {
        entryDefinitionPanel = new EntryDefinitionPanel();
        searchByEntryButton = new JButton("Search Entry");
        searchByDateButton = new JButton("Search By Date");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(entryDefinitionPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.01;
        add(searchByEntryButton, c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 0.01;
        add(searchByDateButton, c);
    }
}
