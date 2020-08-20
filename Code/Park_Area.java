package Code;

import java.util.ArrayList;

/**
 *
 * @author Atahan Ekici
 */
public abstract class Park_Area
{
    private final int park_slot;
    protected ArrayList<Park_Area> parks = new ArrayList();
    protected double  fee;
    protected boolean Is_Occupied;
    
    Park_Area()
    {
       parks.add(this);
       park_slot = parks.size();
       Is_Occupied = false;
    }
    
    public int get_parkingNumber()
    {
        return this.park_slot;
    }
    
    public void set_fee(int fee)
    {
        this.fee = fee;
    }
    
    public double get_fee()       
    {
        return this.fee;
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
         return "Parking Slot Number: "+this.park_slot+" Fee: "+this.fee+"";
     }
    
    public double calculate_Discount(int hour,Park_Area park)
     {
        double park_fee_brut = (park.get_fee() / 7200); // get the parking fee of the park area //
        int time_spent = 7200 - hour; // get the number of seconds it spent on the parking spot //
        return (park_fee_brut * time_spent);
     }
}

