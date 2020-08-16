import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab1 
{
    public static void question1()
    {       
        int value = 0;
        Scanner scan;
        
         System.out.println("\n Please Enter degree values (In Celcius):");
        
        while(value != -1000)
        {
 
       scan = new Scanner(System.in);
        
        value = scan.nextInt();
   
          if(value >= 27)
          {
              System.out.println(""+value+" is a hot day");
          }
          else if(value >= 14 && value <= 26)
          {
              System.out.println(""+value+" is a pleasant day");
          }
          else if(value < 14 && value >= -1)
          {
              System.out.println(""+value+" is a cold day");
          }
          else if(value < -1 && value > - 1000)
          {
              System.out.println(""+value+" is a freezing day");
          }
          else if(value == -1000)
          {
              break;
          }
          else
          {
              System.out.println("Please enter a integer value");
          }
        }   
    }
    
    public static void question2()
    {
        Scanner scan;
        int fd=0,pd=0,cd=0,hd=0,value,total_temp=0;
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        boolean initialized = false;

       System.out.println("\n Please Enter degree values in Celcius (-1000 to quit):");
        
        while(true)
        {
         
       scan = new Scanner(System.in);
        
        value = scan.nextInt();
        
        if(initialized == false && value != - 1000)
        {
            max = value;
            min = value;
            initialized = true;
        }
        
         if(value == - 1000)
          {
              int sum = (fd + cd + pd + hd);
              double avg = (total_temp / sum);
              
              System.out.println("Number of freezing days: "+fd+"");
              System.out.println("Number of cold days: "+cd+"");
              System.out.println("Number of pleasant days: "+pd+"");
              System.out.println("Number of hot days: "+hd+"");
              System.out.println();
              System.out.println("The lowest temperature is "+min+" degrees Celcius.");
              System.out.println("The highest temperature is "+max+" degrees Celcius.");
              System.out.println("The avarage temperature is "+avg+" degrees Celcius.");
              break;
          }
        
          if(max < value)
          {
              max = value;
          }
          if(min > value)
          {
              min = value;
          }
   
         else if(value >= 27)
          {
              hd++;
              total_temp += value;
              System.out.println(""+value+" is a hot day");
          }
          else if(value >= 14 && value <= 26)
          {
              pd++;
              total_temp += value;
              System.out.println(""+value+" is a pleasant day");
          }
          else if(value <= 13 && value >= - 1)
          {
              cd++;
              total_temp += value;
              System.out.println(""+value+" is a cold day");
          }
          else if(value <= -2)
          {
              fd++;
              total_temp += value;
              System.out.println(""+value+" is a freezing day");
          }
          else
          {
              System.out.println("Please enter a integer value");
          }
        }
    }
    
    public static int fact(int i)
    {
        int result = 1;
        
        if(i == 1 || i == 0)
        {
          return 1; 
        } 
        else
        {
            while(i > 1)  
            {
                result *= i;
                i--;
            }
        }
        return result;
    }
    
    public static void question3()
    {
        System.out.println("Enter a non-negative integer:");
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        
        if(value > -1)
        {
            System.out.println(fact(value));
        }
        else
        {
            System.out.println("Error");
        }
    }
    
    public static void question4()
    {
        System.out.println("Factoriel of 1: "+fact(1));
        System.out.println("Factoriel of 2: "+fact(2));
        System.out.println("Factoriel of 3: "+fact(3));
        System.out.println("Factoriel of 4: "+fact(4));
        System.out.println("Factoriel of 5: "+fact(5));
        System.out.println("Factoriel of 6: "+fact(6));
    }
    
     public static ArrayList<Integer> RNG(int i)
    {
        int counter = 1;
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        
        while(counter < i)
        {
            list.add(rand.nextInt(40));
            counter++;
        }
        return list;
    }
    
    public static void question5()
    {
        ArrayList<Integer> list;
        ArrayList<Integer> list2 = new ArrayList<>();
        list = RNG(50);
        System.out.println(list);
        Object[] array2 = null;
        Object[] array = list.toArray();
        int highest = Integer.MIN_VALUE;
        int total_hot_day = 0;
        int b = 0;
        
        for(int a=0;a<array.length;a++)
        {     
        int cur = (int)array[a];
        
        if(a >= 10)
        {
           list2.add(cur);
        }
        
       if(cur > 26)
            {
                if(highest < cur)
                {
                    highest = cur;
                }
                 System.out.println(""+cur+" is a hot day");
                 total_hot_day++;
            }
        }
        System.out.println("Total number of hot days: "+total_hot_day+"");
        array2 = list2.toArray();
        for(int c = 0; c < array2.length; c++)
        {
            int cur2 = (int)array2[c];
            System.out.print(cur2+", ");
        }
 
    }
        public static void main(String[] args) 
        {
        //question1();
        //question2();
        //question3();
        //question4();
        //question5();
        }
}