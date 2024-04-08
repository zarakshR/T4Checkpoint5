package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.event.*;

// TODO: Write tests for this
public class RecordsListPanel extends JList<String> {

    private final JPopupMenu menu = new JPopupMenu();
    private final JMenuItem deleteButton = new JMenuItem("Delete");

    public RecordsListPanel(DefaultComboBoxModel<String> listModel) {
        super(listModel);

        menu.add(deleteButton);
        add(menu);

        deleteButton.addActionListener(e -> {
            if (e.getSource() == deleteButton) {
                DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) getModel();
                model.removeElement(model.getSelectedItem());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    setSelectedIndex(locationToIndex(e.getPoint()));
                    menu.show(RecordsListPanel.this, 0,0 );
                }
            }
        });
    }
}
