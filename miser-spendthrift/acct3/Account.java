package acct3;
import java.util.concurrent.atomic.AtomicInteger;

class Miser extends Thread {       // deposit
    Miser(int howMany) { this.howMany = howMany; }
    @Override
    public void run() {
	for (int i = 0; i < howMany; i++) 
	    Account.balance.incrementAndGet();
    }
    private int howMany;
}

class Spendthrift extends Thread { // withdraw
    Spendthrift(int howMany) { this.howMany = howMany; }
    @Override
    public void run() {
	for (int i = 0; i < howMany; i++) 
	    Account.balance.decrementAndGet();
    }
    private int howMany;
}

public class Account {
    public static AtomicInteger balance = new AtomicInteger();
}