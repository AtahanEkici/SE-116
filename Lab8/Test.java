package Lab8;
/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static void main(String[] args)
    {
        SavingsAccount sa = new SavingsAccount(1,150.0,0.10);
        CheckingAccount ca = new CheckingAccount(2,200.0,1.50);
        
        sa.withdraw(-100);
        sa.displayBalance();
        sa.withdraw(155.0);
        sa.displayBalance();
        sa.withdraw(150.0);
        sa.displayBalance();
          
        System.out.println();
        
        sa.deposit(-1000);
        sa.displayBalance();
        sa.deposit(200);
        sa.displayBalance();
        
        System.out.println("------------------------------");
        
        ca.withdraw(-200);
        ca.displayBalance();
        ca.withdraw(210);
        ca.displayBalance();
        ca.withdraw(150);
        ca.displayBalance();
        
        System.out.println();
        
        ca.deposit(-100);
        ca.displayBalance();
        ca.deposit(200);
        ca.displayBalance();
    }
}
