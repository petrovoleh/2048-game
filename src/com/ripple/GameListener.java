package com.ripple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameListener implements ActionListener {
    JPanel game_over;
    GameListener(JPanel game_ov){
        game_over=game_ov;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Main.game.requestFocusInWindow();
        Main.game.repaint();
        switch (e.getActionCommand()) {
            case "Menu" -> {
                Main.menu.setVisible(true);
                Main.game.setVisible(false);
                GameField.save_field();
            }
            case "New game" -> {
                GameField.generate_new();
                game_over.setVisible(false);
            }
            case "Undo" -> {
                GameField.game_field=GameField.last_move;
                GameField.score=GameField.last_score;
                game_over.setVisible(false);
            }
        }

    }
}

