import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by drewhoo on 10/2/16.
 */
public class ScoreService {
    private ScoreInput si;
    private ArrayList<Client> ClientObservers = new ArrayList<>();


    private String sport;
    private String homeTeam;
    private String awayTeam;
    private String homeScore;
    private String awayScore;

    public ScoreService(ScoreInput si){
        this.si = si;
        si.setObservers(this);
    }

    public void setVals(String s, String ht, String at, String hs, String as){
        sport = s;
        homeTeam = ht; homeScore = hs;
        awayTeam = at; awayScore = as;
    }

    public ArrayList<String> getVals(){
       return new ArrayList<>(Arrays.asList(sport, homeTeam, awayTeam, homeScore, awayScore));
    }

    public void setObservers(Client c){
        ClientObservers.add(c);
    }

    public void notifyObservers(){
        for( Client c : ClientObservers){
            c.notifyClient();
        }
    }
}