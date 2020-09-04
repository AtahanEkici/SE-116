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
        
        sa.withdraw(-100); // You can't withdraw negative values //
        sa.displayBalance(); // Your balance is: 150.0 //
        sa.withdraw(155.0); // Withdraw amount exceeds account balance //
        sa.displayBalance(); // Your balance is: 150.0 //
        sa.withdraw(150.0);
        sa.displayBalance(); // Your balance is: 0.0 //
          
        System.out.println();
        
        sa.deposit(-1000); //You can't deposit negative integer//
        sa.displayBalance(); // Your balance is: 0.0 //
        sa.deposit(200);
        sa.displayBalance(); // Your balance is: 220.0 //
        
        System.out.println("------------------------------");
        
        ca.withdraw(-200); // You can't withdraw negative integer //
        ca.displayBalance(); // Your balance is: 200.0 //
        ca.withdraw(210); // Not enough credits //
        ca.displayBalance(); // Your balance is: 200.0 //
        ca.withdraw(150);
        ca.displayBalance(); // Your balance is: 48.5 //
        
        System.out.println();
        
        ca.deposit(-100); // You can't deposit negative integer //
        ca.displayBalance(); // Your balance is: 48.5 //
        ca.deposit(200);
        ca.displayBalance(); // Your balance is: 247.0 //
    }
}
