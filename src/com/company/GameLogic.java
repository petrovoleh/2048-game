package com.company;

import java.util.Arrays;
import java.util.Random;

class Square {

}
class GameField{

    int[][] game_field = new int[4][4];

    GameField() {
        generate_parts();
        generate_parts();
    }

    public void generate_parts(){
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

    public void print_game_field(){
        for (int i = 0; i <4; i++){
            System.out.println(Arrays.toString(game_field[i]));
        }
    }
}

public class GameLogic {
    static void game_loop(){

        GameField field = new GameField();

        field.print_game_field();

    }
}
