package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.entries.TrainingRecordAppModel;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Vector;

public final class MainFrame extends JFrame implements TrainingRecordAppController {

    private final TrainingRecordAppModel model;
    private final DefaultComboBoxModel<Entry> recordsModel;
    private final SystemMessagesPanel systemMessagesPanel;

    // MainFrame acts as the controller + model combined. It is passed to the child panels so they don't have to concern
    //  themselves with the data representation
    public MainFrame(final TrainingRecordAppModel initialModel) {
        model = initialModel;

        // DefaultComboBoxModel only accepts Vectors
        recordsModel = new DefaultComboBoxModel<Entry>(new Vector<Entry>(model.getEntries()));

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

    @Override
    public void requestCreationOfEntry(final Entry e) {
        model.addEntry(e);
        recordsModel.addElement(e);
        requestLog("added entry: " + e);
    }

    @Override
    public void requestLog(final String message) {
        systemMessagesPanel.println(message);
    }

    @Override
    public void requestRemovalOfEntryAtIndex(final int index) {
        Entry toRemove = recordsModel.getElementAt(index);
        model.removeEntry(toRemove);
        recordsModel.removeElementAt(index);
        requestLog("removed entry: " + toRemove);
    }

    @Override
    public void requestSearchByName(final String name) {
        Collection<Entry> entries = model.lookupEntriesByName(name);

        // don't replace the records with an empty list in case we find no search matches, that is probably not what the user
        //  expects
        if (entries.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No search results for query: " + name);
        } else {
            recordsModel.removeAllElements();
            recordsModel.addAll(entries);
        }
    }

    @Override
    public void requestSearchByDate(final LocalDate date) {
        Collection<Entry> entries = model.lookupEntriesByDay(date);

        if (entries.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No search results for query: " + date);
        }

        // don't replace the records with an empty list in case we find no search matches, that is probably not what the user
        //  expects
        if (entries.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No search results for query: " + date);
        } else {
            recordsModel.removeAllElements();
            recordsModel.addAll(entries);
        }
    }

    @Override
    public void requestShowWeeklyDistance(final String name) {
        JOptionPane.showMessageDialog(this,
                name + " achieved total distance " + model.lookupWeeklyDistance(name, LocalDate.now())
                        + " in the last week");
    }

    @Override
    public void requestReinitializeRecords() {
        recordsModel.removeAllElements();
        recordsModel.addAll(model.getEntries());
        requestLog("refreshed all records");
    }

    @Override
    public void handleInvalidInput(final InvalidFieldsException ex) {
        JOptionPane.showMessageDialog(this,
                "Invalid value: \"" + ex.getBadValue() + "\" in field " + ex.getFieldName());
    }
}
