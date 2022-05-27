package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GraphicField extends JPanel {
    Color color0   = new Color(190,175,160);
    Color color2   = new Color(238,228,218);
    Color color4   = new Color(230,210,190);
    Color color8   = new Color(240, 178, 124);
    Color color16  = new Color(240, 151, 107);
    Color color32  = new Color(240,126,104);
    Color color64  = new Color(240, 96, 58);
    Color color128 = new Color(240, 240, 180);
    Color color256 = new Color(240, 225, 150);
    Color color512 = new Color(240, 205, 120);
    Color color1024 = new Color(240, 205, 80);
    Color color2048 = new Color(240, 205, 50);
    Color color4096 = new Color(100, 100, 220);
    Font PartsFont = new Font("Bahnschrift", Font.BOLD, 35);

    GameField field;
    GraphicField(GameField f) {
        field = f;
        setLocation(50, 70);
        setSize(410, 410);
        setBackground(new Color(0, 0, 0, 0));
    }

    private Color set_color(int value){
        Color returned_color;
        switch (value){
            case 0 -> returned_color=color0;
            case 2 -> returned_color=color2;
            case 4 -> returned_color=color4;
            case 8 -> returned_color=color8;
            case 16 -> returned_color=color16;
            case 32 -> returned_color=color32;
            case 64 -> returned_color=color64;
            case 128 -> returned_color=color128;
            case 256 -> returned_color=color256;
            case 512 -> returned_color=color512;
            case 1024 -> returned_color=color1024;
            case 2048 -> returned_color=color2048;
            case 4096 -> returned_color=color4096;
            default -> returned_color=color2048;
        }
        return returned_color;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(PartsFont);
        FontMetrics fontMetrics = g.getFontMetrics();
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        g.setColor(new Color(163, 146, 128));
        g.fillRect(0, 0, 410, 410);


        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
 
                String s = String.valueOf(field.game_field[i][j]);
                g.setColor(set_color(field.game_field[i][j]));
                g.fillRoundRect(10+i * 100, 10+j * 100, 90, 90, 5, 5);

                if (field.game_field[i][j] !=0) {
                    g.setColor(Color.BLACK);
                    g.drawString(s, 55 + i * 100 - fontMetrics.stringWidth(s) / 2, 68 + j * 100);
                }

            }
        }

    }
}
public class GameScreen extends ScreenSetting implements KeyListener
{

    GameField field = new GameField();
    GraphicField graphic = new GraphicField(field);

    public GameScreen()
    {
        add(new menuButton("Back to menu",500));

        setLayout(null);
        add(graphic);
        addKeyListener(this);
        setFocusable(true);
        graphic.repaint();
        repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key>=37 && key <=40) {
            field.move_parts(key);
            graphic.repaint();
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