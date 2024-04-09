package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Write tests for this
final class SearchPanel extends JPanel implements ActionListener {

    private final NameSearchPanel nameSearchPanel = new NameSearchPanel(this);
    private final DateSearchPanel dateSearchPanel = new DateSearchPanel(this);

    SearchPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(nameSearchPanel);
        add(dateSearchPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameSearchPanel.searchByNameButton) {
            System.out.println("name search = " + nameSearchPanel.nameField.getText());
        }
        if (e.getSource() == nameSearchPanel.weeklyDistanceButton) {
            System.out.println("weekly distance = " + nameSearchPanel.nameField.getText());
        }
        if (e.getSource() == dateSearchPanel.searchByDateButton) {
            System.out.println("date search = " + dateSearchPanel.dateField.getText());
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
    }

    private static final class DateSearchPanel extends JPanel {

        private final LabelledTextPanel yearField = new LabelledTextPanel("Year", 4);
        private final LabelledTextPanel monthField = new LabelledTextPanel("Month", 2);
        private final LabelledTextPanel dayField = new LabelledTextPanel("Day", 2);
        private final JButton searchByDateButton = new JButton("Search By Date");

        DateSearchPanel(ActionListener controller) {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            add(yearField, c);

            c.gridx = 1;
            c.gridy = 0;
            add(monthField, c);

            c.gridx = 2;
            c.gridy = 0;
            add(dayField, c);

            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 3;
            add(searchByDateButton, c);
            searchByDateButton.addActionListener(controller);
        }
    }
}
