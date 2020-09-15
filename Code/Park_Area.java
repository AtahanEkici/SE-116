package Code;
import java.util.ArrayList;
/**
 *
 * @author Atahan Ekici
 */
public abstract class Park_Area
{
    protected static ArrayList<Park_Area> parks = new ArrayList();
    protected double fee;
    protected boolean Is_Occupied; 
    
    public void set_fee(int fee)
    {
        this.fee = fee;
    }  
    public double get_fee()       
    {
        return this.fee;
    }
    
    public String parking_slot_type()
    {
        return "Not Specified";
    }
    
    public void set_Occupation(boolean Occupation)
    {
        this.Is_Occupied = Occupation;
    }
    public boolean get_Occupation()
    {
        return this.Is_Occupied;
    }
    
   @Override
    public String toString()
    {
        return "Fee: "+this.get_fee()+"\n Occupation: "+this.get_Occupation()+"";
    }
    
    public abstract int get_parkingSlot();
    public abstract double calculate_Discount(int second);  
}