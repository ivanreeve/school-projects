package package4;
import java.text.DecimalFormat;


public class BankAccount {
    //Properties
    public DecimalFormat MONEY = new DecimalFormat("$#.00");
    private String name;
    private String accountNumber;
    private double balance;
    
    //Constructor
    public BankAccount(String accountNumber, String name, double initialAmount){
        this.accountNumber = accountNumber;
        this.name = name;
        balance = initialAmount;
    }
    
    //Copy Constructor
    public BankAccount(BankAccount originalAccount, double initialBalance){
        accountNumber = originalAccount.accountNumber;
        name = originalAccount.name;
        balance = initialBalance;
    }
    
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    //Getters
    public String getName(){
        return name;
    }   
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public String getBalanceString(){
        return MONEY.format(balance);
    }
    
    //Transaction methods    
    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(amount > balance || amount < 0) return false;
        balance -= amount;
        return true;
    }
    
    //toString
    @Override
    public String toString(){
        return "Account Number " + accountNumber + " belonging to " + name;
    }
}
