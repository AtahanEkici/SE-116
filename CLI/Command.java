package CLI;
import static CLI.Command.printOccupied;import static CLI.Command.stopTimer;
import Code.*;import Interface.*;import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;import java.util.Timer;import java.util.TimerTask;
/**
 *
 * @author Atahan Ekici
 */
public class Command implements Interface_Container
{
    public static Timer timer1,timer2,timer3,timer4,timer5,timer6,timer7,timer8,timer9;
    static int number1,number2,number3,number4,number5,number6,number7,number8,number9;
    
    protected static A_ParkingArea a1 = new A_ParkingArea();
    protected static A_ParkingArea a2 = new A_ParkingArea();
    protected static A_ParkingArea a3 = new A_ParkingArea();
    
    protected static B_ParkingArea b1 = new B_ParkingArea();
    protected static B_ParkingArea b2 = new B_ParkingArea();
    protected static B_ParkingArea b3 = new B_ParkingArea();
    
    protected static C_ParkingArea c1 = new C_ParkingArea();
    protected static C_ParkingArea c2 = new C_ParkingArea();
    protected static C_ParkingArea c3 = new C_ParkingArea();
    
    protected static Thread scanner_Thread = new scannerThread();
    
    public static Command c = new Command();
    
    public static final void begin()
    {
        try
        {
        scanner_Thread.start();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }  
    }
    
    public void paymentMenu(double fee)
    {
        Scanner scan;
        int secim = 0;
        boolean isOver = false;
        while(isOver != true)
        {
            System.out.println("Please type 1 to pay by cash and 2 for pay by credit card");
            scan = new Scanner(System.in);
            
            if(scan.hasNextInt() == false)
            {
                System.out.println("\nPlease enter a number\n");
            }
            else
            {
                secim = scan.nextInt();
            }
            
            switch(secim)
            {
                case 1:
                    payByCash(fee);
                    isOver = true;
                    break;
                    
                case 2:
                    payByCreditCard(fee);
                    isOver = true;
                    break;
                    
                default:
                    System.out.print("1 or 2 must be selected\n");
                    break;
            }
        }
    }
    
    public static void printOccupied()
    {
        String Occupations = null;
        
        if(a1.get_Occupation() == true)
        {
            Occupations += "A1";
        }
        if(a2.get_Occupation() == true)
        {
            Occupations += ",A2";
        }
         if(a3.get_Occupation() == true)
        {
            Occupations += ",A3";
        }
         
         if(b1.get_Occupation() == true)
        {
            Occupations += ",B1";
        }
         if(b2.get_Occupation() == true)
        {
            Occupations += ",B2";
        }
         if(b3.get_Occupation() == true)
        {
            Occupations += ",B3";
        }
         
         if(c1.get_Occupation() == true)
        {
            Occupations += ",C1";
        }
         if(c2.get_Occupation() == true)
        {
            Occupations += ",C2";
        }
         if(c3.get_Occupation() == true)
        {
            Occupations += ",C3";
        }
         
         
         if(Occupations == null)
         {
            System.out.println("No parking slot is occupied for the moment");
         }
         else  
         {
            Occupations = Occupations.replaceAll("null", "");
            System.out.println(Occupations);
         } 
    }
    
    
    public static void stopTimer(int i)
    {
        switch (i) 
        {
            case 1:
                Command.c.paymentMenu(Command.a1.calculate_Discount(Command.number1));
                Command.timer1.cancel();
                Command.a1.set_Occupation(false);
                break;
                
            case 2:
                Command.c.paymentMenu(Command.a2.calculate_Discount(Command.number1));
                Command.timer2.cancel();
                Command.a2.set_Occupation(false);
                break;
                
            case 3:
                Command.c.paymentMenu(Command.a3.calculate_Discount(Command.number1));
                Command.timer3.cancel();
                Command.a3.set_Occupation(false);
                break;
                
            case 4:
                Command.c.paymentMenu(Command.b1.calculate_Discount(Command.number1));
                Command.timer4.cancel();
                Command.b1.set_Occupation(false);
                break;
                
            case 5:
                Command.c.paymentMenu(Command.b2.calculate_Discount(Command.number1));
                Command.timer5.cancel();
                Command.b2.set_Occupation(false);
                break;
                
            case 6:
                Command.c.paymentMenu(Command.b3.calculate_Discount(Command.number1));
                Command.timer6.cancel();
                Command.b3.set_Occupation(false);
                break;
                
            case 7:
                Command.c.paymentMenu(Command.c1.calculate_Discount(Command.number1));
                Command.timer7.cancel();
                Command.c1.set_Occupation(false);
                break;
                
            case 8:
                Command.c.paymentMenu(Command.c2.calculate_Discount(Command.number1));
                Command.timer8.cancel();
                Command.c2.set_Occupation(false);
                break;
                
            case 9:
                Command.c.paymentMenu(Command.c3.calculate_Discount(Command.number1));
                Command.timer9.cancel();
                Command.c3.set_Occupation(false);
                break;
                
            default:
                System.out.println("\n ------Hata------ \n");
                break;
        }
    }
    
