package Lab10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static void displayMenu()
    {
    System.out.println("<<<<<<<RENT-A-HOUSE SEARCH PROGRAM>>>>>>>" );
    System.out.println("PRESS 1 to search the house by the properties you seek" );
    System.out.println("PRESS 2 to search the house by checking a real estate agent" );
    System.out.println("PRESS 3 to exit" );
    System.out.println("\nPlease enter your choice to continue..." );
    }
    
    public static void main(String[] args)
    {
        ArrayList<AdvertOwner> advertowner = new ArrayList<>();
        ArrayList<House> house = new ArrayList<>();
        ArrayList<Advert> advert = new ArrayList<>();
        int secim = 0;
        Scanner scan;
        
        AdvertOwner AdvertOwner1 = new AdvertOwner("Bomba Atar",01,"118 80");
        AdvertOwner AdvertOwner2 = new AdvertOwner("Abdurrahman Çamyarmaz",02,"118 10");
        AdvertOwner AdvertOwner3 = new AdvertOwner("Şeyime Gündoğdu",02,"118 30");
        
        advertowner.add(AdvertOwner1);
        advertowner.add(AdvertOwner2);
        advertowner.add(AdvertOwner3);
        
        House House1 = new House("2+1",1,80,"379. Sokak");
        House House2 = new House("3+1",2,90,"400. Sokak");
        House House3 = new House("4+1",3,100,"450. Sokak");
        
        house.add(House1);
        house.add(House2);
        house.add(House3);
        
        Advert Advert1 = new Advert(1,AdvertOwner1,House1,500);
        Advert Advert2 = new Advert(2,AdvertOwner2,House2,500);
        Advert Advert3 = new Advert(3,AdvertOwner3,House3,500);
        
        advert.add(Advert1);
        advert.add(Advert2);
        advert.add(Advert3);
        
        while(secim != 3)
        {
            displayMenu();
            scan = new Scanner(System.in);
            
            while(scan.hasNextInt() == false)
            {
                System.out.println("\nWrong Input Try Again\n");
                scan = new Scanner(System.in);
                if(scan.hasNextInt() == true)
                {
                    secim = scan.nextInt();
                }
            }
            
            switch(secim)
            {
                case 0:
                    break;
                    
                case 1:
                    try
                    {
                    String room;
                    int floor;
                    boolean collapsed = false;
                    
                    System.out.println("How many rooms ? :");
                    scan = new Scanner(System.in);
                    room = scan.nextLine();
                    
                    System.out.println("Which floor ? :");
                    scan = new Scanner(System.in);
                    floor = scan.nextInt();
                    
                    for(int i = 0;i<house.size();i++)
                    {
                        collapsed = false;
                        
                        if(house.get(i).getRooms().matches(room))
                        {
                            System.out.println("Matched From Room: "+house.get(i).print(null, null, 1));
                            collapsed = true;
                        }
                        
                        if(house.get(i).getFloor() == floor)
                        {
                            if(collapsed = false)
                            {
                                System.out.println("Matched From Floor: "+house.get(i).print(null, null, 1));
                            }
                        }
                    }
                    
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                    
                case 2:
                    // Too much work tbh //
                    break;
                    
                case 3:
                    scan.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Error");
                    break;
            }
        }
}
}
