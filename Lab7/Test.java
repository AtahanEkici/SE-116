package Lab7;
import java.util.Scanner;
/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static void main(String[] args)
    {
        Scanner scan;
        
        Animal animal = new Animal();
        Cat cat = new Cat();
        Duck duck = new Duck();
        Goat goat = new Goat();
        
        
        // --------------------- Animal --------------------- //
        System.out.println("Please Specify name of the animal");
        scan = new Scanner(System.in);
        animal.setName(scan.nextLine());
        
        System.out.println("Please Specify height of the animal");
        scan = new Scanner(System.in);
        animal.setHeight(scan.nextDouble());
        
        System.out.println("Please Specify age of the animal");
        scan = new Scanner(System.in);
        animal.setAge(scan.nextInt());
        
        System.out.println("Please Specify number of legs of the animal");
        scan = new Scanner(System.in);
        animal.setNumberOfLegs(scan.nextInt());
        // --------------------- Animal --------------------- //
        
        
        // ----------------------- Cat ----------------------- //
        System.out.println("Please Specify name of the cat");
        scan = new Scanner(System.in);
        cat.setName(scan.nextLine());
        
        System.out.println("Please Specify height of the cat");
        scan = new Scanner(System.in);
        cat.setHeight(scan.nextDouble());
        
        System.out.println("Please Specify age of the cat");
        scan = new Scanner(System.in);
        cat.setAge(scan.nextInt());
        
        System.out.println("Please Specify number of legs of the cat");
        scan = new Scanner(System.in);
        cat.setNumberOfLegs(scan.nextInt());
        // ----------------------- Cat ----------------------- //
        
        
        // ----------------------- Duck ---------------------- //
        System.out.println("Please Specify name of the duck");
        scan = new Scanner(System.in);
        duck.setName(scan.nextLine());
        
        System.out.println("Please Specify height of the duck");
        scan = new Scanner(System.in);
        duck.setHeight(scan.nextDouble());
        
        System.out.println("Please Specify age of the duck");
        scan = new Scanner(System.in);
        duck.setAge(scan.nextInt());
        
        System.out.println("Please Specify number of legs of the duck");
        scan = new Scanner(System.in);
        duck.setNumberOfLegs(scan.nextInt());
        // ----------------------- Duck ---------------------- //
        
        
        // ----------------------- Goat ---------------------- //
        System.out.println("Please Specify name of the goat");
        scan = new Scanner(System.in);
        goat.setName(scan.nextLine());
        
        System.out.println("Please Specify height of the goat");
        scan = new Scanner(System.in);
        goat.setHeight(scan.nextDouble());
        
        System.out.println("Please Specify age of the goat");
        scan = new Scanner(System.in);
        goat.setAge(scan.nextInt());
        
        System.out.println("Please Specify number of legs of the goat");
        scan = new Scanner(System.in);
        goat.setNumberOfLegs(scan.nextInt());
        
         System.out.println("Please Specify lenght of the beard of the goat");
        scan = new Scanner(System.in);
        goat.setLenghtOfBeard(scan.nextInt());
        // ----------------------- Goat ---------------------- //
        
        System.out.println();
        animal.printVoice();
        cat.printVoice();
        duck.printVoice();
        goat.printVoice(); 
        
        animal.printAllData();
        cat.printAllData();
        duck.printAllData();
        goat.printAllData();
    }
}