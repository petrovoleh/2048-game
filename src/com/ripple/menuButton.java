package com.ripple;

import javax.swing.*;
import java.awt.*;

public class menuButton extends JButton {
    Font Times = new Font("TimesRoman", Font.BOLD, 30);

    public menuButton(String name, int y) {
        setText(name);
        setFont(Times);
        addActionListener(new MenuListener());

        setSize(250, 50);
        setLocation(120, y);
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
    }
}
