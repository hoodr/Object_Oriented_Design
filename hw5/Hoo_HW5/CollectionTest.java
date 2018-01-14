import java.io.*;
import java.util.*;

/**
 * Created by drewhoo on 10/21/16.
 */
public class CollectionTest {
    public static void main(String[] args) throws FileNotFoundException {
        // put location of dictionary.txt file here
        File input = new File("/Users/drewhoo/Documents/Boston_College/Senior_Year/OOD/Homeworks/HW5/dictionary.txt");

        Scanner scanner = new Scanner(input);
        ArrayList<String> dictionary = new ArrayList<>();

        while(scanner.hasNextLine()){
            String str = scanner.nextLine().replaceAll("\\s","");
            dictionary.add(str);
        }
        Comparator<String> cmp1 = Comparator.reverseOrder();

        Collection<String> sortedKA = new SortedCollection<>(cmp1, new FilteredCollection<>(dictionary, new StringPrefix("ka")));
        System.out.println(sortedKA.toString());

        Collection<String> prefixVivi = new FilteredCollection<>(dictionary, new StringPrefix("vivi"));
        Collection<String> prefixPse = new FilteredCollection<>(dictionary, new StringPrefix("pse"));

        Comparator<String> cmp2 = Comparator.comparingInt(String::length);
        Collection<String> sortedVivi = new SortedCollection<>(cmp2, prefixVivi);
        System.out.println(sortedVivi.toString());
        Collection<String> sortedPse = new SortedCollection<>(cmp2, prefixPse);
        System.out.println(sortedPse.toString());

        Collection<String> prefixViviPse = new MergedCollection<>(sortedPse, sortedVivi);

        Iterator<String> it = prefixViviPse.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

//        System.out.println(prefixViviPse.toString());
    }


}
