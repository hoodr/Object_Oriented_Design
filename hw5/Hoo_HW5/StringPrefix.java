import java.util.function.Predicate;

/**
 * Created by drewhoo on 10/21/16.
 */
public class StringPrefix implements Predicate<String> {
    private String s;

    public StringPrefix(String s){
        this.s = s;
    }

    public boolean test(String in){
        int len = s.length();
        if (len > in.length()){
            return false;
        }
        String sub = in.substring(0, len);
        return sub.equals(s);
    }
}
