/**
 * Created by drewhoo on 11/20/16.
 */
public class BeginField implements State{
    private CSVstateMachine csvStateMachine;

    public BeginField(CSVstateMachine csvmachine){
        this.csvStateMachine = csvmachine;
    }

    public void seeAComma() {
        csvStateMachine.setState(csvStateMachine.getUnquotedField());
    }

    public void seeQuotes() {
        csvStateMachine.setState(csvStateMachine.getQuotedField());
    }

    public void seeOther(char character) {
        csvStateMachine.add(String.valueOf(character));
        csvStateMachine.setState(csvStateMachine.getUnquotedField());
    }
}
