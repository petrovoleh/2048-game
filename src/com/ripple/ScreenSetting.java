package com.ripple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;



public class ScreenSetting extends JFrame {
    Font TimesRoman = new Font("TimesRoman", Font.BOLD, 40);
    Font ClearSans;
    ScreenSetting() {
        download_font();
        setTitle("2048");
        addWindowListener(exitListener);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,630);

        setVisible(false);
        setResizable(false);
    }

    WindowListener exitListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            GameField.save_field();

            GameField.save_score();
            System.exit(0);
        }
    };

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
