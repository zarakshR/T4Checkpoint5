package com.stir.cscu9t4practical1.gui;

import javax.swing.*;
import java.awt.*;

// TODO: Write tests for this
public class EntryDefinitionPanel extends JPanel {
    private final JList<String> list1 = new JList<String>(new String[]{"add", "entry", "panel"});

    public EntryDefinitionPanel() {
        setLayout(new BorderLayout());
        add(list1, BorderLayout.CENTER);
    }
}
