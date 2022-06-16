package com.ripple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//buttons class in screen game
class gameButton extends JButton {
    public gameButton(String name, int x, int y, JPanel game_over) {
        setText(name);
        addActionListener(new GameListener(game_over));
        setFont(FrameSettings.ClearSans.deriveFont(20f));
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setSize(130, 40);
        setLocation(x, y);
        setForeground(Color.WHITE);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        //enable antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //chose button color and paint it
        if (getModel().isArmed())
            g.setColor(GameTheme.button_pressed);
        else
            g.setColor(GameTheme.button_color);
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);
        super.paintComponent(g);
    }
}
//class that draw players score
class ShowScore extends JPanel{
    Font ClearSans = FrameSettings.ClearSans;
    ShowScore(){
        setLocation(40, 0);
        setSize(410, 100);
        setBackground(new Color(0,0,0,0));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //enable antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //draw 2048 label
        g.setFont(ClearSans.deriveFont(86f));
        g.setColor(GameTheme.font_color);
        g.drawString("2048", 0, 75);

        //write the score to a variable and calculate the width
        g.setFont(ClearSans.deriveFont(22f));
        FontMetrics fontMetrics = g.getFontMetrics();
        String score = String.valueOf(GameField.score);
        String best = String.valueOf(GameField.best);
        int score_width = (fontMetrics.stringWidth(score)+1)/10*10/2;
        int best_width = (fontMetrics.stringWidth(best)+1)/10*10/2;;
        if (GameField.score > 10000)
            score_width = (fontMetrics.stringWidth(score)-2)/10*10/2;
        if (GameField.best > 10000)
            best_width = (fontMetrics.stringWidth(best)-2)/10*10/2;

        //draw rects
        g.setColor(GameTheme.field_color);
        g.fillRoundRect(285-best_width-score_width, 20, 60+ score_width, 60, 10, 10);
        g.fillRoundRect(350-best_width, 20, 60+ best_width, 60, 10, 10);

        //draw score and best score
        g.setColor(Color.WHITE);
        g.drawString(score, 315 - best_width - score_width/2 - fontMetrics.stringWidth(score) / 2, 70);
        g.drawString(best, 380 - best_width/2 - fontMetrics.stringWidth(best) / 2, 70);

        //draw labels "best" and "score"
        g.setColor(GameTheme.font_color2);
        g.setFont(ClearSans.deriveFont(16f));
        fontMetrics = g.getFontMetrics();
        score = "SCORE";
        best = "BEST";
        g.drawString(score, (315 - best_width- score_width/2) - fontMetrics.stringWidth(score) / 2, 45);
        g.drawString(best, 380 - best_width/2 - fontMetrics.stringWidth(best) / 2, 45);
    }
}
//draw game field
class GraphicField extends JPanel {
    GraphicField() {
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
        if(GameField.game_field[i][j] < 128)
            return 44f;
        if (GameField.game_field[i][j] < 1024)
            return 38f;
        return 32f;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //draw rect behind parts
        g.setColor(GameTheme.field_color);
        g.fillRoundRect(0, 0, 410, 410, 10, 10);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                g.setFont(FrameSettings.ClearSans);
                g.setColor(set_color(GameField.game_field[i][j]));
                g2.fillRoundRect(10+i * 100, 10+j * 100, 90, 90, 10, 10);

                if (GameField.game_field[i][j] !=0) {
                    if(GameField.game_field[i][j] < 8)
                        g.setColor(GameTheme.font_color);
                    else
                        g.setColor(Color.WHITE);
                    g.setFont(FrameSettings.ClearSans.deriveFont(select_font_size(i,j)));

                    FontMetrics fontMetrics = g.getFontMetrics();
                    String s = String.valueOf(GameField.game_field[i][j]);
                    g.drawString(s, 55 + i * 100 - fontMetrics.stringWidth(s) / 2, 75 + j * 100- fontMetrics.stringWidth(s) / 8);
                }
            }
        }

    }
}

//game over screen
class GameOver extends JPanel{
    GameOver() {
        setVisible(false);
        setLocation(40, 100);
        setSize(410, 410);
        setFont(FrameSettings.ClearSans.deriveFont(60f));
        setOpaque(false);
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(GameTheme.font_color);
        g.drawString("Game over!", 50, 220);
    }
}
//player win screen
class PlayerWin extends JPanel{
    PlayerWin() {
        setVisible(false);
        setLocation(40, 100);
        setSize(410, 410);
        setFont(FrameSettings.ClearSans.deriveFont(60f));
        setOpaque(false);
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(GameTheme.font_color);
        g.drawString("You win!", 90, 220);
    }
}
public class GameScreen extends FrameSettings implements KeyListener
{
    JPanel game_over = new GameOver();
    JPanel player_win = new PlayerWin();
    public GameScreen()
    {
        //add game field, score and game over screen
        add(game_over);
        add(player_win);
        add(new GraphicField());
        add(new ShowScore());
        //add buttons
        add(new gameButton("Menu",40, 530,game_over));
        add(new gameButton("Undo",180, 530,game_over));
        add(new gameButton("New game",320, 530,game_over));

        addKeyListener(this);
    }

    //player press keys
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key>=37 && key <=40 ||(key == 65 || key == 87 || key==68 || key==83)) {
            if(GameField.move_parts(key))
                game_over.setVisible(true);
            if(GameField.is_player_win())
                player_win.setVisible(true);
            repaint();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
}