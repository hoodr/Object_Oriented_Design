import java.awt.*;
import java.util.Collection;

/**
 * Created by hoodr on 12/8/16.
 */
public interface FishView {
    void paintComponent(Graphics g);
    void setObservers(FishTankController controller);
    void update(Collection<Fish> fish);
}
