package com.ripple;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//All game colours here
public class GameTheme {
    public static Color color0;
    public static Color color2;
    public static Color color4;
    public static Color color8;
    public static Color color16;
    public static Color color32;
    public static Color color64;
    public static Color color128;
    public static Color color256;
    public static Color color512;
    public static Color color1024;
    public static Color color2048;
    public static Color color4096;
    public static Color font_color;
    public static Color font_color2;
    public static Color background_color;
    public static Color field_color;
    public static Color button_color;
    public static Color button_pressed;

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
        Screen.redraw();
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
        Screen.redraw();
        save_theme("gray");
    }

    public static void pink(){
        color0   = new Color(250, 212, 212);
        color2   = new Color(255,175,185);
        color4   = new Color(245,165,175);
        color8   = new Color(235,145,155);
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
        font_color2 = new Color(250, 230, 230);
        background_color = new Color(250, 212, 212);
        field_color = new Color(239, 159, 159);
        button_color = new Color(239, 159, 159);
        button_pressed = Color.PINK;
        Screen.redraw();
        save_theme("pink");
    }

    public static void red() {
        color0 = new Color(93, 0, 9);
        color2 = new Color(238, 228, 218);
        color4 = new Color(244, 191, 191);
        color8 = new Color(239, 172, 172);
        color16 = new Color(251, 125, 125);
        color32 = new Color(212, 82, 82);
        color64 = new Color(245, 78, 78);
        color128 = new Color(199, 28, 28);
        color256 = new Color(165, 0, 0);
        color512 = new Color(132, 43, 43);
        color1024 = new Color(97, 2, 2);
        color2048 = new Color(61, 0, 0);
        color4096 = new Color(0, 0, 0);
        font_color = new Color(0, 0, 0);
        font_color2 = new Color(0, 0, 0);
        background_color = new Color(93, 0, 9);
        field_color = new Color(139, 63, 70);
        button_color = new Color(117, 0, 11);
        button_pressed = new Color(177, 70, 80);
        Screen.redraw();
        save_theme("red");
    }

    public static void rainbow(){
        color0   = new Color(111, 150, 100);
        color2   = new Color(236,186,207);
        color4   = new Color(210,138,179);
        color8   = new Color(180, 50, 124);
        color16  = new Color(255,0,0);
        color32  = new Color(255,116,0);
        color64  = new Color(255, 210, 0);
        color128 =  new Color(59, 218, 0);
        color256 = new Color(9, 91, 0);
        color512 = new Color(69,146,232);
        color1024 = new Color(10, 25, 210);
        color2048 = new Color(237, 208, 20);
        color4096 = new Color(106, 6, 208);
        font_color = new Color(12, 131, 131);
        font_color2 = new Color(12, 131, 131);
        background_color = new Color(128,218,159);
        field_color =new Color(149, 157, 208);
        button_color = new Color(147, 138, 214);
        button_pressed = new Color(237, 241, 132);
        Screen.redraw();
        save_theme("rainbow");
    }
    //load last theme
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
    //save what theme chosen now
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
