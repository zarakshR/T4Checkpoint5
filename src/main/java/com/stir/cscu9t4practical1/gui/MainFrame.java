package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.entries.TrainingRecord;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

// TODO: Write tests for this
public final class MainFrame extends JFrame implements ActionListener {

    private final TrainingRecord trainingRecord;
    private final DefaultComboBoxModel<Entry> recordsModel;
    private final SystemMessagesPanel systemMessagesPanel;

    // MainFrame acts as the controller + model combined. It is passed to the child panels so they don't have to concern
    //  themselves with the data representation
    // This has the drawback that the child panels now depend on MainFrame, ideally this would be fixed by defining an
    //  controller interface that MainFrame implements and which the subpanels depend on, but this project is already overkill
    //  for a checkpoint
    public MainFrame(final TrainingRecord initialTrainingRecord) {
        trainingRecord = initialTrainingRecord;

        recordsModel = new DefaultComboBoxModel<Entry>(trainingRecord.getEntries());

        RecordsListPanel recordsListPanel = new RecordsListPanel(this, recordsModel);
        AddEntryPanel addEntryPanel = new AddEntryPanel(this);
        SearchPanel searchPanel = new SearchPanel(this);
        systemMessagesPanel = new SystemMessagesPanel();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(searchPanel, c);

        // the records panel cannot be extended vertically or it can misinterpret click events. if it is extended vertically
        //  and the user clicks somewhere in the blank space below the last list entry, it registers as a click on the last list
        //  entry. TODO: find a fix?
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(recordsListPanel, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(addEntryPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0.1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(systemMessagesPanel, c);

        pack();
    }

    void addEntry(final Entry e) {
        recordsModel.addElement(e);
    }

    void log(final String s) {
        systemMessagesPanel.println(s);
    }

    void updateWithSearchByName(String name) {
        recordsModel.removeAllElements();
        recordsModel.addAll(trainingRecord.lookupEntriesByName(name));
    }

    void updateWithSearchByDate(LocalDate date) {
        recordsModel.removeAllElements();
        recordsModel.addAll(trainingRecord.lookupEntriesByDay(date));
    }

    void handleInvalidInput(InvalidFieldsException ex) {
        // we do all the janky error handling code in EntryPanel / SearchPanel so we can get neat error messages here and so that
        //  MainFrame does not have to concern itself with the internal representation of Entry objects
        JOptionPane.showMessageDialog(this,
                "Invalid value: \"" + ex.getBadValue() + "\" in field " + ex.getFieldName());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
