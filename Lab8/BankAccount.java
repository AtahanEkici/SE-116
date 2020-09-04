package Lab8;
/**
 *
 * @author Atahan Ekici
 */
public class BankAccount 
{
    protected int accountID;
    protected double balance;
    
    public BankAccount()
    {
        this.accountID = 1;
        this.balance = 0.0;
    }
    
    public BankAccount(int ID , double balance)
    {
        this.accountID = ID;
        this.balance = balance;
    }
    
    public void setID(int ID)
    {
        this.accountID = ID;
    }
    public int getID()
    {
        return this.accountID;
    }
    
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public double getBalance()
    {
        return this.balance;
    }
    
    public void deposit(double param)
    {
        if(param > 0)
        {
            this.balance += param;
        }
        else
        {
            System.out.println("You can't deposit negative values");
        }  
    }
    
    public void withdraw(double param)
    {
        if(this.balance < param)
        {
            System.out.println("Withdraw amount exceeds account balance");
        }
        else if(param < 0)
        {
            System.out.println("You can't withdraw negative values");
        }
        else
        {
            this.balance -= param;
        }
    }
    
    public void displayBalance()
    {
        System.out.println("Your balance is: "+this.getBalance()+"");
    }
}
