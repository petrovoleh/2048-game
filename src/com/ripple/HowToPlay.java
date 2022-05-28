package com.ripple;

import javax.swing.*;

public class HowToPlay extends ScreenSetting {
    HowToPlay() {

        JLabel how_to_label = new JLabel("How to play", SwingConstants.CENTER);
        how_to_label.setFont(TimesRoman);
        how_to_label.setSize(250,70);
        how_to_label.setLocation(120, 40);
        add(how_to_label);

        JLabel info_label = new JLabel("Napishy tut text", SwingConstants.CENTER);
        info_label.setFont(TimesRoman);
        info_label.setSize(400,300);
        info_label.setLocation(50, 100);
        add(info_label);

        add(new menuButton("Back to menu",500));

        setLayout(null);
    }
}
