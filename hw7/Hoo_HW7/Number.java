import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**import java.util.Collections;
 import java.util.Iterator;
 import java.util.Map;

 /**
 * Created by drewhoo on 11/7/16.
 */
public class Number implements Polynomial {
    protected int num;

    public Number(int num){
        this.num = num;
    }

    public Polynomial getChild(int index){
        return null;
    }

    public String toString(){
        return " " + num + " ";
    }

    public boolean equals(Polynomial p){
        return (p instanceof Number) && (this.num == ( (Number) p).num);
    }

    public int evaluate(Map<String,Integer> m){
        return num;
    }

    public Polynomial reduce(){
        return this;
    }

    public Iterator<Polynomial> iterator(){
        return Collections.emptyIterator();
    }
}