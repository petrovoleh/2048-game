package com.ripple;

import javax.swing.*;


public class Main extends JFrame{
    public static JPanel menu;
    public static JPanel how_to_play;
    public static JPanel settings;
    public static JPanel game;
    public static JFrame screen;

    public static void main(String[] args) {
        GameField.create();
        GameTheme.download_font();

        menu = new Menu();
        how_to_play = new HowToPlay();
        settings = new Settings();
        game = new GameScreen();
        screen = new Screen();
        GameTheme.load_theme();

        menu.setVisible(true);
    }

    public static void redraw(){
        settings.setBackground(GameTheme.background_color);
        menu.setBackground(GameTheme.background_color);
        game.setBackground(GameTheme.background_color);
        how_to_play.setBackground(GameTheme.background_color);
        menu.setForeground(GameTheme.font_color);
        settings.setForeground(GameTheme.font_color);
        how_to_play.setForeground(GameTheme.font_color);
        screen.repaint();
    }
}
