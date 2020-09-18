package Question1;
import java.util.Scanner;
/**
 *
 * @author Atahan Ekici
 */
public class Sportsman  
{
    private String name;
    private String country;
    private int[] points = new int[5];
    protected int final_score;
    
    public Sportsman(String name,String country)
    {
        this.name = name;
        this.country = country;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    
    
    public void setCountry(String country)
    {
        this.country = country;
    }
    public String getCountry()
    {
        return this.country;
    }
    
    public void setfinal_score()
    {
        int avg = 0;
        for(int i=0;i<points.length;i++)
        {
            avg += points[i];
        }
        avg = avg / points.length;
        this.final_score = avg;
    }
    public int getfinal_score()
    {
        return this.final_score;
    }
    
    public int getMax()
    {
        int Max = Integer.MIN_VALUE;
        
        for(int i=0;i<points.length;i++)
        {
            if(points[i] > Max)
            {
                Max = points[i];
            }
          
    }
        return Max;
    }
    
    public int getMin()
    {
         int Min = Integer.MAX_VALUE;
         
         for(int i=0;i<points.length;i++)
        {
           if(points[i] < Min)
            {
                Min = points[i];
            }
        }
           return Min;
    }
    
    public void fill_points()
    {
        Scanner scan = null;
        int holder;
        for(int i=0;i<points.length;i++)
        {
            System.out.println("Insert points");
            scan = new Scanner(System.in);
            
            if(scan.hasNextInt() == true)
            {
                holder = scan.nextInt();
                
                if(holder>= 0 && holder<=6)
                {
                points[i] = holder;
                }
                else
                {
                System.out.println("Should be between 0 and 6");
                i = i-1;
                } 
            }
            else
            {
                System.out.println("Wrong Input");
            }
        }
        scan.close();
    }
}
