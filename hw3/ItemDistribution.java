import java.util.Random;
/**
 * Created by drewhoo on 9/25/16.
 */
public interface ItemDistribution {
    int getItems();
}

class Uniform implements ItemDistribution{
    private int items;

    public Uniform(int N){
        items = 1 + (int)(Math.random() * N);
        System.out.println(items);
    }

    public int getItems(){
        return items;
    }
}

class Bimodal implements ItemDistribution{
    private int items;

    public Bimodal(int N){
        // [1 .. N/4] and [3N/4 .. N].
        Random rand = new Random();
        if (rand.nextInt(2) + 1 == 1){
            items = 1 + (int)(Math.random() * N/4);
        } else {
            items = (3 * N / 4) + (int)(Math.random() * N);
        }
    }

    public int getItems(){
        return items;
    }
}
