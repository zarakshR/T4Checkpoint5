package com.stir.cscu9t4practical1.gui;

import javax.swing.*;

/**
 The type System messages panel.
 */
final class SystemMessagesPanel extends JScrollPane {

    private final JTextArea messageConsole = new JTextArea();

    /**
     Instantiates a new System messages panel.
     */
    public SystemMessagesPanel() {
        super();
        getViewport().setView(messageConsole);
        messageConsole.setRows(3); // we don't want more than 3 lines in the system console at a time
        messageConsole.setEditable(false);
        messageConsole.setFocusable(false);
        println("System Messages");
    }

    /**
     Println.

     @param s the s
     */
    public void println(final String s) {
        // appends a newline to the message if it doesn't already have one
        messageConsole.append(s.charAt(s.length() - 1) == '\n' ? s : s + '\n');
        // scroll to the bottom everytime we append a message
        JScrollBar scrollBar = getVerticalScrollBar();
        scrollBar.setValue(scrollBar.getMaximum());
    }
}
