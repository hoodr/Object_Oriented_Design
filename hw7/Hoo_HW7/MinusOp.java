import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by drewhoo on 11/7/16.
 */
public class MinusOp implements Polynomial {
    private ArrayList<Polynomial> children = new ArrayList<>();
    protected Polynomial left;
    protected Polynomial right;

    public MinusOp(Polynomial child1, Polynomial child2){
        children.add(child1);
        children.add(child2);
        left = child1;
        right = child2;
    }

    public Polynomial getChild(int index){
        return children.get(index);
    }

    public String toString(){
        return " (" + children.get(0).toString() + "-" + children.get(1).toString() + ") ";
    }

    public boolean equals(Polynomial p){
        return p instanceof MinusOp && (left.equals(((MinusOp) p).left) || left.equals(((MinusOp) p).right)) && (right.equals(((MinusOp) p).right) || right.equals(((MinusOp) p).left));
    }

    public int evaluate(Map<String,Integer> m){
        return left.evaluate(m) - right.evaluate(m);
    }

    public Polynomial reduce(){
        if (left.equals(right)){
            return new Number(0);
        } else if (left.reduce() instanceof Number && right.reduce() instanceof Number){
            return new Number(left.reduce().evaluate(null) - left.reduce().evaluate(null));
        } else if (left.reduce() instanceof Number && left.reduce().evaluate(null) == 0){
            return new ProductOp(new Number(-1), right).reduce();
        } else if (right.reduce() instanceof Number && right.reduce().evaluate(null) == 0){
            return left.reduce();
        }
        return new MinusOp(left.reduce(), right.reduce());
    }

    public Iterator<Polynomial> iterator(){
        ArrayList<Polynomial> iter = new ArrayList<>();
        iter.add(left);
        iter.add(right);

        for (Polynomial l : left){
            iter.add(l);
        }
        for (Polynomial r : right){
            iter.add(r);
        }
        return iter.iterator();
    }
}
