import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by drewhoo on 10/2/16.
 */
public class CollegeClient implements Client{
    private String School;
    private ScoreService sc;

    public CollegeClient(String school, ScoreService sc){
        School = school;
        this.sc = sc;
        sc.setObservers(this);
    }

    public String getSchool(){
        return School;
    }

    public void notifyClient(){
        update(sc);
    }

    public void update(ScoreService sc) {
        System.out.println("College Client");
        ArrayList<String> vals = sc.getVals();
        if(vals.get(1).equals(getSchool()) || vals.get(2).equals(getSchool())){
            formatMessage(vals);
        }
    }

    public void formatMessage(ArrayList<String> vals) {
        String msg;

        if (vals.get(1).equals(getSchool())) {
            int homeScore = Integer.parseInt(vals.get(3));
            int awayScore = Integer.parseInt(vals.get(4));

            if(homeScore > awayScore){
                msg = "The " + vals.get(0) + " team defeats " + vals.get(2) + ", " + homeScore + " to " + awayScore;
            } else if(homeScore < awayScore){
                msg = "The " + vals.get(0) + " team was defeated by " + vals.get(2) + ", " + awayScore + " to " + homeScore;
            } else {
                msg = "The " + vals.get(0) + " team drew " + vals.get(2) + ", " + homeScore + " to " + awayScore;
            }
            showPanel(msg);
        } else if(vals.get(2).equals(getSchool())){
            int homeScore = Integer.parseInt(vals.get(4));
            int awayScore = Integer.parseInt(vals.get(3));
            if(homeScore > awayScore){
                msg = "The " + vals.get(0) + " team defeats " + vals.get(1) + ", " + homeScore + " to " + awayScore;
            } else if(homeScore < awayScore){
                msg = "The " + vals.get(0) + " team was defeated by " + vals.get(1) + ", " + awayScore + " to " + homeScore;
            } else {
                msg = "The " + vals.get(0) + " team drew " + vals.get(1) + ", " + homeScore + " to " + awayScore;
            }
            showPanel(msg);
        } else{
            return;
        }
    }

    public void showPanel(String msg) {
        JFrame frame = new JFrame(getSchool() + " News");
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
