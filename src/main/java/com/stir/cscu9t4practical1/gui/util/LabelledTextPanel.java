package com.stir.cscu9t4practical1.gui.util;

import javax.swing.*;

/**
 A lightweight panel that displays text with a label
 */
public final class LabelledTextPanel extends JPanel {

    private final JTextField textField;

    /**
     Create a <code>LabelledTextPanel</code> with the given label and number of columns. Both the label and number of columns
     is fixed

     @param labelText the label text
     @param columns   the number of columns
     */
    public LabelledTextPanel(final String labelText, final int columns) {
        textField = new JTextField(columns);
        add(new JLabel(labelText));
        add(textField);
    }

    /**
     @return the text entered in the text field
     */
    public String getText() {return textField.getText();}

    /**
     Clears all text in the text area
     */
    public void clearText() {textField.setText(null);}
}
