import javax.swing.*;

public class FishTank {
   public static void main(String[] args) {
      FishTankModel model = new FishTankModel();
      FishTankView view = new FishTankView();
      FishCounterView counterView = new FishCounterView();

      FishTankController controller = new FishTankController(model, view);

      FishTankController controller2 = new FishTankController(model, counterView);

      FishFrame frame = new FishFrame(view);

      frame.setVisible(true);
      Timer t = new Timer(100, model);
      t.start();  //do the animation forever
   }
}
