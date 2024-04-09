package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.gui.util.DateEntryPanel;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;
import com.stir.cscu9t4practical1.gui.util.LabelledTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Allows the user to search by name or date
 */
final class SearchPanel extends JPanel implements ActionListener {

    private final TrainingRecordAppController controller;

    private final NameSearchPanel nameSearchPanel = new NameSearchPanel(this);
    private final DateSearchPanel dateSearchPanel = new DateSearchPanel(this);

    private final JButton clearSearchButton = new JButton("Clear Search");

    /**
     Create an <code>AddEntryPanel</code> with the given controller implementation
     @param parentFrame the {@link TrainingRecordAppController} of the running app
     */
    SearchPanel(final TrainingRecordAppController parentFrame) {
        controller = parentFrame;

        clearSearchButton.addActionListener(this);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(nameSearchPanel);
        add(dateSearchPanel);
        add(clearSearchButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameSearchPanel.searchByNameButton) {
            try {
                controller.requestSearchByName(nameSearchPanel.getValidatedName());
            } catch (InvalidFieldsException ex) {
                controller.handleInvalidInput(ex);
            }
        }
        if (e.getSource() == nameSearchPanel.weeklyDistanceButton) {
            try {
                controller.requestShowWeeklyDistance(nameSearchPanel.getValidatedName());
            } catch (InvalidFieldsException ex) {
                controller.handleInvalidInput(ex);
            }
        }
        if (e.getSource() == dateSearchPanel.searchByDateButton) {
            try {
                controller.requestSearchByDate(dateSearchPanel.dateEntryPanel.getDate());
            } catch (InvalidFieldsException ex) {
                controller.handleInvalidInput(ex);
            }
        }
        if (e.getSource() == clearSearchButton) {
            controller.requestReinitializeRecords();
        }
    }

    // We need these two to be separate panels, otherwise the layout looks horrible
    private static final class NameSearchPanel extends JPanel {

        private final LabelledTextPanel nameField = new LabelledTextPanel("Name", 30);
        private final JButton searchByNameButton = new JButton("Search By Name");
        private final JButton weeklyDistanceButton = new JButton("Calculate Weekly Distance");

        NameSearchPanel(final ActionListener controller) {
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

        DateSearchPanel(final ActionListener controller) {
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
