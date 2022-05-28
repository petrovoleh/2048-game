package com.ripple;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScreenSetting extends JFrame {
    Font TimesRoman = new Font("TimesRoman", Font.BOLD, 40);

    ScreenSetting() {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,700);
        setVisible(false);
        setResizable(false);
    }
}
