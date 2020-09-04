package Lab9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Test
{
    public static void DisplayMenu()
    {
        int secim = 0;
        Scanner scanned;
        
        ArrayList<Product> shoppingCart = new ArrayList<>();
        ArrayList<Product> shoppingCenter = new ArrayList<>();
        
        Food food1 = new Food(1,"Patato",2.25,1.0);
        Food food2 = new Food(2,"Cucumber",3.75,1.0);
        Food food3 = new Food(3,"Eggplant",5.50,1.0);
        Food food4 = new Food(4,"Tomato",1.75,1.0);
        Food food5 = new Food(5,"Apple",9.00,1.0);
        
        Electronics elec1 = new Electronics(1,"Graphics Card",500.0,20.0);
        Electronics elec2 = new Electronics(2,"RAM",200.0,3.0);
        Electronics elec3 = new Electronics(3,"Sound Card",100,10);
        Electronics elec4 = new Electronics(4,"Cooling Fan",20,5);
        Electronics elec5 = new Electronics(5,"MotherBoard",150.0,50);
        
        Drink drink1 = new Drink(1,"Garlic Juice",10.0,1.0);
        Drink drink2 = new Drink(2,"Apple Juice",5.0,1.0);
        Drink drink3 = new Drink(3,"Cherry Juice",5.0,1.0);
        Drink drink4 = new Drink(4,"Apricot Juice",5.0,1.0);
        Drink drink5 = new Drink(5,"Tomato Juice",7.5,1.0);
        
        shoppingCenter.add(food1);
        shoppingCenter.add(food2);
        shoppingCenter.add(food3);
        shoppingCenter.add(food4);
        shoppingCenter.add(food5);
        
        shoppingCenter.add(elec1);
        shoppingCenter.add(elec2);
        shoppingCenter.add(elec3);
        shoppingCenter.add(elec4);
        shoppingCenter.add(elec5);
        
        shoppingCenter.add(drink1);
        shoppingCenter.add(drink2);
        shoppingCenter.add(drink3);
        shoppingCenter.add(drink4);
        shoppingCenter.add(drink5);
        
        
        while(secim != 3 )
        {
            System.out.println("Press 1 to choose a product");
            System.out.println("Press 2 to get to checkout");
            System.out.println("Press 3 to terminate the program");
            scanned = new Scanner(System.in);
            
            while(scanned.hasNextInt() == false)
            {
                System.out.println("Wrong ınput");
                scanned = new Scanner(System.in);
            }
            secim = scanned.nextInt();
            
            switch(secim)
            {
                case 1:
                    System.out.println("Please Specify the name of the product");
                    Scanner scan = new Scanner(System.in);
                    String temp = scan.nextLine();
                    boolean found = false;
                    
                    for(int i = 0; i < shoppingCenter.size();i++)
                    {
                        if(shoppingCenter.get(i).getName().matches(temp) == true)
                        {
                            shoppingCart.add(shoppingCenter.get(i));
                            found = true;
                        }
                    }
                    if(found = false)
                    {
                        System.out.println("No product found with the name of "+temp+"");
                    }
                    
                    break;
                    
                case 2:
                    
                    double sum = 0;
                    double actual = 0;
                    
                    if(shoppingCart.isEmpty() == true)
                    {
                        System.out.println("No product is selected");
                        break;
                    }
                    
                    for(int i = 0;i<shoppingCart.size();i++)
                    {
                        actual += shoppingCart.get(i).getBasePrice();
                        sum += shoppingCart.get(i).calculateActualPrice();
                    }
                    System.out.println("Total item(s) in your Cart: "+shoppingCart.size()+"");
                    System.out.println("Your Shopping Cart's Base Value is: "+actual+"");
                    System.out.println("Your Shopping Cart Taxed Value is: "+sum+"");
                    System.exit(0);
                    break;
                    
                case 3:
                    scanned.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Wrong Input");
                    break;
            }
        }
    }
    
    public static void main(String[] args)
    {
        DisplayMenu();
    }
}
