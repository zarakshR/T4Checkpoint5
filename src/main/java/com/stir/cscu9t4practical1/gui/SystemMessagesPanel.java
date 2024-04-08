package com.stir.cscu9t4practical1.gui;

import javax.swing.*;

// TODO: Write tests for this
final class SystemMessagesPanel extends JScrollPane {

    private static final JTextArea messageConsole = new JTextArea();

    public SystemMessagesPanel() {
        super(messageConsole);
        messageConsole.setRows(3); // we don't want more than 3 lines in the system console at a time
        messageConsole.setEditable(false);
        messageConsole.setFocusable(false);
        println("System Messages");
    }

    public void println(String s) {
        messageConsole.append("\n" + s);
        // scroll to the bottom everytime we append a message
        JScrollBar scrollBar = getVerticalScrollBar();
        scrollBar.setValue(scrollBar.getMaximum());
    }
}
