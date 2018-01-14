import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by drewhoo on 10/21/16.
 * The arguments to its constructor will be a comparator and a component collection.
 * The constructor should create a list containing a copy of the values from
 * the component collection. It then sorts that list based on the comparator.
 * Its iterator and size methods use the corresponding methods of the sorted list.
 */
public class SortedCollection<T> extends AbstractCollection<T> {
    private Comparator<? super T> comparator;
    private List<T> collection;

    public SortedCollection(Comparator<T> cmp, Collection<T> col){
        this.collection = new ArrayList<>(col);
        this.comparator = cmp;
        Collections.sort(collection, comparator);
    }

    public int size(){
        return collection.size();
    }

    public Iterator<T> iterator(){
        return collection.iterator();
    }
}
