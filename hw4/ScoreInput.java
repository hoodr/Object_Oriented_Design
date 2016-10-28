import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by drewhoo on 10/3/16.
 */
public class ScoreInput {
    private String sport;
    private String homeTeam;
    private String awayTeam;
    private String homeScore;
    private String awayScore;
    private ArrayList<ScoreService> observers = new ArrayList<>();

    public void setObservers(ScoreService ob){
        observers.add(ob);
    }

    public void notifyObservers(){
        System.out.println("Notified Observers");
        for( ScoreService ss : observers){
            ss.setVals(sport, homeTeam, awayTeam, homeScore, awayScore);
            ss.notifyObservers();
        }
    }

    public ScoreInput(){
        buildPanel();
    }

    private void buildPanel(){
        JFrame frame = new JFrame("Score Input");
        JPanel panel = new JPanel();

        JLabel sportLbl = new JLabel("Sport");
        JTextField sportTxt = new JTextField("", 10);

        JLabel homeLbl = new JLabel("Home Team");
        JTextField homeTxt = new JTextField("", 10);

        JLabel awayLbl = new JLabel("Away Team");
        JTextField awayTxt = new JTextField("", 10);

        JLabel homeScoreLbl = new JLabel("Home Score");
        JTextField homeScoreTxt = new JTextField("", 10);

        JLabel awayScoreLbl = new JLabel("Away Score");
        JTextField awayScoreTxt = new JTextField("", 10);
        

        JButton button = new JButton("New Score");


        panel.add(sportLbl); panel.add(sportTxt);
        panel.add(homeLbl); panel.add(homeTxt);
        panel.add(awayLbl); panel.add(awayTxt);
        panel.add(homeScoreLbl); panel.add(homeScoreTxt);
        panel.add(awayScoreLbl); panel.add(awayScoreTxt);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(button);

        button.addActionListener(evt -> {
            try {
                sport = sportTxt.getText();
                homeTeam = homeTxt.getText();
                awayTeam = awayTxt.getText();
                homeScore = homeScoreTxt.getText();
                awayScore = awayScoreTxt.getText();

                if(sport.isEmpty() || homeTeam.isEmpty() || awayTeam.isEmpty() || homeScore.isEmpty() || awayScore.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Empty fields", "Invalid", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    notifyObservers();
                    frame.setVisible(false);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please provide correct inputs", "Invalid Input(s)", JOptionPane.WARNING_MESSAGE);
                return;
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(650, 300);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
    }
}
