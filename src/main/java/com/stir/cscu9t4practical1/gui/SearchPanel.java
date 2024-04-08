package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class SearchPanel extends JPanel {

    private final NameSearchPanel nameSearchPanel = new NameSearchPanel();
    private final DateSearchPanel dateSearchPanel = new DateSearchPanel();

    public SearchPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(nameSearchPanel);
        add(dateSearchPanel);
    }

    // We need these two to be separate panels, otherwise the layout looks horrible
    private static final class NameSearchPanel extends JPanel {
        private final LabelledTextPanel nameField = new LabelledTextPanel("Name");
        private final JButton searchByNameButton = new JButton("Search By Name");
        private final JButton weeklyDistanceButton = new JButton("Calculate Weekly Distance");

        public NameSearchPanel() {
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

            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth = 1;
            add(weeklyDistanceButton, c);
        }
    }

    private static final class DateSearchPanel extends JPanel {
        private final LabelledTextPanel dateField = new LabelledTextPanel("Date");
        private final JButton searchByDateButton = new JButton("Search By Date");

        private DateSearchPanel() {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            add(dateField, c);

            c.gridx = 0;
            c.gridy = 1;
            add(searchByDateButton, c);
        }
    }
}
