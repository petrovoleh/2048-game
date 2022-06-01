package com.ripple;

import javax.swing.*;

public class Settings extends ScreenSetting {
    Settings() {
        JLabel settings_label = new JLabel("Settings", SwingConstants.CENTER);
        settings_label.setFont(ClearSans.deriveFont(38f));
        settings_label.setForeground(GameTheme.font_color);
        settings_label.setSize(250,70);
        settings_label.setLocation(115, 40);
        add(settings_label);

        add(new menuButton("Classic",260,ClearSans));
        add(new menuButton("Pink",340,ClearSans));
        add(new menuButton("Dark",420,ClearSans));
        add(new menuButton("Back to menu",520,ClearSans));

        setLayout(null);
    }
}
