import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Drew on 12/2/2016.
 */
public class FishTankModel implements ActionListener {

    private Collection<Fish> fish = new ArrayList<>();
    private boolean suspended = false;
    private Dimension size;
    private ArrayList<FTModelObserver> observers = new ArrayList<>();

    public FishTankModel(){}

    public Fish newFish(String fishType){
        try {

            FishFactory fishFactory = FishFactory.getFactory(fishType);
            Fish newFish = fishFactory.create();
            fish.add(newFish);

            return newFish;

        } catch (IllegalArgumentException | NullPointerException e){
            System.err.print(e);
        }
        return null;
    }

    public void setObservers(FTModelObserver observer){
        observers.add(observer);
    }

    public void tick() {
        if (!suspended) {

            for(Fish f : fish){
                f.move(size);
            }

            for(FTModelObserver observer : observers){
                observer.update(fish);
            }
        }
    }

    public Dimension getSize(){
        return size;
    }

    public void setSize(Dimension dims){
        size = dims;
    }

    public Collection<Fish> getFish(){
        return fish;
    }

    public boolean isSuspended(){
        return suspended;
    }

    public void setSuspended()
    {
        suspended = !suspended;
    }

    public void actionPerformed(ActionEvent e) {
        // called by the timer
        tick();
    }
}
