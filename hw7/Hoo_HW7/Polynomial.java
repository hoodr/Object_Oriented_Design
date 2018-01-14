/**
 * Created by hoodr on 12/13/16.
 */
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by drewhoo on 11/7/16.
 */
public interface Polynomial extends Iterable<Polynomial> {
    public String toString();
    public boolean equals(Polynomial p);
    public int evaluate(Map<String,Integer> m);
    public Polynomial reduce();

    default void traverse(Consumer<Polynomial> consumer)
    {
        consumer.accept(this);
        forEach(mc -> mc.traverse(consumer));
    }

/*
    // A default method in the interface -- new for Java 8
    public boolean hasItem(Predicate<Polynomial> pred);
    public default void traverse(Consumer<Polynomial> f, Predicate<Polynomial> pred) {
        if (hasItem(pred)) {
            f.accept(this);
            forEach(mc->mc.traverse(f, pred));
        }
    }
 */
}