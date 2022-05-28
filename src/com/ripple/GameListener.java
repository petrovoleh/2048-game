package com.ripple;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Menu" -> {
                Main.menu.setVisible(true);
                Main.game.setVisible(false);
            }
            case "New game" -> {
                Main.game.field.sdf;
                Main.game.requestFocusInWindow();
            }

        }
    }
}
