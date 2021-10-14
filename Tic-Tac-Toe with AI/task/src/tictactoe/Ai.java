package tictactoe;

import java.util.Random;

public class Ai {
    public String[][] table;
    public String move;
    Difficulty difficulty;
    public String opponent;
    Random random;

    public Ai(String move, String[][] table, Difficulty difficulty) {
        this.move = move;
        this.opponent = move.equals("O") ? "X" : "O";
        this.table = table;
        this.difficulty = difficulty;
        this.random = new Random();
    };

    public void play(){
        switch (difficulty){
            case EASY: easyLogic(); break;
            case MEDIUM: mediumLogic(); break;
        }
    }

    public void setMove(String move) {
        this.move = move;
    }

    private void easyLogic(){
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

    private boolean makeMoveHorizontal(String prev1, String prev2, String prev3, int i, int j, String move) {
        if(prev1.equals(move)  && prev2.equals(move)  && prev3.equals(" ")) {
            table[i][j] = this.move;
           return true;
        } else if (prev3.equals(move) && prev2.equals(move)  && prev1.equals(" ")) {
            table[i][0] = this.move;
            return true;
        }
        return false;
    }

    private boolean makeMoveVertical(String prev1, String prev2, String prev3, int i, int j, String move){
        if(prev1.equals(move)  && prev2.equals(move)  && prev3.equals(" ")) {
            table[j][i] = this.move;
            return true;
        } else if (prev3.equals(move) && prev2.equals(move)  && prev1.equals(" ")) {
            table[0][i] = this.move;
            return true;
        }

        return false;
    }

    private boolean makeMoveDiagonal(String move){
        if(table[0][2].equals(move)   && table[1][1].equals(move)  && table[2][0].equals(" ")){
            table[2][0] = this.move;
           return true;
        } else if (table[2][0].equals(move)    && table[1][1].equals(move)  && table[0][2].equals(" ")){
            table[0][2] = this.move;
          return true;
        } else if (table[0][0].equals(move)  && table[1][1].equals(move) && table[2][2].equals(" ")){
            table[2][2] = this.move;
            return true;
        } else if (table[2][2].equals(move)  && table[1][1].equals(move)  && table[0][0].equals(" ")){
            table[0][0] = this.move;
            return true;
        }

        return false;
    }


    private void mediumLogic() {
        String prev1 = "";
        String prev2 = "";
        String prev3 = "";
        boolean madeMove = false;
        System.out.println("Making move level \"medium\"");
        // check horizontal;
        for (int i = 0; i < table.length; i++){
            for(int j = 0; j <= table.length; j++){
                if(j == 0) prev1 = table[i][j];
                if(j == 1) prev2 = table[i][j];
                if(j == 2) prev3 = table[i][j];
                if(j == 2) {
                  if(makeMoveHorizontal(prev1, prev2, prev3, i, j, move) || makeMoveHorizontal(prev1, prev2, prev3, i, j , opponent)){
                      madeMove = true;
                      break;
                  }
                }
            }
            if(madeMove) break;

            // check vertical
            for (int  j = 0; j < table.length; j++) {

                if(j == 0) prev1 = table[j][i];
                if(j == 1) prev2 = table[j][i];
                if(j == 2) prev3 = table[j][i];
                if(j == 2){

                    if(makeMoveVertical(prev1, prev2, prev3, i, j, move) || makeMoveVertical(prev1, prev2, prev3, i, j, opponent)){
                        madeMove = true;
                        break;
                    }
                }
            }

            if(madeMove) break;

            if(makeMoveDiagonal(move) || makeMoveDiagonal(opponent)) break;

            if(i == 2){
              while(true){
                  int m1 = random.nextInt(3);
                  int m2 = random.nextInt(3);
                  if(table[m1][m2].equals(" ")){
                      table[m1][m2] = move;
                      break;
                  }
              }
              break;
            }
        }
    }


}
