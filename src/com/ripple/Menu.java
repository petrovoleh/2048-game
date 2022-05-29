package com.ripple;

import javax.swing.*;
import java.awt.*;

//GUI (ALL BUTTONS WRITTEN HERE)
public class Menu extends ScreenSetting {

    Color color1   = new Color(119,110,101);
    public Menu() {

        JLabel l2048 = new JLabel("2048", SwingConstants.CENTER);
        l2048.setSize(250,80);
        l2048.setLocation(120, 40);
        l2048.setForeground(color1);
        l2048.setFont(ClearSans.deriveFont(86f));
        add(l2048);


        add(new menuButton("Play",150,ClearSans));
        add(new menuButton("How to play", 220,ClearSans));
        add(new menuButton("Settings", 290,ClearSans));
        add(new menuButton("Exit", 360,ClearSans));


        setLayout(null);
    }
}