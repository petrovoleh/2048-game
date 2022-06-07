package com.ripple;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExitListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        GameField.save_field();
        GameField.save_score();
        System.exit(0);
    }
}
public class Screen extends JFrame {
    Screen() {
        add(Main.how_to_play);
        add(Main.menu);
        add(Main.settings);
        add(Main.game);
        setTitle("2048");
        addWindowListener(new ExitListener());
        setSize(500, 630);
        setResizable(false);
        setVisible(true);
    }
}
