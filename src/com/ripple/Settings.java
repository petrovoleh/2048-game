package com.ripple;

import javax.swing.*;
import java.awt.*;

//SETTING SCREEN
public class Settings extends FrameSettings {
    Settings() {
        JLabel select_label = new JLabel("Select theme", SwingConstants.CENTER);
        select_label.setFont(GameTheme.ClearSans.deriveFont(38f));
        select_label.setForeground(GameTheme.font_color);
        select_label.setSize(300,70);
        select_label.setLocation(93, 70);
        add(select_label);

        add(new menuButton("Classic", 140, GameTheme.ClearSans));
        add(new menuButton("Pink", 200, GameTheme.ClearSans));
        add(new menuButton("Gray", 260, GameTheme.ClearSans));
        add(new menuButton("Dark Red", 320, GameTheme.ClearSans));
        add(new menuButton("Rainbow", 380, GameTheme.ClearSans));
        add(new menuButton("Back to menu", 520, GameTheme.ClearSans));

    }

}
