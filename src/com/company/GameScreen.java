package com.company;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends ScreenSetting implements KeyListener
{
    GameField field = new GameField();

    public GameScreen()
    {
        add(new menuButton("Back to menu",500));

        setLayout(null);
        setResizable(false);

        addKeyListener(this);
        setFocusable(true);
        repaint();
    }

    public void refresh_screen(Graphics g){
        g.setFont(TimesRoman);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(field.game_field[i][j]== 0){
                    g.setColor(new Color(205,193,180));
                }
                else{
                    g.setColor(new Color(238,228,218));
                }
                g.fillRect(55+i*100,110+j*100,90,90);
                g.setColor(Color.BLACK);
                if (field.game_field[i][j] !=0)
                    g.drawString(String.valueOf(field.game_field[i][j]), 85+i*100,150+j*100);
            }
        }
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(new Color(187,173,160));
        g.fillRect(45,100,410,410);

        refresh_screen(g);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        field.move_parts(e.getKeyCode());
        repaint();
        setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
}