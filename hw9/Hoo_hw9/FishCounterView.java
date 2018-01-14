import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
/**
 * Created by hoodr on 12/8/16.
 */

public class FishCounterView extends JPanel implements FishView, ActionListener{
    private Collection<Fish> fish = new ArrayList<>();
    private Collection<FTViewObserver> observers = new ArrayList<>();
    private JLabel numberFish;
    private int numFish = 0;

    public FishCounterView(){
        JFrame frame = new JFrame();
        frame.setTitle("Fish Counter");
        frame.setSize(500, 100);
        frame.setLocation(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.getContentPane().setLayout(new GridLayout(1, 7));
        JLabel label = new JLabel("The aquarium has ");

        Integer temp = numFish;
        numberFish = new JLabel(temp.toString());
        numberFish.setForeground(Color.RED);
        JLabel label1 = new JLabel("fish");

        frame.add(label);
        frame.add(numberFish);
        frame.add(label1);

        frame.setVisible(true);
        Timer t = new Timer(200, this);
        t.start();  //do the animation forever
    }

    public void actionPerformed(ActionEvent e){
        numberFish.setVisible(!numberFish.isVisible());
    }

    public void addFish(Fish fish){}

    public void update(Collection<Fish> fish){
        numFish = fish.size();
        numberFish.setText("" + numFish);
    }

    public void setObservers(FishTankController controller){
        observers.add(controller);
    }

    @Override
    public void paintComponent(Graphics g){}
}