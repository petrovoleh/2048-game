package com.ripple;

import javax.swing.*;

//GUI (ALL BUTTONS WRITTEN HERE)
public class Menu extends ScreenSetting {
    public Menu() {

        JLabel l2048 = new JLabel("2048", SwingConstants.CENTER);
        l2048.setSize(250,70);
        l2048.setLocation(120, 40);

        l2048.setFont(TimesRoman);
        add(l2048);


        add(new menuButton("Play",150));
        add(new menuButton("How to play", 220));
        add(new menuButton("Settings", 290));
        add(new menuButton("Exit", 360));


        setLayout(null);
    }
}