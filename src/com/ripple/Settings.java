package com.ripple;

import javax.swing.*;

public class Settings extends ScreenSetting {
    Settings() {

        JLabel settings_label = new JLabel("Settings", SwingConstants.CENTER);
        settings_label.setFont(TimesRoman);
        settings_label.setSize(250,70);
        settings_label.setLocation(120, 40);
        add(settings_label);
        
        add(new menuButton("Back to menu",500));

        setLayout(null);
    }
}
