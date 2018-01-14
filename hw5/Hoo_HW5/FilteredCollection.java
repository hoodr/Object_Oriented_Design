import java.util.AbstractCollection;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by drewhoo on 10/21/16.
 *
 * The arguments to its constructor will be a predicate and a component collection.
 * The constructor should create a new collection containing those values from the
 * component collection that satisfy the predicate.
 * Its iterator and size methods use the corresponding methods of that collection.
 */
public class FilteredCollection<T> extends AbstractCollection<T>{
    private Collection<T> collection;
    private Predicate<T> predicate;

    public FilteredCollection(Collection<T> coll, Predicate<T> pred){
        this.predicate = pred;
        collection = new ArrayList<>();
        for (T t: coll){
            if (pred.test(t)){
                collection.add(t);
            }
        }
    }

    public int size(){
        return collection.size();
    }

    public Iterator<T> iterator(){
        return collection.iterator();
    }
}

