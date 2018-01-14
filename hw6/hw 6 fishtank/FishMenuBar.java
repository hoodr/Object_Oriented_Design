import javax.swing.*;

@SuppressWarnings("serial")
public class FishMenuBar extends JMenuBar {
   
   public FishMenuBar(FishPanel fp) {  // set up the menu bar
      JMenu animation = new JMenu("Animation");
      add(animation);
   		JMenuItem startstop = new JMenuItem("Stop");
      animation.add(startstop);
      startstop.addActionListener(e->{
      		fp.toggleSuspend();
      		String label = startstop.getText();
      		String newlabel = label.equals("Start") ? "Stop" : "Start";
      		startstop.setText(newlabel);
      });
      
      JMenu newmenu = new JMenu("New Fish");
      add(newmenu);
      JMenuItem angelfish = new JMenuItem("Angel Fish");
      newmenu.add(angelfish);
      angelfish.addActionListener(e->newFish(fp, angelfish.getText()));
      JMenuItem meanie = new JMenuItem("Mean Fish");
      newmenu.add(meanie);
      meanie.addActionListener(e->newFish(fp, meanie.getText()));
      JMenuItem octopus = new JMenuItem("Octopus");
      newmenu.add(octopus);
      octopus.addActionListener(e->newFish(fp, octopus.getText()));    
   }
   
	private void newFish(FishPanel fp, String fishtype) {
		if (fishtype.equals("Angel Fish"))
			fp.addFish(new AngelFish());
		else if (fishtype.equals("Octopus"))
			fp.addFish(new Octopus());
		else if (fishtype.equals("Mean Fish"))
			fp.addFish(new MeanFish());
	}
}
