package com.ripple;

import javax.swing.*;

//SETTING SCREEN
public class Settings extends FrameSettings {
    Settings() {
        //add label "select theme"
        JLabel select_label = new JLabel("Select theme");
        select_label.setFont(ClearSans.deriveFont(38f));
        select_label.setForeground(GameTheme.font_color);
        select_label.setSize(300,70);
        select_label.setLocation(128, 70);
        add(select_label);
        //add buttons
        add(new menuButton("Classic", 140));
        add(new menuButton("Pink", 200));
        add(new menuButton("Gray", 260));
        add(new menuButton("Dark Red", 320));
        add(new menuButton("Rainbow", 380));
        add(new menuButton("Back to menu", 520));
    }
}
