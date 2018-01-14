/**
 * Created by drewhoo on 11/20/16.
 */
public class QuotedField implements State{
    private CSVstateMachine csvStateMachine;

    public QuotedField(CSVstateMachine csvStateMachine){
        this.csvStateMachine = csvStateMachine;
    }

    public void seeAComma() {
        csvStateMachine.add(",");
    }

    public void seeQuotes() {
        csvStateMachine.setState(csvStateMachine.getSeenQuote());
    }

    public void seeOther(char character) {
        csvStateMachine.add(String.valueOf(character));
    }
}
