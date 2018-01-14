import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

public class Octopus extends Fish {
	private ImageIcon leftimage, rightimage;

	public Octopus(MovementStyle movementStyle) {
		Random rand = new Random();
		super.currentpos = new Point(rand.nextInt(700),rand.nextInt(20));
		super.movementStyle = movementStyle;
		leftimage  = new ImageIcon("./images/Loctopus.gif");
		rightimage = new ImageIcon("./images/Roctopus.gif");
	}

	protected ImageIcon leftImage() {
		return leftimage;
	}

	protected ImageIcon rightImage() {
		return rightimage;
	}
}

