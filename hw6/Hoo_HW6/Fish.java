import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public abstract class Fish {
    protected Point currentpos;
    protected MovementStyle movementStyle;

	public void move(Dimension tanksize) {
		ImageIcon image = getImage();
		int x = movementStyle.moveX(currentpos.x, image.getIconWidth(),  tanksize.width);
		int y = movementStyle.moveY(currentpos.y, image.getIconHeight(), tanksize.height);
		currentpos = new Point(x,y);
	}
	
	public void display(JComponent c, Graphics g) {
      ImageIcon img = getImage();
      img.paintIcon(c, g, currentpos.x, currentpos.y);
   }
	
	private ImageIcon getImage() {
		if (movementStyle.movesRight())
			return rightImage();
		else
			return leftImage();
	}

	protected abstract ImageIcon rightImage();
	protected abstract ImageIcon leftImage();
}
