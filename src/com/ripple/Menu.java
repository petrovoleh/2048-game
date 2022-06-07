package com.ripple;

import javax.swing.*;
import java.awt.*;

//GUI (ALL BUTTONS WRITTEN HERE)
public class Menu extends FrameSettings {
    public Menu() {
        JLabel l2048 = new JLabel("2048", SwingConstants.CENTER);
        l2048.setSize(250,180);
        l2048.setLocation(120, 40);
        l2048.setForeground(GameTheme.font_color);
        l2048.setFont(GameTheme.ClearSans.deriveFont(100f));
        add(l2048);

        add(new menuButton("Play",200,GameTheme.ClearSans));
        add(new menuButton("How to play", 260,GameTheme.ClearSans));
        add(new menuButton("Settings", 320,GameTheme.ClearSans));
        add(new menuButton("Exit", 380,GameTheme.ClearSans));

    }
}