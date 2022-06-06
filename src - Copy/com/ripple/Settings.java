package com.ripple;

import java.awt.*;

//SETTING SCREEN
public class Settings extends ScreenSetting {
    Settings() {
        add(new menuButton("Classic", 140, ClearSans));
        add(new menuButton("Pink", 200, ClearSans));
        add(new menuButton("Gray", 260, ClearSans));
        add(new menuButton("Dark Red", 320, ClearSans));
        add(new menuButton("Rainbow", 380, ClearSans));
        add(new menuButton("Back to menu", 520, ClearSans));

        setLayout(null);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(ClearSans.deriveFont(38f));
        g.setColor(GameTheme.font_color);
        g.drawString("Select theme", 135, 140);
    }
}
