package com.ripple;

import javax.swing.*;
import java.awt.*;

public class menuButton extends JButton {
    Color unpressed   = new Color(143, 122, 102);
    Color pressed = new Color(187, 173, 160);

    public menuButton(String name, int y, Font ClearSans) {
        setText(name);
        setFont(ClearSans.deriveFont(32f));
        addActionListener(new MenuListener());
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);

        setSize(250, 50);
        setLocation(117, y);
        setForeground(Color.WHITE);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isArmed())
            g.setColor(pressed);
        else
            g.setColor(unpressed);
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);
        super.paintComponent(g);
    }
}
