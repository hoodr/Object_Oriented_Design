import java.util.function.Predicate;

/**
 * Created by drewhoo on 10/21/16.
 */
public class StringLength implements Predicate<String> {
    int val;

    public StringLength(int x){
        val = x;
    }

    public boolean test(String s){
        return s.length() < val;
    }
}
