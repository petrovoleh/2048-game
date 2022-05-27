package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScreenSetting extends JFrame {
    Font TimesRoman = new Font("TimesRoman", Font.BOLD, 40);
    private void catch_font(){
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("A.ttf")));
        } catch (IOException |FontFormatException e) {
            //Handle exception
        }
    }
    ScreenSetting() {
        catch_font();
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,600);
        setVisible(false);
        setResizable(false);
    }
}
