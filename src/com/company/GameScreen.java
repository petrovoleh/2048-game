package com.company;


import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;

public class GameScreen extends JFrame
{
    public GameScreen()
    {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250,240,230));
        setSize(500,600);
        setVisible(false);


        add(new menuButton("Back to menu",500));

        setLayout(null);
        setResizable(false);

        GameLogic.game_loop();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(new Color(187,173,160));

        g.fillRect(45,100,410,410);
        g.setColor(new Color(205,193,180));

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                g.fillRect(55+i*100,110+j*100,90,90);
            }
        }
    }

}