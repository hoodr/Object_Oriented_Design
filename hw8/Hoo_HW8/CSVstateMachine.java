import java.util.ArrayList;
import java.util.List;

/**
 * Created by drewhoo on 11/20/16.
 */
public class CSVstateMachine {
    private List<String> storeInput = new ArrayList<>();
    private State BeginField;
    private State Error;
    private State QuotedField;
    private State SeenQuote;
    private State UnquotedField;
    private State state;

    public CSVstateMachine(){
        BeginField = new BeginField(this);
        Error = new Error(this);
        QuotedField = new QuotedField(this);
        SeenQuote = new SeenQuote(this);
        UnquotedField = new UnquotedField(this);
        this.state = BeginField;
    }

    public List<String> getRow() {
        List<String> output = new ArrayList<>();
        String row = "";
        for (String s : storeInput) {
            row += s;
        }
        output.add(row);
        resetStoredInput();
        return output;
    }

    public void processChar(char character){
        if (character == ',') {
            state.seeAComma();
        } else if (character == '"') {
            state.seeQuotes();
        } else {
            state.seeOther(character);
        }
    }

    public void add(String string){
        storeInput.add(string);
    }

    public void remove(){
        String current;
        int counter;

        if (storeInput.size() > 0) {
            counter = storeInput.size() - 1;
        } else {
            counter = 0;
        }

        current = storeInput.get(counter);

        while(current.equals(" ")) {
            storeInput.remove(counter);
            counter = counter - 1;
            current = storeInput.get(counter);
        }
    }

    public void nextWord(){
        storeInput.add(" ");
        state = BeginField;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getBeginField() {
        return BeginField;
    }

    public State getError() {
        return Error;
    }

    public State getQuotedField() {
        return QuotedField;
    }

    public State getSeenQuote() {
        return SeenQuote;
    }

    public State getUnquotedField() {
        return UnquotedField;
    }

    private void resetStoredInput(){
        storeInput = new ArrayList<>();
    }
}