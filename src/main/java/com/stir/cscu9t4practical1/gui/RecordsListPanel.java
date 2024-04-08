package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class RecordsListPanel extends JPanel {

    private final JList<String> list1 = new JList<String>(new String[]{"record", "list", "panel"});

    public RecordsListPanel() {
        setLayout(new BorderLayout());
        add(list1, BorderLayout.CENTER);
    }
}
