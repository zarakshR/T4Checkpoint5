package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.gui.util.DateEntryPanel;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;
import com.stir.cscu9t4practical1.gui.util.LabelledTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Write tests for this
final class SearchPanel extends JPanel implements ActionListener {

    private final MainFrame mainFrame;

    private final NameSearchPanel nameSearchPanel = new NameSearchPanel(this);
    private final DateSearchPanel dateSearchPanel = new DateSearchPanel(this);

    SearchPanel(MainFrame parentFrame) {
        mainFrame = parentFrame;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(nameSearchPanel);
        add(dateSearchPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameSearchPanel.searchByNameButton) {
            try {
                System.out.println("name search = " + nameSearchPanel.getValidatedName());
            } catch (InvalidFieldsException ex) {
                mainFrame.handleInvalidInput(ex);
            }
        }
        if (e.getSource() == nameSearchPanel.weeklyDistanceButton) {
            try {
                System.out.println("weekly distance = " + nameSearchPanel.getValidatedName());
            } catch (InvalidFieldsException ex) {
                mainFrame.handleInvalidInput(ex);
            }
        }
        if (e.getSource() == dateSearchPanel.searchByDateButton) {
            try {
                System.out.println("date search = " + dateSearchPanel.dateEntryPanel.getDate());
            } catch (InvalidFieldsException ex) {
                mainFrame.handleInvalidInput(ex);
            }
        }
    }

    // We need these two to be separate panels, otherwise the layout looks horrible
    private static final class NameSearchPanel extends JPanel {

        private final LabelledTextPanel nameField = new LabelledTextPanel("Name", 30);
        private final JButton searchByNameButton = new JButton("Search By Name");
        private final JButton weeklyDistanceButton = new JButton("Calculate Weekly Distance");

        NameSearchPanel(ActionListener controller) {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            add(nameField, c);

            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 1;
            add(searchByNameButton, c);
            searchByNameButton.addActionListener(controller);

            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth = 1;
            add(weeklyDistanceButton, c);
            weeklyDistanceButton.addActionListener(controller);
        }

        public String getValidatedName() throws InvalidFieldsException {
            String name = nameField.getText();
            if (name.isEmpty()) {
                throw new InvalidFieldsException("Name", name);
            }

            return name;
        }
    }

    private static final class DateSearchPanel extends JPanel {

        private final DateEntryPanel dateEntryPanel = new DateEntryPanel();
        private final JButton searchByDateButton = new JButton("Search By Date");

        DateSearchPanel(ActionListener controller) {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            add(dateEntryPanel, c);

            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 3;
            add(searchByDateButton, c);
            searchByDateButton.addActionListener(controller);
        }
    }
}
