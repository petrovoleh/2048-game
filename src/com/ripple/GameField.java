package com.ripple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameField{

    public static int[][] game_field = new int[4][4];
    public static int[][] last_move = new int[4][4];
    private static int[][] merge_field = new int[4][4];
    public static int score = 0;
    public static int last_score = 0;
    public static int best = 0;

    public static void create() {
        game_field = new int[4][4];
        score = 0;
        generate_parts();
        generate_parts();
        last_move = game_field;
    }

    public static void download_score(){
        try {
            Scanner scanner = new Scanner(new File("src/com/ripple/game_files/score.txt"));
            if(scanner.hasNextInt())
                best=scanner.nextInt();
            if(scanner.hasNextInt())
                score=scanner.nextInt();
            last_score=score;
        } catch (FileNotFoundException e) {
            try {
                if(new File("src/com/ripple/game_files/score.txt").createNewFile())
                    System.out.println("created new best_score file");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void save_best(){
        try {
            FileWriter writer = new FileWriter("src/com/ripple/game_files/score.txt", false);
            writer.write(String.valueOf(best));
            writer.write(" ");
            writer.write(String.valueOf(score));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void merge_parts(int[][] temp_field){
        for (int y = 0; y<4; y++) {
            for (int first = 0; first < 3; first++) {
                int second = first+1;
                while (temp_field[second][y] ==0 && second < 3)
                    second++;
                if (temp_field[first][y] == temp_field[second][y]){
                    temp_field[first][y]*=2;
                    temp_field[second][y]=0;
                    score+=temp_field[first][y];
                    if (best<score)
                        best=score;
                }
            }
        }
    }

    private static void change_direction(int key_code){
        switch (key_code) {
            case 37, 65 -> merge_field = game_field;
            case 38, 87 -> merge_field = rotate_field(game_field);
            case 39, 68 -> merge_field = flip(game_field);
            case 40, 83 -> merge_field = flip(rotate_field(game_field));
        }
    }

    private static boolean is_player_lost(){
        for (int x = 0; x < 4; x++)
            for (int y = 1; y < 3; y++)
                if(game_field[x][y] == game_field[x][y+1] ||game_field[x][y] == game_field[x][y-1])
                    return false;

        for (int x = 1; x < 3; x++)
            for (int y = 0; y < 4; y++)
                if(game_field[x][y] == game_field[x+1][y] ||game_field[x][y] == game_field[x-1][y])
                    return false;

        return true;
    }

    private static void normalize_direction(int key_code){
        switch (key_code) {
            case 37, 65 -> game_field = merge_field;
            case 38, 87 -> game_field = rotate_field(merge_field);
            case 39, 68 -> game_field = flip(merge_field);
            case 40, 83 -> game_field = rotate_field(flip(merge_field));
        }
    }

    private static int[][] flip(int[][] array) {
        int[][] temp_field= new int [4][4];
        for (int i = 0; i < 4; i++)
            System.arraycopy(array[3 - i], 0, temp_field[i], 0, 4);
        return temp_field;
    }

    private static int[][] rotate_field(int[][] array) {
        int[][] temp_field= new int [4][4];
        for (int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                temp_field[i][j]=array[j][i];
        return temp_field;
    }

    private static void remove_empty(){
        for(int y =0; y<4; y++){
            for(int first_x =0; first_x<3; first_x++){
                if(merge_field[first_x][y]==0){
                    int second_x =first_x+1;
                    while (merge_field[second_x][y] ==0 && second_x < 3)
                        second_x++;
                    merge_field[first_x][y]=merge_field[second_x][y];
                    merge_field[second_x][y]=0;
                }
            }
        }
    }
    
    private static boolean there_are_empty(){
        for (int x = 0; x < 4; x++)
            for (int y = 0; y < 4; y++)
                if(game_field[x][y] == 0)
                    return true;
        return false;
    }

    public static void save_field(){
        try {
            FileWriter writer = new FileWriter("src/com/ripple/game_files/field.txt", false);
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    writer.write(String.valueOf(game_field[y][x]));
                    writer.write(" ");
                }
                writer.write("\n");
            }
            writer.close();

        } catch (IOException e) {
            try {
                if(new File("src/com/ripple/game_files/field.txt").createNewFile())
                    System.out.println("created new field file");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            save_field();
        }
    }

    public static boolean download_field(){
        try {
            Scanner scanner = new Scanner(new File("src/com/ripple/game_files/field.txt"));
            for (int x = 0; x < 4; x++)
                for (int y = 0; y < 4; y++)
                    if(scanner.hasNextInt())
                        game_field[x][y]=scanner.nextInt();
                    else
                        return false;
            last_move = game_field;
        } catch (FileNotFoundException e) {
            try {
                if(new File("src/com/ripple/game_files/field.txt").createNewFile())
                    System.out.println("created new field file");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static void move_parts(int key_code){
        last_move=game_field;
        last_score=score;
        for(int i = 0; i < 4; i++)
            System.out.println(Arrays.toString(last_move[i]));
        System.out.println();



        change_direction(key_code);
        for(int i = 0; i < 4; i++)
            System.out.println(Arrays.toString(last_move[i]));
        System.out.println();
        merge_parts(merge_field);



        remove_empty();
        normalize_direction(key_code);

        if (there_are_empty())
            generate_parts();
        else if(is_player_lost())
            System.out.println("YOU LOST");
    }

    private static void generate_parts(){
        Random rand = new Random();
        int rand_x = rand.nextInt(4);
        int rand_y = rand.nextInt(4);
        
        while (game_field[rand_x][rand_y] != 0) {
            rand_x = rand.nextInt(4);
            rand_y = rand.nextInt(4);
        }
        
        if (rand.nextInt(10) == 0)
            game_field[rand_x][rand_y] = 4;
        else
            game_field[rand_x][rand_y] = 2;
    }
}


