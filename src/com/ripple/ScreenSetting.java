package com.ripple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

class ExitListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        GameField.save_field();
        GameField.save_score();
        System.exit(0);
    }
}

public class ScreenSetting extends JFrame {
    protected Color text_color = new Color(119,110,101);
    protected Color background_color = new Color(250,240,230);
    protected Font ClearSans;

    ScreenSetting() {
        download_font();
        setTitle("2048");
        addWindowListener(new ExitListener());
        getContentPane().setBackground(background_color);
        setSize(500,630);

        setVisible(false);
        setResizable(false);
    }

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
