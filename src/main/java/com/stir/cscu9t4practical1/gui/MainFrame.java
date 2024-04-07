package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.TrainingRecord;
import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.entries.RunEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class MainFrame extends JFrame implements ActionListener {

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
    private final JButton lookUpAllOnDate = new JButton("Find All By Date");

    private final TrainingRecord myAthletes = new TrainingRecord();

    private final JTextArea outputArea = new JTextArea(5, 50);

    public MainFrame() {
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
        add(lookUpAllOnDate);
        lookUpAllOnDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

    }

    public static void main(String[] args) {
        MainFrame applic = new MainFrame();
    }

    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == lookUpAllOnDate) {
            message = lookupEntries();
        }
        outputArea.setText(message);
        blankDisplay();
    }

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");
        String n = name.getText();
        float km = java.lang.Float.parseFloat(dist.getText());
        int yearN = Integer.parseInt(year.getText());
        int monthN = Integer.parseInt(month.getText());
        int dayN = Integer.parseInt(day.getText());
        int hourN = Integer.parseInt(hours.getText());
        int minuteN = Integer.parseInt(mins.getText());
        int secondN = Integer.parseInt(secs.getText());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(yearN, monthN, dayN, hourN, minuteN, secondN, 0,
                TimeZone.getDefault().toZoneId());
        RunEntry e = new RunEntry(n, zonedDateTime, km);
        System.out.println("e.formattedEntry() = " + e.formattedEntry());
        myAthletes.addEntry(e);
        return message;
    }

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        return myAthletes.lookupEntry(d, m, y);
    }

    public String lookupEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        return myAthletes.lookupEntries(d, m, y);
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
    }

    // fills the input fields on the display for testing purposes only
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

}
