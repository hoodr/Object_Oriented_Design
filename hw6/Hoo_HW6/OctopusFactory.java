import java.util.Random;

/**
 * Created by drewhoo on 10/31/16.
 */
public class OctopusFactory extends FishFactory {
    public Fish create(){
        Random rand = new Random();
        return new Octopus(new HorizontalMovement(rand.nextInt(20)));
    }
}
