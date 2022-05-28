package com.ripple;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

class ShowScore extends JPanel{
    Color color0   = new Color(187, 173, 160);
    Color color1   = new Color(238,228,218);
    Font ClearSans;
    GameField field;
    ShowScore(GameField f,Font font) {
        field = f;
        ClearSans = font;
        setLocation(100, 0);
        setSize(410, 100);
        setBackground(new Color(250,240,230));
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(color0);
        g.setFont(ClearSans.deriveFont(22f));
        FontMetrics fontMetrics = g.getFontMetrics();
        String score = String.valueOf(field.score);
        String best = String.valueOf(field.best);



        int score_width = 0;
        if (field.score < 10000)
            score_width = (fontMetrics.stringWidth(score)+1)/10*10/2;
        else
            score_width = (fontMetrics.stringWidth(score)-2)/10*10/2;

        int best_width = 0;
        if (field.score < 10000)
            best_width = (fontMetrics.stringWidth(best)+1)/10*10/2;
        else
            best_width = (fontMetrics.stringWidth(best)-2)/10*10/2;


        g.fillRoundRect(225-best_width-score_width, 20, 60+ best_width, 60, 10, 10);
        g.fillRoundRect(290-score_width, 20, 60+ score_width, 60, 10, 10);



        g.setColor(Color.WHITE);


        g.drawString(score, (255 - score_width- best_width/2) - fontMetrics.stringWidth(score) / 2, 70);

        g.drawString(best, (320 - score_width/2) - fontMetrics.stringWidth(best) / 2, 70);

        g.setColor(color1);
        g.setFont(ClearSans.deriveFont(16f));

        fontMetrics = g.getFontMetrics();
        score = "SCORE";
        best = "BEST";
        g.drawString(score, (255 - score_width- best_width/2) - fontMetrics.stringWidth(score) / 2, 45);

        g.drawString(best, (320 - score_width/2) - fontMetrics.stringWidth(best) / 2, 45);

    }
}

class GraphicField extends JPanel {
    Color color0   = new Color(205,193,180);
    Color color2   = new Color(238,228,218);
    Color color4   = new Color(230,210,190);
    Color color8   = new Color(240, 178, 124);
    Color color16  = new Color(246, 150, 100);
    Color color32  = new Color(247,124,95);
    Color color64  = new Color(247, 95, 59);
    Color color128 = new Color(237, 208, 115);
    Color color256 = new Color(237, 208, 98);
    Color color512 = new Color(237, 208, 80);
    Color color1024 = new Color(237, 208, 50);
    Color color2048 = new Color(237, 208, 20);
    Color color4096 = new Color(100, 100, 220);
    Font ClearSans;


    GameField field;
    GraphicField(GameField f, Font font) {
        ClearSans = font;
        field = f;
        setLocation(40, 100);
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
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(187, 173, 160));
        g.fillRoundRect(0, 0, 410, 410, 10, 10);


        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                g.setFont(ClearSans);
                g.setColor(set_color(field.game_field[i][j]));
                g2.fillRoundRect(10+i * 100, 10+j * 100, 90, 90, 10, 10);

                if (field.game_field[i][j] !=0) {
                    if(field.game_field[i][j] < 8)
                        g.setColor(new Color(120, 110, 100));
                    else
                        g.setColor(Color.WHITE);
                    if(field.game_field[i][j] < 16)
                        g.setFont(ClearSans.deriveFont(48f));
                    else if(field.game_field[i][j] < 128)
                        g.setFont(ClearSans.deriveFont(44f));
                    else if (field.game_field[i][j] < 1024)
                        g.setFont(ClearSans.deriveFont(38f));
                    else
                        g.setFont(ClearSans.deriveFont(32f));
                    FontMetrics fontMetrics = g.getFontMetrics();
                    String s = String.valueOf(field.game_field[i][j]);
                    g.drawString(s, 55 + i * 100 - fontMetrics.stringWidth(s) / 2, 75 + j * 100- fontMetrics.stringWidth(s) / 8);
                }

            }
        }

    }
}
public class GameScreen extends ScreenSetting implements KeyListener
{
    Font ClearSans;
    GameField field = new GameField();
    JPanel graphic;
    JPanel show_score;

    public GameScreen()
    {
        add(new menuButton("Back to menu",600));


        download_font();
        setLayout(null);

        graphic = new GraphicField(field, ClearSans);
        show_score = new ShowScore(field, ClearSans);
        add(graphic);
        add(show_score);
        addKeyListener(this);
        setFocusable(true);

    }
    private void download_font(){
        try {
            ClearSans = Font.createFont(Font.TRUETYPE_FONT, new File("src/com/ripple/game_files/ClearSans-Bold.ttf")).deriveFont(32f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(ClearSans);
        } catch (IOException |FontFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key>=37 && key <=40) {
            field.move_parts(key);
            graphic.repaint();
            show_score.repaint();
            field.save_best();
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