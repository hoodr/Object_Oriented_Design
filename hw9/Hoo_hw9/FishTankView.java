import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Drew on 12/2/2016.
 */
public class FishTankView extends JPanel implements FishView{
    private Collection<Fish> fish = new ArrayList<>();
    private ArrayList<FTViewObserver> observers = new ArrayList<>();

    public FishTankView(){
        setBackground(Color.blue);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Fish f : fish)
            f.display(this, g);
    }

    public void startStopPressed(){
    //  tells the controller that the start-stop button was pressed.
        for (FTViewObserver observer : observers){
            observer.startStopPressed();
        }
    }

    public void setObservers(FishTankController controller){
        observers.add(controller);
    }

    public Collection<Fish> getFish(){
        return fish;
    }

    public void newFish(String ftype){
        for(FTViewObserver observer : observers){
            observer.newFish(ftype);
        }
    }

    public void setSize(Dimension dims){
        for(FTViewObserver observer : observers){
            observer.setSize(dims);
        }
    }

    public void update(Collection<Fish> fish) {
        this.fish = fish;
        repaint();
    }
}
