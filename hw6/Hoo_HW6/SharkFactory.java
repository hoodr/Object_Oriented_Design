/**
 * Created by drewhoo on 10/31/16.
 */
public class SharkFactory extends FishFactory {
    public Fish create() {
        return new Shark(new TeleportMovement());
    }
}
