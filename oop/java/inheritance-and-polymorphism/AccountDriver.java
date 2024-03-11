package package4;

public class AccountDriver {
    public static void main(String[] args){

        final double depositAmount = 500;
        final double withdrawAmount = 1000;

        CheckingAccount benjamin = new CheckingAccount("100001","Benjamin Franklin",1000);
        SavingsAccount william = new SavingsAccount("100002","William Shakespeare",400);
        SavingsAccount william2 = new SavingsAccount(william,5);
        CheckingAccount isaac = new CheckingAccount("100003","Isaac Newton",0);

        //Benjamin
        System.out.println(benjamin);
        System.out.println("Initial balance = " + benjamin.getBalanceString());

        benjamin.deposit(depositAmount);
        System.out.println("After deposit of " + benjamin.MONEY.format(depositAmount) + ", balance = " + benjamin.getBalanceString());

        if(benjamin.withdraw(withdrawAmount))
            System.out.println("After withdrawal of " + benjamin.MONEY.format(withdrawAmount) + ", balance = " + benjamin.getBalanceString());
        else
            System.out.println("Insufficient funds to withdraw " + benjamin.MONEY.format(withdrawAmount) + ", balance = " + benjamin.getBalanceString());

        //William
        System.out.println(william);
        System.out.println("Initial balance = " + william.getBalanceString());

        william.deposit(depositAmount);
        System.out.println("After deposit of " + william.MONEY.format(depositAmount) + ", balance = " + william.getBalanceString());

        if(william.withdraw(withdrawAmount))
            System.out.println("After withdrawal of " + william.MONEY.format(withdrawAmount) + ", balance = " + william.getBalanceString());
        else
            System.out.println("Insufficient funds to withdraw " + william.MONEY.format(withdrawAmount) + ", balance = " + william.getBalanceString());

        william.postInterest();
        System.out.println("After monthly interest has been posted, balance = " + william.getBalanceString());

        //William 2
        System.out.println(william2);
        System.out.println("Initial balance = " + william2.getBalanceString());

        william2.deposit(depositAmount);
        System.out.println("After deposit of " + william2.MONEY.format(depositAmount) + ", balance = " + william2.getBalanceString());

        if(william2.withdraw(withdrawAmount))
            System.out.println("After withdrawal of " + william2.MONEY.format(withdrawAmount) + ", balance = " + william2.getBalanceString());
        else
            System.out.println("Insufficient funds to withdraw " + william2.MONEY.format(withdrawAmount) + ", balance = " + william2.getBalanceString());

        //Isaac
        System.out.println(isaac);
    }
}
