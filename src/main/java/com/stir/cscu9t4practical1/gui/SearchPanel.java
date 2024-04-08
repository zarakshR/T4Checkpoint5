package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
final class SearchPanel extends JPanel {

    public SearchPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        NameSearchPanel nameSearchPanel = new NameSearchPanel();
        DateSearchPanel dateSearchPanel = new DateSearchPanel();

        add(nameSearchPanel);
        add(dateSearchPanel);
    }

    // We need these two to be separate panels, otherwise the layout looks horrible
    private static final class NameSearchPanel extends JPanel {

        NameSearchPanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            LabelledTextPanel nameField = new LabelledTextPanel("Name");
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            add(nameField, c);

            JButton searchByNameButton = new JButton("Search By Name");
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 1;
            add(searchByNameButton, c);

            JButton weeklyDistanceButton = new JButton("Calculate Weekly Distance");
            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth = 1;
            add(weeklyDistanceButton, c);
        }
    }

    private static final class DateSearchPanel extends JPanel {

        DateSearchPanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            LabelledTextPanel dateField = new LabelledTextPanel("Date");
            c.gridx = 0;
            c.gridy = 0;
            add(dateField, c);

            JButton searchByDateButton = new JButton("Search By Date");
            c.gridx = 0;
            c.gridy = 1;
            add(searchByDateButton, c);
        }
    }
}
