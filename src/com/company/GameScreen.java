package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class FieldBackground extends JPanel {
    FieldBackground() {
        setLocation(0, 0);
        setSize(500, 600);
        setBackground(new Color(250, 240, 230));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(163, 146, 128));
        g.fillRect(37, 69, 410, 410);

        g.setColor(new Color(190, 175, 160));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.fillRoundRect(47 + i * 100, 79 + j * 100, 90, 90, 5, 5);

            }
        }
    }
}

class FieldForeground extends JPanel {
    FieldForeground() {
        setLocation(0, 0);
        setSize(500, 600);
        setBackground(new Color(250, 240, 230));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(163, 146, 128));
        g.fillRect(37, 69, 410, 410);

        g.setColor(new Color(190, 175, 160));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.fillRoundRect(47 + i * 100, 79 + j * 100, 90, 90, 5, 5);

            }
        }
    }
}
public class GameScreen extends ScreenSetting implements KeyListener
{
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

    GameField field = new GameField();

    public GameScreen()
    {
        add(new menuButton("Back to menu",500));

        setLayout(null);
        add(new FieldBackground());

        addKeyListener(this);
        setFocusable(true);
        repaint();
    }

    private Color set_color(int value){
        switch (value){
            case 2 -> {
                return color2;
            }
            case 4 -> {
                return color4;
            }
            case 8 -> {
                return color8;
            }
            case 16 -> {
                return color16;
            }
            case 32 -> {
                return color32;
            }
            case 64 -> {
                return color64;
            }
            case 128 -> {
                return color128;
            }
            case 256 -> {
                return color256;
            }
            case 512 -> {
                return color512;
            }
            case 1024 -> {
                return color1024;
            }
            case 2048 -> {
                return color2048;
            }
            case 4096 -> {
                return color4096;
            }
            default -> {
                return color0;
            }
        }
    }
    public void refresh_screen(Graphics g){
        g.setFont(PartsFont);
        FontMetrics fontMetrics = g.getFontMetrics();
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if (field.game_field[i][j] !=0) {
                    String s = String.valueOf(field.game_field[i][j]);
                    g.setColor(set_color(field.game_field[i][j]));
                    g.fillRoundRect(55 + i * 100, 110 + j * 100, 90, 90, 5, 5);
                    g.setColor(Color.BLACK);
                    g.drawString(s, 100 + i * 100 - fontMetrics.stringWidth(s) / 2, 168 + j * 100);

                }
            }
        }
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
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