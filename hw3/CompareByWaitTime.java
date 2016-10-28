import java.util.Comparator;

/**
 * Created by drewhoo on 9/25/16.
 */
public class CompareByWaitTime implements Comparator<CashRegister> {
    public int compare(CashRegister a, CashRegister b) {
        if (a.avgWaitTime() > b.avgWaitTime()) {
            return 1;
        } else if (b.avgWaitTime() > a.avgWaitTime()){
            return -1;
        } else {
            return 0;
        }
    }
}
