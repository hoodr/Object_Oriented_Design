/**
 * Created by drewhoo on 11/20/16.
 */
public class UnquotedField implements State {
    private CSVstateMachine csvStateMachine;

    public UnquotedField(CSVstateMachine csvStateMachine){
        this.csvStateMachine = csvStateMachine;
    }

    public void seeAComma(){
        csvStateMachine.setState(csvStateMachine.getBeginField());
        csvStateMachine.nextWord();
    }

    public void seeQuotes(){
        csvStateMachine.setState(csvStateMachine.getError());
    }

    public void seeOther(char character){
        csvStateMachine.add(String.valueOf(character));
    }
}
