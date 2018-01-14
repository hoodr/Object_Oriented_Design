/**
 * Created by drewhoo on 10/31/16.
 */
abstract public class FishFactory {

    public static FishFactory getFactory(String fishname){
        switch (fishname){
            case "Angel Fish":
                return new AngelFishFactory();
            case "Octopus":
                return new OctopusFactory();
            case "Mean Fish":
                return new MeanFishFactory();
            case "Shark":
                return new SharkFactory();
            default:
                throw new IllegalArgumentException();
        }
    }

    public abstract Fish create();
}
