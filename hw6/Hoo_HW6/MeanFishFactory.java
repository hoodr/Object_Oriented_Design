import java.util.Random;

/**
 * Created by drewhoo on 10/31/16.
 */
public class MeanFishFactory extends FishFactory {
    public Fish create(){
        Random rand = new Random();
        return new MeanFish(new OscillatingMovement(rand.nextInt(50), rand.nextInt(50)));
    }
}
