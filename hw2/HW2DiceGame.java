/**
 * Created by drewhoo on 9/13/16.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HW2DiceGame {
    public static String getInput(){
        String input = "";
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            input = in.readLine();
        } catch (IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
        System.out.println("getInput: " + input);
        return input;
    }

    public static String getPlayerType(){
        System.out.println("Enter 'h' for Human Player or 'c' for Computer Player");
        String playerType = getInput();
        return playerType;
    }


    public static void main(String[] args) {
        System.out.print("Welcome to the Jungle\nPlease enter your number of players: ");

        int numPlayers = Integer.parseInt(getInput());

        if (numPlayers < 2){
            System.out.println("Invalid number of Players");
            return;
        }

        List<Player> Players = new ArrayList<>();

        for(int i = 0; i<numPlayers; i++){
            // Create player objects here
            System.out.println("Enter Player Name: ");
            String newPlayerName = getInput();

            String playerType;
            playerType = getPlayerType();

            switch (playerType) {
                case "h": {
                    Player newPlayer = new Human(newPlayerName);
                    Players.add(newPlayer);
                    break;
                }
                case "c": {
                    Player newPlayer = new Computer(newPlayerName);
                    Players.add(newPlayer);
                    break;
                }
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
        System.out.println("Beginning Game...\n");

        // Call Game object here
        Game newGame = new Game(Players);
        newGame.startGame();

    }
}
