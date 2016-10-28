import java.util.Comparator;
/**
 * Created by drewhoo on 9/25/16.
 */
public class CompareByCustsServed implements Comparator<CashRegister> {
    public int compare(CashRegister a, CashRegister b){
        if (a.customersServed() > b.customersServed()) {
            return 1;
        } else if (b.customersServed() > a.customersServed()){
            return -1;
        } else {
            return 0;
        }
    }
}
