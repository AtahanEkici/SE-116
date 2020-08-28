package Midterm_question2;
public class Car 
{
      private String brand;
      private static int instance;
      private String model;

      public Car(){brand="default"; model="default";instance++;displayInstance(); }

      public Car(String model){this. model=model;instance++; displayInstance();}
     

      public Car(String brand, String model)

{this.brand=brand; this.model=model; instance++;displayInstance();}
      
      private static void displayInstance()
      {
          System.out.println("This is instance : " +instance);
      }
};