    public static final void start_Timer1()
    {
        if(a1.get_Occupation() == true)
        {
            System.out.print("Already Occupied => "); System.out.println(Code.Utilities.calculateTime(number1)+"\n"); 
            
            System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(1);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
            a1.set_Occupation(true);
            timer1 = new Timer(); 
            TimerTask task1 = new Helper1();  
            timer1.schedule(task1, 0, 1000); 
        }
    
    }
    
    public static final void start_Timer2()
    {
        if(a2.get_Occupation() == true)
        {
          System.out.print("Already Occupied => ");
          System.out.println(Code.Utilities.calculateTime(number2)+"\n");  
          
          System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(2);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    a2.set_Occupation(true);
    timer2 = new Timer(); 
    TimerTask task1 = new Helper2();  
    timer2.schedule(task1, 0, 1000); 
        }
    }
        
    public static final void start_Timer3()
    {
        if(a3.get_Occupation() == true)
        {
            System.out.print("Already Occupied => ");
            System.out.println(Code.Utilities.calculateTime(number3)+"\n");
            
            System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(3);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    a3.set_Occupation(true);
    timer3 = new Timer(); 
    TimerTask task1 = new Helper3();  
    timer3.schedule(task1, 0, 1000);
        }
    }
    
    public static final void start_Timer4()
    {
        if(b1.get_Occupation() == true)
        {
            System.out.print("Already Occupied => ");
            System.out.println(Code.Utilities.calculateTime(number4)+"\n");
            
            System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(4);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    b1.set_Occupation(true);
    timer4 = new Timer(); 
    TimerTask task1 = new Helper4();  
    timer4.schedule(task1, 0, 1000); 
        }
    
    }           
                
     public static final void start_Timer5()
    {
        if(b2.get_Occupation() == true)
        {
            System.out.print("Already Occupied => ");
            System.out.println(Code.Utilities.calculateTime(number5)+"\n");
            
            System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(5);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    b2.set_Occupation(true);
    timer5 = new Timer(); 
    TimerTask task1 = new Helper5();  
    timer5.schedule(task1, 0, 1000); 
        }
    }
                    
    public static final void start_Timer6()
    {
        if(b3.get_Occupation() == true)
        {
           System.out.print("Already Occupied => ");
           System.out.println(Code.Utilities.calculateTime(number6)+"\n"); 
           
           System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(6);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    b3.set_Occupation(true);
    timer6 = new Timer(); 
    TimerTask task1 = new Helper6();  
    timer6.schedule(task1, 0, 1000); 
        }
    }                     
                        
    public static final void start_Timer7()
    { 
        if(a1.get_Occupation() == true)
        {
            System.out.print("Already Occupied => ");
           System.out.println(Code.Utilities.calculateTime(number7)+"\n"); 
           
           System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(7);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    a1.set_Occupation(true);
    timer7 = new Timer(); 
    TimerTask task1 = new Helper7();  
    timer7.schedule(task1, 0, 1000);   
        }
    }
    
    public static final void start_Timer8()
    {
        if(a2.get_Occupation() == true)
        {
            System.out.print("Already Occupied => ");
           System.out.println(Code.Utilities.calculateTime(number8)+"\n"); 
           
           System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(8);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    a2.set_Occupation(true);
    timer8 = new Timer(); 
    TimerTask task1 = new Helper8();  
    timer8.schedule(task1, 0, 1000); 
        }
    }
    
