import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by drewhoo on 10/21/16.
 * The arguments to its constructor will be two component collections.
 * Unlike the other two classes, this class should not create a new local collection.
 * Instead, its iterator method should gets its values "on demand"
 * from the iterators of its components.
 * In effect, the merged collection is the union of the two component collections.
 */
public class MergedCollection<T> extends AbstractCollection<T> {
    Collection<T> collection1;
    Collection<T> collection2;

    public MergedCollection(Collection<T> coll1, Collection<T> coll2){
        collection1 = coll1;
        collection2 = coll2;
    }

    public int size(){
        return collection1.size() + collection2.size();
    }

    public Iterator<T> iterator(){
        return new mergeIterator<>(collection1.iterator(), collection2.iterator());
    }
}

/**
 * This method must return an appropriate Iterator object.
 * You will find it necessary to write customized Iterator
 * classes for this purpose.
 * (Recall that an Iterator class needs to implement the
 * methods next and hasNext.)
 *
 */

class mergeIterator<T> implements Iterator<T>{
    private ArrayList<Iterator<T>> arr = new ArrayList<>();
    private Iterator<T> currIt;
    private Iterator<T> i1;
    private Iterator<T> i2;
    private int current = 0;


    public mergeIterator(Iterator<T> i1, Iterator<T> i2){
        arr.add(i1);
        arr.add(i2);
        this.i1 = i1;
        this.i2 = i2;
    }

    public boolean hasNext() {
        Iterator<T> temp = arr.get(current);
        if(current == 1 && !temp.hasNext()){
            current++;
        }

        if(current > 1){
            return false;
        } else{
            return arr.get(current).hasNext();
        }
    }

    public T next() {
        Iterator<T> temp = arr.get(current);
        if(current == 1 && !temp.hasNext()){
            current++;
        }

        if(current > 1){
            return null;
        } else{
            return arr.get(current).next();
        }
    }

}