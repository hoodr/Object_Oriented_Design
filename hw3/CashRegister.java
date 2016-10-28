import java.util.*;

public class CashRegister {
  	private int whoami;  // identifies the cash register
  	private List<Customer> custs = new LinkedList<Customer>();
  	private int numServed = 0;
  	private int totalWaitTime = 0;
  	private Customer currentCust = null;
    private Cashier cashierType;
    private final String distType;
    private final int distSize;

  	public CashRegister(int n, String cashierType, String distType, int distSize) {
        this.distSize = distSize;
        this.distType = distType;
        whoami = n;
        if (cashierType.equals("normal")){
            this.cashierType = new NormalSpeed();
        } else {
            this.cashierType = new Fast();
        }
        System.out.println(cashierType);
  	}
  	
  	public void addCustomer(int t) {
    		Customer c = new Customer(t, distType, distSize);
    		custs.add(c);
    		if (currentCust == null){
    			 currentCust = c;
        }
  	}

  	public void elapseOneSecond(int currentTime) {
    		// Return if there is no current customer.
    		if (currentCust == null){
    			 return;
        }
    		// Otherwise, process the current customer.
        cashierType.elapseOneSecond(currentCust);
    		if (currentCust.isFinished()) {
      			numServed++;
      			totalWaitTime += currentTime - currentCust.arrivalTime();
      			custs.remove(0);  // Remove the finished customer and make the next customer current.
      			currentCust = custs.size() > 0 ? custs.get(0) : null;
    		}
  	}

  	public int size() { 
  		  return custs.size(); 
  	}

  	public int customersServed() { 
  		  return numServed; 
  	}

  	public int avgWaitTime() { 
  		  return totalWaitTime / numServed; 
  	}
  	
  	public int whoAmI() {
  		  return whoami;
  	}

    public String getCashierType(){
        return cashierType.Identity();
    }
}
