package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.menu.setVisible(false);
        switch (e.getActionCommand()) {

            case "Play" -> Main.game.setVisible(true);
            case "How to play" -> Main.howtoplay.setVisible(true);
            case "Settings" -> Main.settings.setVisible(true);
            case "Exit" -> System.exit(0);
            case "Back to menu" -> {
                Main.game.setVisible(false);
                Main.settings.setVisible(false);
                Main.howtoplay.setVisible(false);
                Main.menu.setVisible(true);
            }
        }
    }
}
