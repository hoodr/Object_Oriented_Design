import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by drewhoo on 10/2/16.
 */
public class SportClient implements Client {
    private String Sport;
    private ScoreService sc;

    public SportClient(String sport, ScoreService sc){
        Sport = sport;
        this.sc = sc;
        sc.setObservers(this);
    }

    public void update(ScoreService sc) {
        ArrayList<String> vals = sc.getVals();
        if(vals.get(0).equals(getSport())){
            formatMessage(vals);
        }
    }

    public void notifyClient(){
        update(sc);
    }

    public String getSport(){
        return Sport;
    }

    public void formatMessage(ArrayList<String> vals) {
        String msg;
        int homeScore = Integer.parseInt(vals.get(3));
        int awayScore = Integer.parseInt(vals.get(4));

        if(homeScore > awayScore) {
            msg = vals.get(1) + " defeats " + vals.get(2) + ", " + homeScore + " to " + awayScore;
        } else if(homeScore < awayScore) {
            msg = vals.get(1) + " was defeated by " + vals.get(2) + ", " + awayScore + " to " + homeScore;
        } else {
            msg = vals.get(1) + " drew " + vals.get(2) + ", " + homeScore + " to " + awayScore;
        }
        showPanel(msg);
    }

    public void showPanel(String msg) {
        JFrame frame = new JFrame(getSport() + " News");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel txt = new JLabel(msg);

        panel.add(txt);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(650, 300);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
    }
}
