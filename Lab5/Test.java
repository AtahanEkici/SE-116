package Lab5;

/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
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
   }
}
