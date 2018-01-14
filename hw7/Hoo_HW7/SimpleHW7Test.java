
import java.util.*;

public class SimpleHW7Test {

    public static void main(String[] args) {
        Polynomial x = new Variable("x");
        Polynomial y = new Variable("y");
        Polynomial three = new Number(3);
        Polynomial xPlusThree = new PlusOp(x,three);
        Polynomial p = new ProductOp(xPlusThree, y);

        String s = p.toString();
        System.out.println(s);

        System.out.println();
//        ((x * 1) + 3) * ((y + 0) + (z * 0))

        Polynomial x2 = new Variable("x");
        Polynomial one = new Number(1);
        Polynomial t1 = new ProductOp(x2, one);
        Polynomial three1 = new Number(3);

        Polynomial p1 = new PlusOp(t1, three1);


        Polynomial y1 = new Variable("y");
        Polynomial zero = new Number(0);
        Polynomial p2 = new PlusOp(y1, zero);

        Polynomial z = new Variable("z");
        Polynomial zero2 = new Number(0);
        Polynomial t2 = new ProductOp(z , zero2);

        Polynomial p3 = new PlusOp(p2, t2);

        Polynomial t3 = new ProductOp(p1, p3);

        String reduce = t3.toString();
        System.out.println(reduce);

//        Polynomial reduced = t3.reduce();
//        System.out.println(reduced.toString());

        Set<Variable> getVars = getVarsInternal(p1);
        System.out.println(getVars.toString());

        System.out.println();

        Map<String, Integer> m = new HashMap<>();
//           [x=6, y=7]
        m.put("x", 6);
        m.put("y", 7);

        int out = p.evaluate(m);
        System.out.println(out);
    }

    public static Set<Variable> getVarsExternal(Polynomial polynomial) {
        HashSet<Variable> vars = new HashSet<>();

        for (Polynomial poly : polynomial){
            if (!poly.iterator().hasNext()){
                try {
                    poly.evaluate(null);
                } catch (NullPointerException e) {
                    vars.add((Variable) poly);
                }
            }
        }
        return vars;
    }

    public static Set<Variable> getVarsInternal(Polynomial polynomial) {
        HashSet<Variable> vars = new HashSet<>();

        polynomial.traverse(p -> {
            if (!p.iterator().hasNext()){
                try {
                    p.evaluate(null);
                } catch (NullPointerException e) {
                    vars.add((Variable) p);
                }
            }
        });
        return vars;
    }
}
