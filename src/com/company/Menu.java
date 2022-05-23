package com.company;

import javax.swing.*;
import java.awt.*;

//GUI (ALL BUTTONS WRITTEN HERE)
public class Menu extends JFrame {
    public Menu() {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JLabel l2048 = new JLabel("2048", SwingConstants.CENTER);
        l2048.setSize(250,70);
        l2048.setLocation(120, 40);

        l2048.setFont(new Font("TimesRoman", Font.BOLD, 70));
        add(l2048);


        add(new menuButton("Play",150));
        add(new menuButton("How to play", 220));
        add(new menuButton("Settings", 290));
        add(new menuButton("Exit", 360));


        setLayout(null);
        setVisible(true);
        setResizable(false);
        setFocusable(true);
    }
}