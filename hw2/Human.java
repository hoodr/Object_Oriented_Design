import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by drewhoo on 9/14/16.
 */
public class Human extends Player {
    public Human(String name){
        super(name);
    }

    public String getInput(){
        String input = "";
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            input = in.readLine();
        } catch (IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return input;
    }

    public int playerMoveDecision(int numDie){
        System.out.println("Next Move: ");
        String in = getInput();
        switch (in){
            case "roll":
                return 1;
            case "take":
                return 0;
            case "quit":
                return 2;
            default:
                return 2;
        }
    }
}
