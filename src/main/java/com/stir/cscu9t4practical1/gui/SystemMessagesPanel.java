package com.stir.cscu9t4practical1.gui;

import javax.swing.*;

// TODO: Write tests for this
public class SystemMessagesPanel extends JScrollPane {
    private static final JTextArea messageConsole = new JTextArea();

    public SystemMessagesPanel() {
        super(messageConsole);
        messageConsole.setEditable(false);
        messageConsole.setFocusable(false);
        messageConsole.setText("System Messages");
    }

    public void println(String s) {
        messageConsole.append("\n" + s);
    }
}
