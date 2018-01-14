import java.awt.*;

/**
 * Created by Drew on 12/2/2016.
 */
public interface FTViewObserver {
    void newFish(String ftype);
    void startStopPressed();
    void setSize(Dimension d);
}
