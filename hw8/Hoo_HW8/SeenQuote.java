/**
 * Created by drewhoo on 11/20/16.
 */
public class SeenQuote implements State{
    private CSVstateMachine csvStateMachine;

    public SeenQuote(CSVstateMachine csvStateMachine){
        this.csvStateMachine = csvStateMachine;
    }

    public void seeAComma(){
        csvStateMachine.setState(csvStateMachine.getBeginField());
        csvStateMachine.nextWord();
    }

    public void seeQuotes(){
        csvStateMachine.add(String.valueOf('"'));
        csvStateMachine.setState(csvStateMachine.getQuotedField());
    }

    public void seeOther(char character){
        csvStateMachine.setState(csvStateMachine.getError());
    }
}
