package com.ripple;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameListener implements ActionListener {
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
                Main.game.repaint();
                Main.game.requestFocusInWindow();
            }
            case "Undo" -> {
                System.out.println();
                GameField.game_field=GameField.last_move;
                GameField.score=GameField.last_score;
                Main.game.repaint();
                Main.game.requestFocusInWindow();
            }
        }

    }
}

