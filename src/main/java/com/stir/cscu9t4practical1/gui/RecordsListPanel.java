package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO: Write tests for this
final class RecordsListPanel extends JList<Entry> {

    private final JPopupMenu menu = new JPopupMenu();
    private final JMenuItem deleteButton = new JMenuItem("Delete");

    public RecordsListPanel(final DefaultComboBoxModel<Entry> listModel) {
        super(listModel);

        menu.add(deleteButton);
        add(menu);

        deleteButton.addActionListener(e -> {
            if (e.getSource() == deleteButton) {
                DefaultComboBoxModel<Entry> model = (DefaultComboBoxModel<Entry>) getModel();
                model.removeElement(model.getSelectedItem());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    setSelectedIndex(locationToIndex(e.getPoint()));
                    menu.show(RecordsListPanel.this, e.getX(), e.getY());
                }
            }
        });
    }
}
