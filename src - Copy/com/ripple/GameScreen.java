package com.ripple;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class gameButton extends JButton {
    Font ClearSans;
    public gameButton(String name, int x, int y, Font f, JPanel game_over) {
        super(name);
        ClearSans = f;
        addActionListener(new GameListener(game_over));

        setFocusPainted(false);
        setBorderPainted(false);

        setForeground(Color.WHITE);

        setContentAreaFilled(false);
        setSize(130, 40);
        setLocation(x, y);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(ClearSans.deriveFont(20f));

        if (getModel().isArmed())
            g.setColor(GameTheme.button_pressed);
        else
            g.setColor(GameTheme.button_color);
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);
        super.paintComponent(g);
    }
    
}

class ShowScore extends JPanel{
    Font ClearSans;
    
    ShowScore(Font font){
        ClearSans = font;
        setLocation(40, 0);
        setSize(410, 100);
        setBackground(new Color(0,0,0,0));
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setFont(ClearSans.deriveFont(86f));
        g.setColor(GameTheme.font_color);
        g.drawString("2048", 0, 75);

        g.setColor(GameTheme.field_color);
        g.setFont(ClearSans.deriveFont(22f));
        FontMetrics fontMetrics = g.getFontMetrics();
        String score = String.valueOf(GameField.score);
        String best = String.valueOf(GameField.best);



        int score_width;
        if (GameField.score < 10000)
            score_width = (fontMetrics.stringWidth(score)+1)/10*10/2;
        else
            score_width = (fontMetrics.stringWidth(score)-2)/10*10/2;

        int best_width;
        if (GameField.best < 10000)
            best_width = (fontMetrics.stringWidth(best)+1)/10*10/2;
        else
            best_width = (fontMetrics.stringWidth(best)-2)/10*10/2;


        g.fillRoundRect(285-best_width-score_width, 20, 60+ score_width, 60, 10, 10);
        g.fillRoundRect(350-best_width, 20, 60+ best_width, 60, 10, 10);



        g.setColor(Color.WHITE);


        g.drawString(score, 315 - best_width - score_width/2 - fontMetrics.stringWidth(score) / 2, 70);

        g.drawString(best, 380 - best_width/2 - fontMetrics.stringWidth(best) / 2, 70);

        g.setColor(GameTheme.font_color2);
        g.setFont(ClearSans.deriveFont(16f));

        fontMetrics = g.getFontMetrics();
        score = "SCORE";
        best = "BEST";
        g.drawString(score, (315 - best_width- score_width/2) - fontMetrics.stringWidth(score) / 2, 45);

        g.drawString(best, 380 - best_width/2 - fontMetrics.stringWidth(best) / 2, 45);

    }
}

class GraphicField extends JPanel {
    Font ClearSans;

    GraphicField(Font font) {
        ClearSans = font;
        setLocation(40, 100);
        setSize(410, 410);
        setBackground(new Color(0,0,0,0));
    }

    private Color set_color(int value){
        Color returned_color;
        switch (value){
            case 0 -> returned_color=GameTheme.color0;
            case 2 -> returned_color=GameTheme.color2;
            case 4 -> returned_color=GameTheme.color4;
            case 8 -> returned_color=GameTheme.color8;
            case 16 -> returned_color=GameTheme.color16;
            case 32 -> returned_color=GameTheme.color32;
            case 64 -> returned_color=GameTheme.color64;
            case 128 -> returned_color=GameTheme.color128;
            case 256 -> returned_color=GameTheme.color256;
            case 512 -> returned_color=GameTheme.color512;
            case 1024 -> returned_color=GameTheme.color1024;
            case 2048 -> returned_color=GameTheme.color2048;
            default -> returned_color=GameTheme.color4096;
        }
        return returned_color;
    }
    private float select_font_size(int i, int j){
        if(GameField.game_field[i][j] < 16)
            return 48f;
        else if(GameField.game_field[i][j] < 128)
            return 44f;
        else if (GameField.game_field[i][j] < 1024)
            return 38f;
        return 32f;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(GameTheme.field_color);
        g.fillRoundRect(0, 0, 410, 410, 10, 10);


        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                g.setFont(ClearSans);
                g.setColor(set_color(GameField.game_field[i][j]));
                g2.fillRoundRect(10+i * 100, 10+j * 100, 90, 90, 10, 10);

                if (GameField.game_field[i][j] !=0) {
                    if(GameField.game_field[i][j] < 8)
                        g.setColor(GameTheme.font_color);
                    else
                        g.setColor(Color.WHITE);
                    g.setFont(ClearSans.deriveFont(select_font_size(i,j)));

                    FontMetrics fontMetrics = g.getFontMetrics();
                    String s = String.valueOf(GameField.game_field[i][j]);
                    g.drawString(s, 55 + i * 100 - fontMetrics.stringWidth(s) / 2, 75 + j * 100- fontMetrics.stringWidth(s) / 8);
                }
            }
        }

    }
}

class GameOver extends JPanel{
    Font ClearSans;

    GameOver(Font font) {
        setVisible(false);
        ClearSans = font;
        setLocation(40, 100);
        setSize(410, 410);
        setBackground(GameTheme.game_over_color);
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setFont(ClearSans.deriveFont(60f));
        g.setColor(GameTheme.font_color);
        g.drawString("Game over!", 50, 220);

    }
}

public class GameScreen extends ScreenSetting implements KeyListener
{
    JPanel graphic;
    JPanel show_score;
    JPanel game_over;

    public GameScreen()
    {
        setLayout(null);

        graphic = new GraphicField(ClearSans);
        show_score = new ShowScore(ClearSans);
        game_over = new GameOver(ClearSans);
        add(game_over);
        add(graphic);
        add(show_score);
        add(new gameButton("Menu",40, 530, ClearSans,game_over));
        add(new gameButton("Undo",180, 530, ClearSans,game_over));
        add(new gameButton("New game",320, 530,ClearSans,game_over));

        addKeyListener(this);
        setFocusable(true);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key>=37 && key <=40 ||(key == 65 || key == 87 || key==68 || key==83)) {
            if(GameField.move_parts(key))
                game_over.setVisible(true);
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
}