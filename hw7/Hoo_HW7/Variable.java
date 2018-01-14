import java.util.*;

/**
 * Created by drewhoo on 11/7/16.
 */
public class Variable implements Polynomial {
    protected String var;

    public Variable(String var){
        this.var = var;
    }

    public Polynomial getChild(int index){
        return null;
    }

    public String toString(){
        return " " + var + " ";
    }
    public boolean equals(Polynomial p){
        return (p instanceof  Variable) && (var.equals(((Variable) p).var));
    }
    public int evaluate(Map<String,Integer> m) {
        if (m == null){
            throw new NullPointerException(" Null Map");
        } else if (!m.containsKey(var)){
            throw new NoSuchElementException(" Map Does not contain var");
        } else {
            return m.get(var);
        }
    }
    public Polynomial reduce(){
        return this;
    }

    public Iterator<Polynomial> iterator(){
        return Collections.emptyIterator();
    }
}
