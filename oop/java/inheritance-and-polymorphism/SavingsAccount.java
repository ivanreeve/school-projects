package package4;

public class SavingsAccount extends BankAccount{
    
    //Constants
    private final int MONTH = 12;
    
    //Properties
    public double DEFAULT_RATE = 0.025;//Annual interest rate = 2.5%
    public int savingsNumber = 0;
    private String accountNumber;
    
    //Constructor
    public SavingsAccount(String accountNumber, String name, double initialBalance) {
        super(accountNumber, name, initialBalance);
        this.accountNumber = accountNumber + "-" + Integer.toString(savingsNumber);
    }
    
    //Copy Constructor
    public SavingsAccount(SavingsAccount originalAccount, double initialBalance) {
        super(originalAccount, initialBalance);
        savingsNumber = originalAccount.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + Integer.toString(savingsNumber);
    }
    
    //Methods
    public void postInterest(){
        final double monthlyInterest =  DEFAULT_RATE/MONTH;
        deposit(monthlyInterest * getBalance());
    }
    
    @Override
    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    //toString
    @Override
    public String toString(){
        return "Account Number " + getAccountNumber() + " belonging to " + getName();
    }
}
