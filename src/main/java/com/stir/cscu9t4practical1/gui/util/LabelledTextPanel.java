package com.stir.cscu9t4practical1.gui.util;

import javax.swing.*;

public final class LabelledTextPanel extends JPanel {

    private final JTextField textField;

    public LabelledTextPanel(final String labelText, final int columns) {
        textField =  new JTextField(columns);
        add(new JLabel(labelText));
        add(textField);
    }

    public String getText() { return textField.getText(); }

    public void setText(String s) { textField.setText(s); }
}
