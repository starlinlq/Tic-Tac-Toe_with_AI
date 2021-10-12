package tictactoe;

import java.util.Random;

public class Ai {
    public String[][] table;
    public String move;
    Difficulty difficulty;

    public Ai(String move, String[][] table, Difficulty difficulty) {
        this.move = move;
        this.table = table;
        this.difficulty = difficulty;
    };

    public void play(){
        switch (difficulty){
            case EASY: easyLogic();
            case MEDIUM: mediumLogic();
        }
    }

    public void setMove(String move) {
        this.move = move;
    }

    private void easyLogic(){
        Random random = new Random();
        System.out.println("Making move level \"easy\"");
        int r1;
        int r2;
        while(true){
            r1 = random.nextInt(3);
            r2 = random.nextInt(3);
            if(table[r1][r2].equals(" ")){
                table[r1][r2] = move;
                break;
            }
        }
    }

    private void mediumLogic(){}


}
