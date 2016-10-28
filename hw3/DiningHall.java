import java.util.Arrays;
import java.util.Comparator;

public class DiningHall {
	private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.
	private int NUM_REGISTERS;        // There are 4 cash registers.
	private CashRegister[] registers;

	public DiningHall(int normal, int fast, String distType, int distSize) {
        NUM_REGISTERS = normal + fast;
        registers = new CashRegister[NUM_REGISTERS];
		for (int r = 0; r < normal; r++) {
            registers[r] = new CashRegister(r, "normal", distType, distSize);
        }
        for (int r = normal; r < NUM_REGISTERS; r++) {
            registers[r] = new CashRegister(r, "fast", distType, distSize);
        }
	}

	public void elapseOneSecond(int t) {
		if (aCustomerArrives()) {
			// The new customer goes into the smaller line.
			CashRegister chosenRegister = smallestLine(); 
			chosenRegister.addCustomer(t);
        }
		for (int r=0; r<NUM_REGISTERS; r++) {
            registers[r].elapseOneSecond(t);  // Simulate each register for one second.
        }
	}

	public void printStatistics(String sortType) {
        Comparator<CashRegister> cmp;
        switch (sortType){
            case "s":
                cmp = new CompareByCustsServed();
                Arrays.sort(registers, cmp);
                break;
            case "w":
                cmp = new CompareByWaitTime();
                Arrays.sort(registers, cmp);
                break;
            case "x":
                break;
            default:
                System.out.println("Invalid");
                return;
        }
        printReg();
	}

	private void printReg(){
        for (int r=0; r<NUM_REGISTERS; r++) {
            CashRegister reg = registers[r];
            System.out.println("Register " + reg.whoAmI());
            System.out.println("Cashier Type " + reg.getCashierType());
            System.out.println("\tNumber served = " + reg.customersServed());
            System.out.println("\tAverage wait time = " + reg.avgWaitTime());
        }
    }

	private boolean aCustomerArrives() {
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}

	private CashRegister smallestLine() {
		CashRegister currentSmallest = registers[0];
		for (int r=1; r<NUM_REGISTERS; r++) {
			CashRegister cr = registers[r];
			if (cr.size() < currentSmallest.size())
				currentSmallest = cr;
		}
		return currentSmallest;	
	}
}
