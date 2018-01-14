import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Drew on 12/2/2016.
 */
public interface FTModelObserver {
    boolean isSuspended();
    void update(Collection<Fish> fish);
}
