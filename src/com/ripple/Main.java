package com.ripple;

import javax.swing.*;

public class Main {
    public static JFrame game = new GameScreen();
    public static JFrame menu = new Menu();
    public static JFrame how_to_play = new HowToPlay();
    public static JFrame settings = new Settings();

    public static void main(String[] args) {

        GameField.create();

        menu.setVisible(true);
    }
}
