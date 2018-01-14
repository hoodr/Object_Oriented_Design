/**
 * Created by drewhoo on 11/20/16.
 */
public class Error implements State {
    private CSVstateMachine csvStateMachine;

    public Error(CSVstateMachine csvStateMachine){
        this.csvStateMachine = csvStateMachine;
    }

    public void seeAComma(){
        csvStateMachine.setState(csvStateMachine.getBeginField());
        csvStateMachine.nextWord();
    }

    public void seeQuotes(){
        csvStateMachine.remove();
        csvStateMachine.add("ERROR");
    }

    public void seeOther(char character){
        csvStateMachine.remove();
        csvStateMachine.add("ERROR");
    }
}
