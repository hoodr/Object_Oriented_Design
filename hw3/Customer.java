public class Customer {
    private int arrivalTime;
    private int serviceTime;
    private ItemDistribution id;
   
    public Customer(int t, String distribType, int N) {
        if (distribType.equals("u")){
            id = new Uniform(N);
        } else if (distribType.equals("b")){
            id = new Bimodal(N);
        } else {
            return;
        }
        arrivalTime = t;
        int howmanyItems = id.getItems();
        serviceTime = 2*howmanyItems + 10;
    }
   
    public void elapseOneSecond() {
        serviceTime --;
    }

    public boolean isFinished() {
        return serviceTime == 0;
    }

    public int arrivalTime() {
        return arrivalTime;
    }
}
