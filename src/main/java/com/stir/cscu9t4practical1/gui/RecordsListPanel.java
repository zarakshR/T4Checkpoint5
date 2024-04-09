package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 The type Records list panel.
 */
final class RecordsListPanel extends JList<Entry> {

    private final JPopupMenu menu = new JPopupMenu();
    private final JMenuItem deleteButton = new JMenuItem("Delete");

    /**
     Instantiates a new Records list panel.

     @param controller the controller
     @param listModel  the list model
     */
// We need to use atleast a ComboBoxModel because it must support selecting elements (for remove/weekly distance operation)
    RecordsListPanel(final TrainingRecordAppController controller, final ComboBoxModel<Entry> listModel) {
        super(listModel);

        menu.add(deleteButton);
        add(menu);

        deleteButton.addActionListener(e -> {
            if (e.getSource() == deleteButton) {
                controller.removeEntryAtIndex(getSelectedIndex());
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
