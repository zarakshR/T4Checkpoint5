package com.stir.cscu9t4practical1.gui;

import javax.swing.*;

/**
 A lightweight UI element that can allow other UI elements to log messages visible to the user to
 */
final class SystemMessagesPanel extends JScrollPane {

    private final JTextArea messageConsole = new JTextArea();

    /**
     Create a <code>SystemMessagesPanel</code>
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
     Write a message to the log. The message will be appended with a newline iff it does not already end in a newline

     @param s the string to log
     */
    public void println(final String s) {
        // appends a newline to the message if it doesn't already have one
        messageConsole.append(s.charAt(s.length() - 1) == '\n' ? s : s + '\n');
        // scroll to the bottom everytime we append a message
        JScrollBar scrollBar = getVerticalScrollBar();
        scrollBar.setValue(scrollBar.getMaximum());
    }
}
