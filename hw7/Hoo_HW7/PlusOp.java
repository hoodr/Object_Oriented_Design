import java.util.*;

/**
 * Created by drewhoo on 11/7/16.
 */
public class PlusOp implements Polynomial {
    private ArrayList<Polynomial> children = new ArrayList<>();
    protected Polynomial left;
    protected Polynomial right;

    public PlusOp(Polynomial child1, Polynomial child2){
        children.add(child1);
        children.add(child2);
        left = child1;
        right = child2;
    }

    public Polynomial getChild(int index){
        return children.get(index);
    }

    public String toString(){
        return " (" + left.toString() + "+" + right.toString() + ") ";
    }

    public boolean equals(Polynomial p){
        return p instanceof PlusOp && (left.equals(((PlusOp) p).left) || left.equals(((PlusOp) p).right)) && (right.equals(((PlusOp) p).right) || right.equals(((PlusOp) p).left));
    }

    public int evaluate(Map<String,Integer> m){
        return left.evaluate(m) + right.evaluate(m);
    }

    public Polynomial reduce(){
        if (left.reduce() instanceof Number && right.reduce() instanceof Number){
            return new Number(left.reduce().evaluate(null) + right.reduce().evaluate(null));
        } else if (left.reduce() instanceof Number && left.reduce().evaluate(null) == 0){
                return right.reduce();
        } else if (right.reduce() instanceof Number && right.reduce().evaluate(null) == 0) {
            return left.reduce();
        }
        return new PlusOp(left.reduce(), right.reduce());
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