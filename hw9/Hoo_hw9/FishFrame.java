import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@SuppressWarnings("serial")
public class FishFrame extends JFrame implements ActionListener {
    FishTankView view;
   
   public FishFrame(FishTankView view) {
       this.view = view;
       setTitle("Fish Tank");
       setSize(650, 400);
       setLocation(20,20);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       setJMenuBar(new FishMenuBar(view));
       getContentPane().add(view);

       addComponentListener(new ComponentAdapter(){
           public void componentResized(ComponentEvent e){
               view.setSize(getSize());
           }
       });
   }

    public void actionPerformed(ActionEvent e){
        repaint();
    }
}