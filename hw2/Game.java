/**
 * Created by drewhoo on 9/14/16.
 */

import java.util.List;

public class Game {

    private List<Player> Players;
    private int NumberDie;
    private int Pot = 0;

    public Game(List<Player> players){
        Players = players;
        NumberDie = 0;
    }

    public void startGame(){
        int playerNumber = 0;
        boolean game = true;


        while(game){
            NumberDie++;
            Pot += NumberDie;
            System.out.println("Pot Contains: " + Pot + " Chips\n");
            Player current = Players.get(playerNumber);
            System.out.println("It is " + current.Name + "'s turn\n");
            int move = current.playerMoveDecision(NumberDie);
            boolean playerRoll;

            if(move == 0 && Pot == 1 && NumberDie == 1){
                move = current.playerMoveDecision(NumberDie);
            }

            switch(move){
                case 0:
                    //Call collect Pot
                    current.collectPot(Pot);
                    System.out.println(current.Name + " has stopped after " + current.getPlayerRolls() + " roll(s) and won " + Pot + " chips");
                    current.resetPlayerRolls();
                    playerNumber++;
                    Pot = 0;
                    NumberDie = 0;
                    System.out.println("Pot Contains: " + Pot + "\n");
                    game = checkScore(current);
                    break;
                case 1:
                    // Call rollDie
                    playerRoll = current.roll(NumberDie);
                    current.incrementPlayerRolls();

                    if (!playerRoll) {
                        System.out.println(current.Name + " has aced out after " + current.getPlayerRolls() + " Roll(s)");
                        System.out.println("Pot Contains: " + Pot + " chips\n");
                        NumberDie = 0;
                        playerNumber++;
                        current.resetPlayerRolls();
                        current.incrementTotalOnes();
                        game = checkScore(current);
                    }

                    break;
                case 2:
                    // exit game
                    System.out.println("pce and enjoy life");
                    game = false;
                    break;
                default:
                    // break
                    break;
            }

            if (playerNumber >= Players.size()) {
                 playerNumber = 0;
            }
            printChipCount();
        }



    }

    public boolean checkScore(Player current){
        // If game returns true game continues
        boolean game = true;
        if(current.getPlayerChips() == 30){
            // end game, some player won
            System.out.println("Game Over, " + current.Name + " Wins");
            game = false;
        }
        return game;
    }

    public void printChipCount(){
        System.out.print("Current Chip count: ");
        for(int i = 0; i < Players.size();i++){
            Player current = Players.get(i);
            System.out.print(current.Name + ": " + current.getPlayerChips() + " ");
        }
        System.out.println();
    }
}
