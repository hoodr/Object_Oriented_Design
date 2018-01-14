import java.util.Random;

/**
 * Created by drewhoo on 10/31/16.
 */
public class AngelFishFactory extends FishFactory{
    public Fish create() {
        Random rand = new Random();
        return new AngelFish(new UpDownMovement(rand.nextInt(50), rand.nextInt(50)));
    }
}
