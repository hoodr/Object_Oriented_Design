import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

/**
 * Created by drewhoo on 10/31/16.
 */
public class Shark extends Fish {
    private ImageIcon leftimage, rightimage;

    public Shark(MovementStyle movementStyle) {
        Random rand = new Random();
        super.currentpos = new Point(rand.nextInt(700),rand.nextInt(650));
        super.movementStyle = movementStyle;
        leftimage  = new ImageIcon("./images/Lshark.gif");
        rightimage = new ImageIcon("./images/Rshark.gif");
    }

    protected ImageIcon leftImage() {
        return leftimage;
    }

    protected ImageIcon rightImage() {
        return rightimage;
    }
}
