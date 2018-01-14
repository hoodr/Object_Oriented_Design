import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public abstract class Fish {
	private Point currentpos = new Point(20,20);
	private int xspeed = 3;
	private int yspeed = 1;
	private int xDirectionChangeFreq = 5;  // the fish changes horizontal direction 0.5% of the time
	private int yDirectionChangeFreq = 10; // the fish changes vertical direction 1% of the time	
	
	public void move(Dimension tanksize) {
		ImageIcon image = getImage();
		int x = moveX(currentpos.x, image.getIconWidth(),  tanksize.width);
		int y = moveY(currentpos.y, image.getIconHeight(), tanksize.height);
		currentpos = new Point(x,y);
	}
	
	public void display(JComponent c, Graphics g) {
      ImageIcon img = getImage();
      img.paintIcon(c, g, currentpos.x, currentpos.y);
   }
	
	private ImageIcon getImage() {
		if (movesRight())
			return rightImage();
		else
			return leftImage();
	}

	private int moveX(int pos, int fishwidth, int tankwidth) {
		if (changesDirection(xDirectionChangeFreq) ||
				(pos + xspeed + fishwidth > tankwidth) ||
				(pos + xspeed < 0)) {
			xspeed = -xspeed;
			return pos;
		}
		else
			return pos + xspeed;
	}

	private int moveY(int pos, int fishheight, int tankheight) {
		if (changesDirection(yDirectionChangeFreq) ||
				(pos + yspeed + fishheight > tankheight) ||
				(pos + yspeed < 0)) {
			yspeed = -yspeed;
			return pos;
		}
		else
			return pos + yspeed;
	}
	
	private boolean movesRight() {
		return xspeed >= 0;
	}
	
	private boolean changesDirection(int frequency) {
		return Math.random() * 1000 < frequency;
	}
	
	protected abstract ImageIcon rightImage();
	protected abstract ImageIcon leftImage();
}
