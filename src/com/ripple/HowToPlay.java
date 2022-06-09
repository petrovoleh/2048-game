package com.ripple;

import javax.swing.*;

//HOW TO PLAY SCREEN
public class HowToPlay extends FrameSettings {
    private final JLabel info_label;
    HowToPlay() {
        //label at the top of the screen
        JLabel how_to_label = new JLabel("How to play:", SwingConstants.CENTER);
        how_to_label.setFont(ClearSans.deriveFont(38f));
        how_to_label.setForeground(GameTheme.font_color);
        how_to_label.setSize(300,70);
        how_to_label.setLocation(100, 80);
        add(how_to_label);
        //how to play text(wrote on html)
        info_label = new JLabel(
                "<html><p align=\"justify\">Use your arrow keys to move the tiles. " +
                        "Tiles with the same number merge into one when they touch. Add them " +
                        "up to reach 2048!<br/>You can also cancel one move if you made it by " +
                        "accident.</p></html>");
        info_label.setFont(ClearSans.deriveFont(28f));
        info_label.setSize(400,300);
        info_label.setLocation(45, 140);
        add(info_label);
        //button back
        add(new menuButton("Back to menu",520));
    }
    //update colors when theme changed
    public void update(){
        setBackground(GameTheme.background_color);
        setForeground(GameTheme.font_color);
        info_label.setForeground(GameTheme.font_color);
    }
}

