package com.ripple;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FrameSettings extends JPanel {
    //font of the game
    public static Font ClearSans;
    FrameSettings() {
        setSize(500, 650);
        setLocation(0, 0);
        setLayout(null);
        setVisible(false);
        setBackground(GameTheme.background_color);
        download_font();
    }
    //downloading game font
    private void download_font(){
        try {
            String path= "src/com/ripple/game_files/ClearSans-Bold.ttf";
            ClearSans = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(ClearSans);
        } catch (IOException |FontFormatException e) {
            e.printStackTrace();
        }
    }
}
