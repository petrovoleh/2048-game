package com.company;

import java.util.Random;

public class GameField{

    public int[][] game_field = new int[4][4];
    private int[][] merge_field = new int[4][4];

    GameField() {
        generate_parts();
        generate_parts();
    }

    void merge_parts(int[][] temp_field){
        for (int y = 0; y<4; y++) {
            for (int first = 0; first < 3; first++) {
                int second = first+1;
                while (temp_field[second][y] ==0 && second < 3)
                    second++;
                if (temp_field[first][y] == temp_field[second][y]){
                    temp_field[first][y]*=2;
                    temp_field[second][y]=0;
                }
            }
        }
    }

    void change_direction(int key_code){
        switch (key_code) {
            case 37 -> merge_field = game_field;
            case 38 -> merge_field = change_to_vertical(game_field);
            case 39 -> merge_field = flip(game_field);
            case 40 -> merge_field = flip(change_to_vertical(game_field));
        }
    }
    boolean is_player_lost(){
        int zeros=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(game_field[i][j] == 0)
                    zeros++;
            }
        }
        return zeros==0;
    }
    void normalize_direction(int key_code){
        switch (key_code) {
            case 37 -> game_field = merge_field;
            case 38 -> game_field = change_to_vertical(merge_field);
            case 39 -> game_field = flip(merge_field);
            case 40 -> game_field = change_to_vertical(flip(merge_field));
        }
    }

    int[][] flip(int[][] array) {
        int[][] temp_field= new int [4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(array[3 - i], 0, temp_field[i], 0, 4);
        }
        return temp_field;
    }
    int[][] change_to_vertical(int[][] array) {
        int[][] temp_field= new int [4][4];
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++){
                temp_field[i][j]=array[j][i];
            }
        }
        return temp_field;
    }
    private void remove_empty(){
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
    public void move_parts(int key_code){
        change_direction(key_code);
        merge_parts(merge_field);
        remove_empty();
        normalize_direction(key_code);
        if (is_player_lost())
            System.out.println("YOU LOST");
        else
            generate_parts();
    }

    void generate_parts(){
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


