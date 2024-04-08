package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Write tests for this
public class MainFrame extends JFrame implements ActionListener {

    private final SearchEntryPanel searchEntryPanel;
    private final RecordsListPanel recordsListPanel;
    private final AddEntryPanel addEntryPanel;
    private final SystemMessagesPanel systemMessagesPanel;

    public MainFrame() {
        searchEntryPanel = new SearchEntryPanel();
        recordsListPanel = new RecordsListPanel();
        addEntryPanel = new AddEntryPanel();
        systemMessagesPanel = new SystemMessagesPanel();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(searchEntryPanel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2.0;
        c.weighty = 1.0;
        add(recordsListPanel, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(addEntryPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.1;
        c.gridwidth = 3;
        add(systemMessagesPanel, c);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
