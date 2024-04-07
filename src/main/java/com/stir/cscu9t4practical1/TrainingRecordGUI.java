// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private final JTextField name = new JTextField(30);
    private final JTextField day = new JTextField(2);
    private final JTextField month = new JTextField(2);
    private final JTextField year = new JTextField(4);
    private final JTextField hours = new JTextField(2);
    private final JTextField mins = new JTextField(2);
    private final JTextField secs = new JTextField(2);
    private final JTextField dist = new JTextField(4);
    private final JLabel labn = new JLabel(" Name:");
    private final JLabel labd = new JLabel(" Day:");
    private final JLabel labm = new JLabel(" Month:");
    private final JLabel laby = new JLabel(" Year:");
    private final JLabel labh = new JLabel(" Hours:");
    private final JLabel labmm = new JLabel(" Mins:");
    private final JLabel labs = new JLabel(" Secs:");
    private final JLabel labdist = new JLabel(" Distance (km):");
    private final JButton addR = new JButton("Add");
    private final JButton lookUpByDate = new JButton("Look Up");

    private final TrainingRecord myAthletes = new TrainingRecord();

    private final JTextArea outputArea = new JTextArea(5, 50);

    // set up the GUI
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)

    } // constructor

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // listen for and respond to GUI events
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    }

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI
