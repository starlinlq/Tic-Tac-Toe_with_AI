package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

enum Difficulty {EASY, MEDIUM, HARD};
enum States {DRAW, XWINS, YWINS, GAMENOTFINISHED}


public class Main {
    public static void main(String[] args) {
        // write your code here


        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Input command: ");
            String[] commands = scan.nextLine().split(" ");
            String command = commands[0];
            if(command.equals("exit")) break;
            if(commands.length < 3 ) {
                System.out.println("Bad parameters!");
                continue;
            }
            String p1 = commands[1];
            String p2 = commands[2];
            if(command.equals("start") && p1.equals("easy") || p1.equals("user") && p2.equals("user") || p2.equals("easy")) {

                TicTacToe game  = new TicTacToe();
                game.setTable();
                game.printTable();
                if(p1.equals("easy") || p2.equals("easy")){
                    game.setComputerAi(new Ai("O", game.table, Difficulty.EASY));
                }

               if(p1.equals("easy") && p2.equals("easy")){
                   game.computerVsComputer();
                   continue;
               } if (p1.equals("user") && p2.equals("user")){
                   while(!game.isAWinner){
                       System.out.print("Enter the coordinates: ");
                       if(scan.hasNextInt()){
                           int c1 = scan.nextInt();
                           int c2 = scan.nextInt();
                           game.playerVsPlayer( c1 -1 , c2 - 1);

                       } else {
                           System.out.println("You should enter numbers!");
                       }
                   }

                } else  {

                  while(!game.isAWinner){

                      game.setPLayers(p1, p2);
                      if(game.user.equals("O")){
                          game.computerPLays("X");
                      }
                      System.out.print("Enter the coordinates: ");
                      if(scan.hasNextInt()){
                          int c1 = scan.nextInt();
                          int c2 = scan.nextInt();
                          game.playerPlays(c1 - 1, c2 - 1);
                          if(game.user.equals("X") && !game.isAWinner){
                              game.computerPLays("O");
                          }
                      } else {
                          System.out.println("You should enter numbers!");
                      }
                  }
               }
            } else {
                System.out.println("Bad parameters!");
            }

        }

    }
}
