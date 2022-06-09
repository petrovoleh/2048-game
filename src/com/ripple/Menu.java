package com.ripple;

import javax.swing.*;

//Main menu screen
public class Menu extends FrameSettings {
    public Menu() {
        setVisible(true);
        //add logo
        JLabel l2048 = new JLabel("2048", SwingConstants.CENTER);
        l2048.setSize(250,180);
        l2048.setLocation(120, 40);
        l2048.setForeground(GameTheme.font_color);
        l2048.setFont(ClearSans.deriveFont(100f));
        add(l2048);
        //add buttons
        add(new menuButton("Play",200));
        add(new menuButton("How to play", 260));
        add(new menuButton("Settings", 320));
        add(new menuButton("Exit", 380));
    }
}