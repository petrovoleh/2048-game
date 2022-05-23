package com.company;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {
    Settings() {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,600);
        setVisible(false);

        JLabel settings_label = new JLabel("Settings", SwingConstants.CENTER);
        settings_label.setFont(new Font("TimesRoman", Font.BOLD, 40));
        settings_label.setSize(250,70);
        settings_label.setLocation(120, 40);
        add(settings_label);
        
        add(new menuButton("Back to menu",500));

        setLayout(null);
        setResizable(false);
    }
}
