package com.stir.cscu9t4practical1.gui;

import javax.swing.*;

final class LabelledTextPanel extends JPanel {

    private final JTextField textField = new JTextField(30);

    public LabelledTextPanel(String labelText) {
        add(new JLabel(labelText));
        add(textField);
    }

    public JTextField getTextField() {
        return textField;
    }
}
