/**
 * Created by drewhoo on 9/14/16.
 */

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Computer extends Player {

    private final int CompType;

    public Computer(String name){
        super(name);
        Random rand = new SecureRandom();
        int type = rand.nextInt(100);
        if( type > 50){
            CompType = 1;
        } else {
            CompType = 2;
        }
        System.out.println("Computer Type: " + CompType);
    }

    // Use probability to decide whether or not to roll
    private boolean compAlg1(int numDie){
        Random rand = new SecureRandom();
        int decision = rand.nextInt((int) Math.pow(4, (double) numDie)) + 1;
        return !(decision == 1);
    }

    // Some algorithm I made up
    private boolean compAlg2(int totalPlayerRolls, int totalOnes, int numDie){
        if(totalPlayerRolls == 0 || totalOnes == 0){
            return true;
        }
        double a = ((double)totalOnes / ((double)totalPlayerRolls + (double)numDie));
        return (a == 0 || a <= 0.3);
    }

    public int playerMoveDecision(int numDie){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Use appropriate algorithm for choice
        boolean decision;
        if(CompType == 1){
            decision = compAlg1(numDie);
        } else {
            decision = compAlg2(getTotalOnes(), getTotalPlayerRolls(), numDie);
        }

        if(decision){
            // return 1 to roll
            System.out.println(Name + " decided to roll");
            return 1;
        } else {
            // return 0 to take
            System.out.println(Name + " decided to take");
            return 0;
        }
    }

}
