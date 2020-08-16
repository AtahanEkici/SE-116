package Test;

import Staff.Staff;
import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static void displayMenu()
    {
         Staff[] staffList = new Staff[3];
         
         int scanned = 0;

        while (scanned != 3) {
            System.out.println("A sample hospital information system is running now...\n" +
                    "MENU OPTIONS [1 through 3]:\n" +
                    "*** Press 1 to store information ***\n" +
                    "*** Press 2 to print information ***\n" +
                    "*** Press 3 to terminate the program ***\n" +
                    "Your choice? :");
            Scanner scan = new Scanner(System.in);
            scanned = scan.nextInt();
            
            switch (scanned)
            {
                case 1:
                    if(staffList[staffList.length-1] != null)
                    {
                        System.out.println("The Array is full!");
                        break;
                    }
                    
                    else
                    {
                for (int i=0;i<staffList.length;i++) 
                {
                    if (staffList[i] == null) 
                    {
                        staffList[i] = new Staff();
                        
                        int scanned_int;
                        String scanned_String;
                        char scanned_char;
                        
                        
                        System.out.println("Please provide ID");
                        Scanner scanner1 = new Scanner(System.in);
                        scanned_int = scanner1.nextInt();
                        staffList[i].set_staffID(scanned_int);
                        
                        
                        System.out.println("Please provide a Name");
                        scanner1 = new Scanner(System.in);
                        scanned_String = scanner1.nextLine();
                        staffList[i].set_fullName(scanned_String);
                        
                        
                        System.out.println("Please provide an Age");
                        scanner1 = new Scanner(System.in);
                        scanned_int = scanner1.nextInt();
                        staffList[i].set_age(scanned_int);
                       
                        
                        System.out.println("Please provide a gender character M or F");
                        scanner1 = new Scanner(System.in);
                        scanned_char = scanner1.next().charAt(0);
                        staffList[i].set_gender(scanned_char);
                       
                        
                        System.out.println("Please provide a Role");
                        scanner1 = new Scanner(System.in);
                        scanned_String = scanner1.nextLine();
                        staffList[i].set_role(scanned_String);
                       
                    }
                }
                    }
                    break;
                    
                    
                case 2:
                    for(int i=0;i<staffList.length;i++) 
                    {
                        if (staffList[i] != null)
                        {
                            System.out.print(i+ "th element");
                            System.out.println("ID: "+staffList[i].get_staffID());
                            System.out.println("Name: "+staffList[i].get_fullName());
                            System.out.println("Age: "+staffList[i].get_age());
                            System.out.println("Gender: "+staffList[i].get_gender());
                            System.out.println("Role: "+staffList[i].get_role());
                        }
                        else
                        {
                             System.out.println("Staff["+i+"] is empty\n");
                        }
                    }   
                    break;
                    
                   
                case 3:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Wrong Input Try Again");
                    break;
            }
        }
    }
    
    public static void main(String[] args)
    {
        displayMenu();  
    }
}
