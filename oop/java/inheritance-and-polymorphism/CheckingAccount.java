package package4;

public class CheckingAccount extends BankAccount{
    
    //Constants
    public static final double DEFAULT_FEE = 0.15; //unit = cents
    
    //Constructor
    public CheckingAccount(String accountNumber, String name, double initialAmount) {
        super(accountNumber+"-10", name, initialAmount);
    }
    
    //Transaction Methods
    @Override
    public boolean withdraw(double amount){
        return super.withdraw(amount + DEFAULT_FEE);
    }
    
    //toString
    @Override
    public String toString(){
        return "Account Number " + getAccountNumber() + " belonging to " + getName();
    }
}
