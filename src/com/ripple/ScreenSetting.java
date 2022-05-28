package com.ripple;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScreenSetting extends JFrame {
    Font TimesRoman = new Font("TimesRoman", Font.BOLD, 40);
    Font ClearSans;
    ScreenSetting() {
        download_font();
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,630);

        setVisible(false);
        setResizable(false);
    }
    private void download_font(){
        try {
            ClearSans = Font.createFont(Font.TRUETYPE_FONT, new File("src/com/ripple/game_files/ClearSans-Bold.ttf")).deriveFont(32f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(ClearSans);
        } catch (IOException |FontFormatException e) {
            e.printStackTrace();
        }
    }

}
