/**
 * Created by drewhoo on 9/25/16.
 */
public interface Cashier {
/*
The Cashier interface will have two methods: a method to "elapse a second",
 and a method to identify itself (i.e. by returning a string "fast" or "normal").
 */
    String Identity();
    void elapseOneSecond(Customer c);
}

class NormalSpeed implements Cashier{
    public String Identity() {
        return "Normal Speed";
    }
    public void elapseOneSecond(Customer c) {
        c.elapseOneSecond();
    }
}

class Fast implements Cashier{
    public String Identity() {
        return "Fast";
    }
    public void elapseOneSecond(Customer c) {
        c.elapseOneSecond();
        if(!c.isFinished()){
            c.elapseOneSecond();
        }
    }
}
