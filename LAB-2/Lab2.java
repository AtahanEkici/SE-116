import java.util.Scanner;

public class Lab2 
{
    
public static void main(String[] args) 
{
        question1();
}
    
     public static void question1()
 {    
    int secim = 0;
        while(secim != 9)
    {
    System.out.println("\nA sample scientific calculator is running now ...\n" +
"Here are the menu options for your choice (1 through 5):\n" +
"*** Press 1 to calculate POWER ***\n" +
"*** Press 2 to calculate SQUARE ROOT ***\n" +
"*** Press 3 to calculate MAXIMUM ***\n" +
"*** Press 4 to calculate NATURAL LOGARITHM ***\n" +
"*** Press 5 to calculate BASE 10 LOGARITHM ***\n" +
"*** Press 9 to TERMINATE the program ***");
    
    System.out.println("Your Choice: ");
    
    Scanner secim_s = new Scanner(System.in);
    
    if(secim_s.hasNextInt() == false)
    {
        System.out.println("\nPlease provide an integer as stated above"); 
    }
    else
    {
        secim = secim_s.nextInt();
        
        switch(secim)
        {
            case 1:
                System.out.println("Please give 2 integer values: ");
                Scanner pow = new Scanner(System.in);
                double x = pow.nextInt();
                pow = new Scanner(System.in);
                double y = pow.nextInt();
                System.out.println("\n"+Math.pow(x, y));
                break;
                
            case 2:
                System.out.println("Please give an integer value: ");
                pow = new Scanner(System.in);
                x = pow.nextInt();
                System.out.println("\n"+Math.sqrt(x));
                break;
                
            case 3:
                System.out.println("Please give 2 integer values: ");
                pow = new Scanner(System.in);
                x = pow.nextInt();
                pow = new Scanner(System.in);
                y = pow.nextInt();
                System.out.println("\n"+Math.max(x, y));
                break;
                
            case 4:
                System.out.println("Please give an integer value: ");
                pow = new Scanner(System.in);
                x = pow.nextInt();
                System.out.println("\n"+Math.log(x));
                
            case 5:
                System.out.println("Please give an integer value: ");
                pow = new Scanner(System.in);
                x = pow.nextInt();
                System.out.println("\n"+Math.log10(x));
                break;
                
            case 9:
                break;
                
    }
   }
  }
 }
   
}
