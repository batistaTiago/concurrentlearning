package acct2;

class Miser extends Thread {       // deposit
    Miser(int howMany) { this.howMany = howMany; }
    @Override
    public void run() {
	for (int i = 0; i < howMany; i++) 
	    synchronized(Account.lock) {
		Account.balance++;
	    }
    }
    private int howMany;
    
}

class Spendthrift extends Thread { // withdraw
    Spendthrift(int howMany) { this.howMany = howMany; }
    @Override
    public void run() {
	for (int i = 0; i < howMany; i++) 
	    synchronized(Account.lock) {
		Account.balance--;
	    }
    }
    private int howMany;
}

public class Account {
    public static int balance = 0;
    public static final Object lock = new Object();
}
