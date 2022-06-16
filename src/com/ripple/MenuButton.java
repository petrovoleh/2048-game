package com.ripple;

import javax.swing.*;
import java.awt.*;

//BUTTONS IN MENU CLASS
public class MenuButton extends JButton {
    public MenuButton(String name, int y) {
        setText(name);
        setFont(FrameSettings.ClearSans.deriveFont(32f));
        addActionListener(new MenuListener());
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setSize(250, 50);
        setLocation(117, y);
        setForeground(Color.WHITE);
    }
    //Draw button
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        //enable antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //chose button color and paint it
        if (getModel().isArmed())
            g.setColor(GameTheme.button_pressed);
        else
            g.setColor(GameTheme.button_color);
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 13, 13);
        super.paintComponent(g);
    }
}
