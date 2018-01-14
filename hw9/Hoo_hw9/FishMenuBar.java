import javax.swing.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FishMenuBar extends JMenuBar {
    private FishTankView view;

    public FishMenuBar(FishTankView view) {  // set up the menu bar
       this.view = view;
       JMenu animation = new JMenu("Animation");
       add(animation);
       JMenuItem startstop = new JMenuItem("Stop");
       animation.add(startstop);
       startstop.addActionListener(e->{
           String label = startstop.getText();
           view.startStopPressed();
           String newlabel = label.equals("Start") ? "Stop" : "Start";
           startstop.setText(newlabel);
      });
      
      JMenu newmenu = new JMenu("New Fish");
      add(newmenu);
      JMenuItem angelfish = new JMenuItem("Angel Fish");
      newmenu.add(angelfish);
      angelfish.addActionListener(e-> this.view.newFish(angelfish.getText()));
      JMenuItem meanie = new JMenuItem("Mean Fish");
      newmenu.add(meanie);
      meanie.addActionListener(e->this.view.newFish(meanie.getText()));
      JMenuItem octopus = new JMenuItem("Octopus");
      newmenu.add(octopus);
      octopus.addActionListener(e->this.view.newFish(octopus.getText()));
    }
}
