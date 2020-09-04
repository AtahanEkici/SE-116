package Lab8;
/**
 *
 * @author Atahan Ekici
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;
    
    public SavingsAccount()
    {
        super();
        this.interestRate = 0.1;
    }
    
    public SavingsAccount(int ID,double balance,double interestRate)
    {
        super(ID,balance);
        this.interestRate = interestRate;
    }
    
    public void setInterestRate(double rate)
    {
        this.interestRate = rate;
    }
    public double getInterestRate()
    {
        return this.interestRate;
    }
    
    @Override
    public void deposit(double param)
    {
        if(param > 0)
        {
        this.balance += param;
        double temp = (this.balance * this.interestRate);
        this.balance += temp;
        }
        else
        {
            System.out.println("You can't deposit negative integer");
        }
    }
}
