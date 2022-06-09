package com.ripple;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//commands when player want to exit
class ExitListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        GameField.save_field();
        GameField.save_score();
        System.exit(0);
    }
}
//MAIN SCREEN
public class Screen extends JFrame{
    //screens
    public static JPanel  menu = new Menu();
    public static HowToPlay how_to_play = new HowToPlay();
    public static JPanel settings = new Settings();
    public static JPanel game = new GameScreen();
    //create window
    Screen() {
        add(how_to_play);
        add(menu);
        add(settings);
        add(game);
        setTitle("2048");
        addWindowListener(new ExitListener());
        setSize(500, 630);
        setResizable(false);
        setVisible(true);
    }
    //main
    public static void main(String[] args) {
        new Screen();
        GameField.create();
        GameTheme.load_theme();
    }
    //update colors when theme changed
    public static void redraw(){
        settings.setBackground(GameTheme.background_color);
        settings.setForeground(GameTheme.font_color);
        menu.setBackground(GameTheme.background_color);
        menu.setForeground(GameTheme.font_color);
        game.setBackground(GameTheme.background_color);
        how_to_play.update();
    }
}
