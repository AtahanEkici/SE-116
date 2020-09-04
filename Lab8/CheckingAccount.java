package Lab8;
/**
 *
 * @author Atahan Ekici
 */
public class CheckingAccount extends BankAccount
{
    private double fee;
    
    public CheckingAccount()
    {
       super();
       this.fee = 0.0;
    }
    
    public CheckingAccount(int ID,double balance,double fee)
    {
        super(ID,balance);
        this.fee = fee;
    }
    
    public void setFee(double fee)
    {
        this.fee = fee;
    }
    public double getFee()
    {
        return this.fee;
    }
    
    @Override
    public void deposit(double param)
    {
        if(param < 0)
        {
            System.out.println("You can't deposit negative integer");
        }
        else if(((balance - fee) + param) < 0)
        {
            System.out.println("Not enough credits");
        }
        else
        {
            this.balance += (param - fee);
        }
    }
    
    @Override
    public void withdraw(double param)
    {
        if(param < 0)
        {
           System.out.println("You can't withdraw negative integer");
        }
        else if(((balance - fee) - param) < 0)
        {
            System.out.println("Not enough credits");
        }
        else
        {
            this.balance -= (param + fee); 
        }
    }
}
