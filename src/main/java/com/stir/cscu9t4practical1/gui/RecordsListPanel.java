package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 Manages a list of <code>Entry</code>s. Provides the ability for the user to right click and delete an entry
 */
final class RecordsListPanel extends JList<Entry> {

    private final JPopupMenu menu = new JPopupMenu();
    private final JMenuItem deleteButton = new JMenuItem("Delete");

    /**
     Create a <code>RecordsListPanel</code> with the given controller implementation and backed by the given list model
     @param controller the {@link TrainingRecordAppController} of the running app
     @param listModel the {@link ComboBoxModel} that backs up this list
     */
    // We need to use at least a ComboBoxModel because it must support selecting elements (for remove/weekly distance operation)
    RecordsListPanel(final TrainingRecordAppController controller, final ComboBoxModel<Entry> listModel) {
        super(listModel);

        menu.add(deleteButton);
        add(menu);

        deleteButton.addActionListener(e -> {
            if (e.getSource() == deleteButton) {
                controller.requestRemovalOfEntryAtIndex(getSelectedIndex());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    // the selection needs to be set to the entry that the users cursor is at for two reasons:
                    //  the deleteButton action listeners asks the controller to delete the *currently selected* entry
                    //  selecting the entry highlights it, giving the user visual indication about what they've selected
                    setSelectedIndex(locationToIndex(e.getPoint()));
                    menu.show(RecordsListPanel.this, e.getX(), e.getY());
                }
            }
        });
    }
}
