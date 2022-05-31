package com.ripple;

import javax.swing.*;

//GUI (ALL BUTTONS WRITTEN HERE)
public class Menu extends ScreenSetting {
    public Menu() {

        JLabel l2048 = new JLabel("2048", SwingConstants.CENTER);
        l2048.setSize(250,180);
        l2048.setLocation(120, 40);
        l2048.setForeground(text_color);
        l2048.setFont(ClearSans.deriveFont(100f));
        add(l2048);

        add(new menuButton("Play",200,ClearSans));
        add(new menuButton("How to play", 260,ClearSans));
        add(new menuButton("Settings", 320,ClearSans));
        add(new menuButton("Exit", 380,ClearSans));

        setLayout(null);
    }
}