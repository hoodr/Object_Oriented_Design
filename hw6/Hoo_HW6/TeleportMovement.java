import java.util.Random;
/**
 * Created by drewhoo on 10/31/16.
 */
public class TeleportMovement implements MovementStyle {
    private int xspeed;
    private int yspeed;
    private int xDirectionChangeFreq;
    private int yDirectionChangeFreq;
    private Random rand = new Random();

    public TeleportMovement(){
        Random rand = new Random();
        yDirectionChangeFreq = rand.nextInt(50);
        xDirectionChangeFreq = rand.nextInt(50);
        this.xspeed = rand.nextInt(200);
        this.xspeed = rand.nextInt(200);
    }


    public int moveX(int pos, int fishwidth, int tankwidth) {
        int teleportX = rand.nextInt(tankwidth);
        if (changesDirection(xDirectionChangeFreq) ||
                (pos + teleportX + fishwidth > tankwidth) ||
                (pos + teleportX < 0)) {
            xspeed = -teleportX;
            return pos;
        }
        else {
            return teleportX;
        }
    }

    public int moveY(int pos, int fishheight, int tankheight) {
        int teleportY = rand.nextInt(tankheight);
        if (changesDirection(yDirectionChangeFreq) ||
                (pos + teleportY + fishheight > tankheight) ||
                (pos + teleportY < 0)) {
            yspeed = -teleportY;
            return pos;
        }
        else {
            return teleportY;
        }
    }

    public boolean movesRight() {
        return xspeed >= 0;
    }

    public boolean changesDirection(int frequency) {
        return Math.random() * 1000 < frequency;
    }
}
