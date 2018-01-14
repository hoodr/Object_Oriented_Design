/**
 * Created by drewhoo on 10/31/16.
 */
public interface MovementStyle {
    int moveX(int pos, int fishwidth, int tankwidth);
    int moveY(int pos, int fishheight, int tankheight);
    boolean movesRight();
    boolean changesDirection(int frequency);
}
