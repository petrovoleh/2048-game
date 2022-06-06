package com.ripple;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.menu.setVisible(false);
        switch (e.getActionCommand()) {
            case "How to play" -> Main.how_to_play.setVisible(true);
            case "Settings" -> Main.settings.setVisible(true);
            case "Exit" -> {
                GameField.save_field();
                GameField.save_score();
                System.exit(0);
            }
            case "Play" -> {
                Main.game.setVisible(true);
                Main.game.requestFocusInWindow();
            }
            case "Back to menu" -> {
                Main.settings.setVisible(false);
                Main.how_to_play.setVisible(false);
                Main.menu.setVisible(true);
            }
            case "Classic" -> GameTheme.classic();
            case "Pink" ->GameTheme.pink();
            case "Gray" ->GameTheme.gray();
            case "Dark Red" -> GameTheme.red();
            case "Rainbow" -> GameTheme.rainbow();
        }
    }
}
