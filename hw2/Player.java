/**
 * Created by drewhoo on 9/14/16.
 */

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {

    protected String Name;

    private int PlayerChips;

    private int PlayerRolls;

    private int TotalPlayerRolls;

    private int TotalOnes;

    public Player(String name){
        Name = name;
        PlayerChips = 0;
        PlayerRolls = 0;
        TotalPlayerRolls = 0;
        TotalOnes = 0;
    }

    public boolean roll(int num_die){
        // Player rolls n 4-sided die
        List<Integer> rollResults = new ArrayList<>();
        Random rand = new SecureRandom();
        for(int i = 0; i < num_die; i++) {
            int roll = rand.nextInt(4) + 1;
            rollResults.add(roll);
        }
        // Return a binary 1 for success no 1's, 0 for failure, there are 1's
        return !rollResults.contains(1);
    }

    public void incrementPlayerRolls(){
        PlayerRolls++;
        TotalPlayerRolls++;
    }

    public void resetPlayerRolls(){
        PlayerRolls = 0;
    }

    public int getPlayerRolls(){
        return PlayerRolls;
    }

    public void collectPot(int chip){
        PlayerChips += chip;
    }

    public int getPlayerChips(){
        return PlayerChips;
    }

    public int getTotalPlayerRolls(){
        return TotalPlayerRolls;
    }

    public void incrementTotalOnes(){
        TotalOnes++;
    }

    public int getTotalOnes(){
        return TotalOnes;
    }

    // Let the subclasses decide the move
    public abstract int playerMoveDecision(int numDie);
}


