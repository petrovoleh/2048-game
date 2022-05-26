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
        g.setFont(PartsFont);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

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
                FontMetrics fontMetrics = g.getFontMetrics();
                String s = String.valueOf(field.game_field[i][j]);

                if (field.game_field[i][j] !=0)
                    g.drawString(s, 100+i*100- fontMetrics.stringWidth(s)/2,168+j*100);
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
        int key = e.getKeyCode();
        if (key>=37 && key <=40) {
            field.move_parts(key);
            repaint();
            setFocusable(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
}