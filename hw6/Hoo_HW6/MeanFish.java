import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

public class MeanFish extends Fish {
	private ImageIcon leftimage, rightimage;

	public MeanFish(MovementStyle movementStyle) {
        Random rand = new Random();
        super.currentpos = new Point(rand.nextInt(700),rand.nextInt(650));
		super.movementStyle = movementStyle;
		leftimage  = new ImageIcon("./images/Lmeaniefish.gif");
		rightimage = new ImageIcon("./images/Rmeaniefish.gif");
	}

	protected ImageIcon leftImage() {
		return leftimage;
	}

	protected ImageIcon rightImage() {
		return rightimage;
	}
}
