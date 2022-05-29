package com.ripple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameListener implements ActionListener {
    JPanel game_over;
    GameListener(JPanel game_o){
        game_over=game_o;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Menu" -> {
                Main.menu.setVisible(true);
                Main.game.setVisible(false);
                GameField.save_field();
            }
            case "New game" -> {
                GameField.create();
                game_over.setVisible(false);
                Main.game.repaint();
                Main.game.requestFocusInWindow();
            }
            case "Undo" -> {
                System.out.println();
                GameField.game_field=GameField.last_move;
                GameField.score=GameField.last_score;
                game_over.setVisible(false);
                Main.game.repaint();
                Main.game.requestFocusInWindow();
            }
        }

    }
}