    public static final void start_Timer9()
    {
         if(a2.get_Occupation() == true)
        {
            System.out.print("Already Occupied => ");
           System.out.println(Code.Utilities.calculateTime(number9)+"\n"); 
           
           System.out.println("Input 1 for disembark\nInput 2 for Main Menu");
            Scanner scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("Wrong Input!");
            }
            
            int result = scan.nextInt();
            
            switch (result) 
            {
                case 1:
                    stopTimer(9);
                    break;
                    
                case 2:
                    break;
                    
                default:
                    System.out.println("Hata");
                    break;
            }
        }
        else
        {
    a3.set_Occupation(true);
    timer9 = new Timer(); 
    TimerTask task1 = new Helper9();  
    timer9.schedule(task1, 0, 1000); 
        }
    }
    
    private static double round(double value) // Rounds given presicion integer into 3 significant figures //
        {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.round(new MathContext(3));
        value = bd.doubleValue();
        return value;
        }

    @Override
    public void payByCash(double Fee) 
    {
        Fee = round(Fee);
        System.out.println("\nYour fee is: "+Fee+"\n");
        
        Scanner scanned;
        int secim;
        
        System.out.println("Press 1 to pay with 100 TL\n"+ "Press 2 to pay with 50 TL\n"+ "Press 3 to pay with 20 TL");
        scanned = new Scanner(System.in);
        
        while(scanned.hasNextInt() != true)
        {
            System.out.println("\nWrong Input!");
            System.out.println("Press 1 to pay with 100 TL\n"+ "Press 2 to pay with 50 TL\n"+ "Press 3 to pay with 20 TL");
            scanned = new Scanner(System.in);
        }
        secim = scanned.nextInt();
        
        switch(secim)
        {
            case 1:
                System.out.println("Your change is "+(100 - Fee)+"");
                break;
                
            case 2:
                System.out.println("Your change is "+(50 - Fee)+"");
                break;
                
            case 3:
                System.out.println("Your change is "+(20 - Fee)+"");
                break;
                
            default:
                System.out.println("\nWrong Input!");
                break;
        } 
    }

    @Override
    public void payByCreditCard(double Fee)
    {
        String card_number,CVC;
        
        Fee = round(Fee);
        System.out.println("\nYour fee is: "+Fee+"\n");
        System.out.print("Please Enter your Credit Card Number: ");
        Scanner scanned = new Scanner(System.in);
        card_number = scanned.nextLine();
        
        while(card_number == null || card_number.length() != 11)
        {
        System.out.println("Wrong input try again");    
        System.out.print("Please Enter your Credit Card Number: ");    
        scanned = new Scanner(System.in);
        card_number = scanned.nextLine();
        }
        
        System.out.println();
        System.out.print("Please Enter your CVC Number: ");
        scanned = new Scanner(System.in);
        CVC = scanned.nextLine();
        
        while(CVC == null || CVC.length() != 3)
        {
        System.out.println("Wrong input please try again");    
        System.out.print("Please Enter your CVC Number: ");    
        scanned = new Scanner(System.in);
        CVC = scanned.nextLine();
        }
        System.out.println("Your payment has been confirmed. Thank you.");
    }
}

class scannerThread extends Thread
{
    int choice_t = 0;
    Scanner scanned;
       
    @Override
    public void run()
    {
       while(choice_t != 11)
       {
           System.out.println("Please Select 1 out of 9 parking slots entering 10 displays Occupation 11 will terminate the program:");
           scanned = new Scanner(System.in);
           
           if(scanned.hasNextInt() == false)
           {
               System.out.println("Wrong Input");
           }
           else
           {
            choice_t = scanned.nextInt();
           
           switch(choice_t)
           {
               case 1:
                   Command.start_Timer1();
                   break;
                   
               case 2:
                   Command.start_Timer2();
                   break;
                   
               case 3:
                   Command.start_Timer3();
                   break;
                   
               case 4:
                   Command.start_Timer4();
                   break;
                   
               case 5:
                   Command.start_Timer5();
                   break;
                   
               case 6:
                   Command.start_Timer6();
                   break;
                   
               case 7:
                   Command.start_Timer7();
                   break;
                   
               case 8:
                   Command.start_Timer8();
                   break;
                   
               case 9:
                   Command.start_Timer9();
                   break;
                   
               case 10:
                   printOccupied();
                   break;
                   
               case 11:
                   System.out.println("\nProgram Terminated By User\n");
                   scanned.close();
                   System.exit(0);
                   break;
                   
               default:
                   System.out.println("Wrong input");
                   break;    
           }
           }   
       }
    }
}

class Helper1 extends TimerTask 
{ 
    Command c = new Command();
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(1);
        }
        else
        {
        --i;
        Command.number1 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 

class Helper2 extends TimerTask 
{ 
    Command c = new Command();
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(2);
        }
        else
        {
        --i;
        Command.number2 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 



class Helper3 extends TimerTask 
{ 
    Command c = new Command();
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(3);
        }
        else
        {
        --i;
        Command.number3 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 



class Helper4 extends TimerTask 
{ 
    Command c = new Command();
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(4);
        }
        else
        {
        --i;
        Command.number4 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 


class Helper5 extends TimerTask 
{ 
    Command c = new Command();
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(5);
        }
        else
        {
        --i;
        Command.number5 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 


class Helper6 extends TimerTask 
{ 
    Command c = new Command();
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(6);
        }
        else
        {
        --i;
        Command.number6 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 


class Helper7 extends TimerTask 
{ 
    Command c = new Command();
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
         stopTimer(7);
        }
        else
        {
        --i;
        Command.number7 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 


class Helper8 extends TimerTask 
{ 
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(8);
        }
        else
        {
        --i;
        Command.number8 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 


class Helper9 extends TimerTask 
{ 
    
    private int i = 7201; 
    @Override
    public void run() 
    { 
        if(i <= 0)
        {
        stopTimer(9);
        }
        else
        {
        --i;
        Command.number9 = i;
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        }  
    } 
} 