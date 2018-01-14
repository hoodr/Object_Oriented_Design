import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Drew on 12/2/2016.
 */
public class FishTankController implements FTViewObserver, FTModelObserver{
    private FishTankModel model;
    private FishView view;

    public FishTankController(FishTankModel model, FishView view){
        this.model = model;
        this.view = view;
//      register itself to observers
        model.setObservers(this);
        view.setObservers(this);
    }

    public void update(Collection<Fish> fish){
        // called by the model observer
        view.update(fish);
    }

    public boolean isSuspended(){
        return model.isSuspended();
    }

    public void newFish(String ftype){
        model.newFish(ftype);
    }

    public void startStopPressed(){
        model.setSuspended();
    }

    public void setSize(Dimension d){
        model.setSize(d);
    }
}
