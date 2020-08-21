package Lab5;

import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static void User_Input(Car[] cars)
    {
        Scanner scan;
        
        for(int i = 0; i<cars.length;i++)
        {
        System.out.println("Please Input ID:");
        scan = new Scanner(System.in);
        cars[i].set_carID(scan.nextInt());
        
        System.out.println("Please Input Brand:");
        scan = new Scanner(System.in);
        cars[i].set_brand(scan.nextLine());
        
        System.out.println("Please Input Model:");
        scan = new Scanner(System.in);
        cars[i].set_model(scan.nextLine());
        
        System.out.println("Please Input Top Speed:");
        scan = new Scanner(System.in);
        cars[i].set_topSpeed(scan.nextDouble());
        
        System.out.println("Please Input Price:");
        scan = new Scanner(System.in);
        cars[i].set_price(scan.nextDouble());
        
        System.out.println("Please Input Engine Volume:");
        scan = new Scanner(System.in);
        double volume = scan.nextDouble();
        
        System.out.println("Please Input Engine Displacement:");
        scan = new Scanner(System.in);
        int displacement = scan.nextInt();
        
        System.out.println("Please Input Engine Brand:");
        scan = new Scanner(System.in);
        String brand = scan.nextLine();
        
        cars[i].set_eng(volume, displacement, brand);
        }
    }
    
    public static void main(String[] args)
    {
        final Car[] cars = new Car[3];
        
        cars[0] = new Car();
        cars[0].printInfo();
        
        cars[1] = new Car();
        cars[1].printInfo();
        
        cars[2] = new Car();
        cars[2].printInfo();
        
        cars[0].set_carID(1);
        cars[0].set_brand("Ford");
        cars[0].set_model("Focus");
        cars[0].set_topSpeed(150.8);
        cars[0].set_price(300000);
        cars[0].set_eng(1.5, 100, "Bosch");
        
        cars[1].set_carID(2);
        cars[1].set_brand("Citroen");
        cars[1].set_model("C5");
        cars[1].set_topSpeed(220.9);
        cars[1].set_price(450000);
        cars[1].set_eng(1.8, 80, "Maybach");
        
        cars[2].set_carID(3);
        cars[2].set_brand("Honda");
        cars[2].set_model("Civic");
        cars[2].set_topSpeed(250.5);
        cars[2].set_price(370000);
        cars[2].set_eng(1.2, 50, "Porsche");
        
        
        System.out.println("-------------MODIFIED-------------");
        cars[0].printInfo(); 
        cars[1].printInfo();
        cars[2].printInfo();
        
        User_Input(cars);
        
        System.out.println("-------------AFTER USER INPUT-------------");
   }
}
