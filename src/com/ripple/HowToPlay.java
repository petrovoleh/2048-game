package com.ripple;

import javax.swing.*;

public class HowToPlay extends ScreenSetting {
    HowToPlay() {
        JLabel how_to_label = new JLabel("How to play:", SwingConstants.CENTER);
        how_to_label.setFont(ClearSans.deriveFont(38f));
        how_to_label.setForeground(GameTheme.font_color);
        how_to_label.setSize(300,70);
        how_to_label.setLocation(100, 80);


        JLabel info_label = new JLabel(
                "<html><p align=\"justify\">Use your arrow keys to move the tiles. " +
                        "Tiles with the same number merge into one when they touch. Add them " +
                        "up to reach 2048!<br/>You can also cancel one move if you made it by " +
                        "accident.</p></html>", SwingConstants.CENTER);
        info_label.setForeground(GameTheme.font_color);
        info_label.setFont(ClearSans.deriveFont(28f));
        info_label.setSize(400,300);
        info_label.setLocation(45, 140);

        add(info_label);
        add(how_to_label);
        add(new menuButton("Back to menu",520,ClearSans));
        setLayout(null);
    }
}
