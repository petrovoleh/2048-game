package com.company;

import javax.swing.*;
import java.awt.*;

public class HowToPlay extends JFrame {
    HowToPlay() {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,600);
        setVisible(false);

        JLabel how_to_label = new JLabel("How to play", SwingConstants.CENTER);
        how_to_label.setFont(new Font("TimesRoman", Font.BOLD, 40));
        how_to_label.setSize(250,70);
        how_to_label.setLocation(120, 40);
        add(how_to_label);


        JLabel info_label = new JLabel("Napishy tut text", SwingConstants.CENTER);
        info_label.setFont(new Font("TimesRoman", Font.BOLD, 20));
        info_label.setSize(400,300);
        info_label.setLocation(50, 100);
        add(info_label);

        add(new menuButton("Back to menu",500));

        setLayout(null);
        setResizable(false);
    }
}
