/**
 * Created by drewhoo on 10/31/16.
 */
public class UpDownMovement implements MovementStyle {
    private int xspeed = 0;
    private int yspeed = 0;
    private int xDirectionChangeFreq;
    private int yDirectionChangeFreq;

    public UpDownMovement(int xspeed, int yspeed){
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        xDirectionChangeFreq = 20;
        yDirectionChangeFreq = 20;
    }

    public int moveX(int pos, int fishwidth, int tankwidth) {
        if (changesDirection(xDirectionChangeFreq) ||
                (pos + xspeed + fishwidth > tankwidth) ||
                (pos + xspeed < 0)) {
            xspeed = -xspeed;
            return pos;
        }
        else
            return pos + xspeed;
    }

    public int moveY(int pos, int fishheight, int tankheight) {
        if (changesDirection(yDirectionChangeFreq) ||
                (pos + yspeed + fishheight > tankheight) ||
                (pos + yspeed < 0)) {
            yspeed = -yspeed;
            return pos;
        }
        else
            return pos + yspeed;
    }

    public boolean movesRight() {
        return xspeed >= 0;
    }

    public boolean changesDirection(int frequency) {
        return Math.random() * 1000 < frequency;
    }
}
