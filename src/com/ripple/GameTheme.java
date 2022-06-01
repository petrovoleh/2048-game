package com.ripple;

import java.awt.*;

public class GameTheme {
    static Color color0   = new Color(205,193,180);
    static Color color2   = new Color(238,228,218);
    static Color color4   = new Color(230,210,190);
    static Color color8   = new Color(240, 178, 124);
    static Color color16  = new Color(246, 150, 100);
    static Color color32  = new Color(247,124,95);
    static Color color64  = new Color(247, 95, 59);
    static Color color128 = new Color(237, 208, 115);
    static Color color256 = new Color(237, 208, 98);
    static Color color512 = new Color(237, 208, 80);
    static Color color1024 = new Color(237, 208, 50);
    static Color color2048 = new Color(237, 208, 20);
    static Color color4096 = new Color(100, 100, 220);
    static Color font_color = new Color(120, 110, 100);
    static Color background_color = new Color(250,240,230);
    static Color field_color =new Color(187, 173, 160);
    static Color button_color = new Color(143, 122, 102);
    static Color button_pressed = new Color(183, 162, 142);

    public static void classic(){
        color0   = new Color(205,193,180);
        color2   = new Color(238,228,218);
        color4   = new Color(230,210,190);
        color8   = new Color(240, 178, 124);
        color16  = new Color(246, 150, 100);
        color32  = new Color(247,124,95);
        color64  = new Color(247, 95, 59);
        color128 = new Color(237, 208, 115);
        color256 = new Color(237, 208, 98);
        color512 = new Color(237, 208, 80);
        color1024 = new Color(237, 208, 50);
        color2048 = new Color(237, 208, 20);
        color4096 = new Color(100, 100, 220);
        font_color = new Color(120, 110, 100);
        background_color = new Color(250,240,230);
        field_color =new Color(187, 173, 160);
        button_color = new Color(143, 122, 102);
        button_pressed = new Color(183, 162, 142);
        Main.recreate();
    }
    public static void dark(){
        color0   = Color.GRAY;
        color2   = Color.BLACK;
        color4   = Color.BLACK;
        color8   = Color.BLACK;
        color16  = Color.BLACK;
        color32  = Color.BLACK;
        color64  = Color.BLACK;
        color128 = Color.BLACK;
        color256 = Color.BLACK;
        color512 = Color.BLACK;
        color1024 = Color.BLACK;
        color2048 = Color.BLACK;
        color4096 = Color.BLACK;
        font_color = Color.WHITE;
        background_color = Color.GRAY;
        field_color = Color.DARK_GRAY;
        button_color = Color.DARK_GRAY;
        button_pressed = Color.BLACK;
        Main.recreate();
    }
    public static void pink(){
        color0   = Color.PINK;
        color2   = Color.MAGENTA;
        color4   = Color.MAGENTA;
        color8   = Color.MAGENTA;
        color16  = Color.MAGENTA;
        color32  = Color.MAGENTA;
        color64  = Color.MAGENTA;
        color128 = Color.MAGENTA;
        color256 = Color.MAGENTA;
        color512 = Color.MAGENTA;
        color1024 = Color.MAGENTA;
        color2048 = Color.MAGENTA;
        color4096 = Color.MAGENTA;
        font_color = Color.BLACK;
        background_color = Color.WHITE;
        field_color = Color.RED;
        button_color = Color.PINK;
        button_pressed = Color.MAGENTA;
        Main.recreate();
    }
}
