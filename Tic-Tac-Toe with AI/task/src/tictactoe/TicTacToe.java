package tictactoe;

class TicTacToe {
    String[][] table = new String[3][3];

    int counter =  9;
    boolean isAWinner = false;
    String user;
    String computer;
    String move = "X";
    Ai computerAi;

    public void setTable() {

        for(int x = 0; x < table.length; x++) {

            for(int j = 0; j < table.length; j++) {
                table[x][j] = " ";

            }
        }
    }

    public void printTable() {
        System.out.println("-".repeat(9));

        for(int x  = 0; x < table.length; x++){
            System.out.print("| ");
            for(int j = 0; j < table.length; j++){
                if(j == table.length -1){
                    System.out.print(table[x][j] +  " |" + "\n");
                    continue;
                }
                System.out.print(table[x][j] + " ");
            }
        }
        System.out.println("-".repeat(9));
    }

    public void setComputerAi(Ai ai){
        this.computerAi = ai;
    }

    public void  computerPLays(String move){
        computerAi.play();
        decCounter();
        verifyWinner(computerAi.move);
        printTable();
    }

    public void computerVsComputer(){
        Ai ai1 = new Ai("X", this.table, Difficulty.EASY);
        Ai ai2 = new Ai("O", this.table, Difficulty.EASY);
        while(!isAWinner) {
            ai1.play();
            this.decCounter();
            this.printTable();
            verifyWinner(ai1.move);
            if(isAWinner) break;
            ai2.play();
            this.decCounter();
            this.printTable();
            verifyWinner(ai2.move);
            if(isAWinner) break;
        }
    }

    private void decCounter(){
        this.counter--;
    }

    public void playerVsPlayer( int l1, int l2){

        if (l1 > 2 || l1 < 0 || l2 > 2 || l2 < 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            return;
        }
        if(table[l1][l2].equals(" ")) {
            table[l1][l2] = move;
            printTable();
           decCounter();
            verifyWinner(move);
        } else {
            System.out.println("This cell is occupied! Choose another one!");
        }
        if(this.move.equals("X")){
            this.move = "O";
        } else {
            this.move = "X";
        }
    }

    public void playerPlays(int l1, int l2){
        if (l1 > 2 || l1 < 0 || l2 > 2 || l2 < 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            return;
        }
        if(table[l1][l2].equals(" ")) {
            play(l1, l2);
           decCounter();
            verifyWinner(this.user);
        } else {
            System.out.println("This cell is occupied! Choose another one!");

        }
    }

    public void computerVsPlayer(int l1, int l2) {
        if(this.user.equals("X")){
            playerPlays(l1, l2);
            computerPLays(this.computer);
        } else {
            computerPLays(this.computer);
            playerPlays(l1, l2);
        }
    }

    public void setPLayers(String p1, String p2) {
        if(p1.equals("user")){
            this.user = "X";
            this.computer = "O";
        } else {
            this.user = "O";
            this.computer = "X";
        }
    }

    public boolean checkWinner1(String winner) {

        boolean finished = false;

        for(int x = 0; x < table.length; x++){
            if(table[x][0].equals(winner) && table[x][1].equals(winner) && table[x][2].equals(winner)){
                finished = true;
            }
            if(finished) break;
        }
        return finished;

    }

    public boolean checkWinner2(String winner){

        boolean finished = false;

        for(int x = 0; x < table.length; x++){
            if(table[0][x].equals(winner) && table[1][x].equals(winner) && table[2][x].equals(winner)){
                finished = true;
            }
            if(finished) break;
        }
        return finished;

    }

    public boolean checkWinner3(String winner){
        // add the logic for the winner
        if(table[0][2].equals(winner) && table[1][1].equals(winner) && table[2][0].equals(winner)){
            return true;
        } else return table[0][0].equals(winner) && table[1][1].equals(winner) && table[2][2].equals(winner);


    }

    public boolean verifyWinner(String winner) {
        var w1 = checkWinner1(winner);
        var w2 = checkWinner2(winner);
        var w3 = checkWinner3(winner);

        if (w1 || w2 || w3) {
            System.out.println(winner + " wins");
            isAWinner = true;
            return true;
        }
        if (counter == 0) {
            System.out.println("Draw");
            isAWinner= true;
            return false;
        }
        return false;
    }


    public void play(int l1, int l2) {
        table[l1][l2] = this.user;
        printTable();
    }

}