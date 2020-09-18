package Question1;
/**
 *
 * @author Atahan
 */
public class Skater extends Sportsman
{
    private String type;

    public Skater(String name, String country,String type) 
    {
        super(name, country);
        this.type = type;
        typeChecker();
    }
    
    public void typeChecker()
    {
        if(this.type.matches("ice") || this.type.matches("board"))
        {
            System.out.println("Safe");
        }
        else
        {
            this.type = "ice";
        }
    }
    
    public void display()
    {
        System.out.println("Name: "+super.getName()+"\nCountry: "+super.getCountry()+"\nFinal Score: "+this.final_score+"\nType: "+this.type+"");
    }
    
    @Override
     public void setfinal_score()
     {
        int Max = super.getMax();
        int Min = super.getMin();
        this.final_score = (Max + Min) / 2;
     }
     }

