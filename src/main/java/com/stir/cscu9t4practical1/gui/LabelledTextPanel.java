package com.stir.cscu9t4practical1.gui;

import javax.swing.*;

final class LabelledTextPanel extends JPanel {

    private final JTextField textField = new JTextField(30);

    LabelledTextPanel(final String labelText) {
        add(new JLabel(labelText));
        add(textField);
    }

    public String getText() { return textField.getText(); }

    public void setText(String s) { textField.setText(s); }
}
