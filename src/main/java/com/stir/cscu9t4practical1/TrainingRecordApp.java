package com.stir.cscu9t4practical1;

import com.stir.cscu9t4practical1.gui.MainFrame;

import java.awt.*;

public class TrainingRecordApp {

    private static final MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        mainFrame.setMinimumSize(new Dimension(720, 200));
        mainFrame.setVisible(true);
    }
}
