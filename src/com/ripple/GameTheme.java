package com.ripple;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameTheme {
    static Color color0;
    static Color color2;
    static Color color4;
    static Color color8;
    static Color color16;
    static Color color32;
    static Color color64;
    static Color color128;
    static Color color256;
    static Color color512;
    static Color color1024;
    static Color color2048;
    static Color color4096;
    static Color font_color ;
    static Color font_color2;
    static Color background_color;
    static Color field_color;
    static Color button_color;
    static Color button_pressed;
    static Color game_over_color;

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
        font_color2 = new Color(238,228,218);
        background_color = new Color(250,240,230);
        field_color =new Color(187, 173, 160);
        button_color = new Color(143, 122, 102);
        button_pressed = new Color(183, 162, 142);
        game_over_color   = new Color(187, 173, 160,140);

        Main.recreate();
        save_theme("classic");
    }
    public static void gray(){
        color0   = Color.GRAY;
        color2   = new Color(100,100,100);
        color4   = new Color(90,90,90);
        color8   = new Color(80,80,80);
        color16  = new Color(50,50,50);
        color32  = new Color(40,40,40);
        color64  = new Color(30,30,30);
        color128 = new Color(20,20,20);
        color256 = new Color(15,15,15);
        color512 = new Color(10,10,10);
        color1024 = new Color(5,5,5);
        color2048 = Color.BLACK;
        color4096 = Color.BLACK;
        font_color = Color.WHITE;
        background_color = Color.GRAY;
        field_color = Color.DARK_GRAY;
        font_color2 = Color.GRAY;
        button_color = Color.DARK_GRAY;
        button_pressed = Color.BLACK;
        game_over_color   = new Color(180, 180, 180,140);
        Main.recreate();
        save_theme("gray");
    }
    public static void pink(){
        color0   = new Color(250, 212, 212);
        color2   = Color.PINK;
        color4   = Color.PINK;
        color8   = Color.PINK;
        color16  = Color.PINK;
        color32  = Color.PINK;
        color64  = Color.PINK;
        color128 = Color.PINK;
        color256 = Color.PINK;
        color512 = Color.PINK;
        color1024 = Color.PINK;
        color2048 = Color.PINK;
        color4096 = Color.PINK;
        font_color = new Color(255, 242, 242);
        font_color2 = new Color(250, 230, 230);;
        background_color = new Color(250, 212, 212);
        field_color = new Color(239, 159, 159);
        button_color = new Color(239, 159, 159);
        button_pressed = Color.PINK;
        game_over_color   = new Color(160, 110, 110,140);
        Main.recreate();
        save_theme("pink");
    }

    public static void red(){
        color0   = new Color(93,0,9);
        color2   = new Color(238,228,218);
        color4   = new Color(244,191,191);
        color8   = new Color(239,172,172);
        color16  = new Color(251,125,125);
        color32  = new Color(212,82,82);
        color64  = new Color(245, 78, 78);
        color128 = new Color(199, 28, 28);
        color256 = new Color(165, 0, 0);
        color512 = new Color(132, 43, 43);
        color1024 = new Color(97, 2, 2);
        color2048 = new Color(61, 0, 0);
        color4096 = new Color(0, 0, 0);
        font_color = new Color(0, 0, 0);
        font_color2 = new Color(0,0,0);
        background_color = new Color(93,0,9);
        field_color =new Color(139, 63, 70);
        button_color = new Color(117, 0, 11);
        button_pressed = new Color(177, 70, 80);
        game_over_color   = new Color(132, 43, 43,140);
        Main.recreate();
        save_theme("red");
    }
    public static void rainbow(){
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
        font_color2 = new Color(238,228,218);
        background_color = new Color(250,240,230);
        field_color =new Color(187, 173, 160);
        button_color = new Color(143, 122, 102);
        button_pressed = new Color(183, 162, 142);
        game_over_color   = new Color(187, 173, 160,140);
        Main.recreate();
        save_theme("rainbow");
    }
    public static void load_theme(){
        String theme = "";
        try {
            Scanner scanner = new Scanner(new File("src/com/ripple/game_files/selected_theme.txt"));
            theme=scanner.next();
        } catch (FileNotFoundException e) {
            System.out.println("missing theme file");
        }
        switch (theme){
            case "pink" -> pink();
            case "gray" -> gray();
            case "red" -> red();
            case "rainbow" -> rainbow();
            default -> classic();
        }
    }
    private static void save_theme(String name){
        try {
            FileWriter writer = new FileWriter("src/com/ripple/game_files/selected_theme.txt", false);
            writer.write(String.valueOf(name));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
