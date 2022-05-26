package com.company;

import javax.swing.*;
import java.awt.*;

public class ScreenSetting extends JFrame {
    Font TimesRoman = new Font("TimesRoman", Font.BOLD, 40);
    Font PartsFont = new Font("Bahnschrift", Font.BOLD, 35);
    ScreenSetting() {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,600);
        setVisible(false);
        setResizable(false);
    }
}
