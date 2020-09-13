package Code;
/**
 *
 * @author Atahan Ekici
 */
public class A_ParkingArea extends Park_Area
{
    private final int park_slot;
    
    public A_ParkingArea(double fee)
    {
        this.fee = fee;
        this.Is_Occupied = false;
        parks.add(this);
        this.park_slot = parks.size();
    }
    
    public A_ParkingArea()
    {
        this.fee = 10.0;
        this.Is_Occupied = false;
        parks.add(this);
        this.park_slot = parks.size();
    } 
     
    @Override
    public String parking_slot_type()
    {
        return "A";
    }
     
    @Override
    public int get_parkingSlot()
    {
        return this.park_slot;
    }
     
    @Override
      public double calculate_Discount(int second)        
      {
        double park_fee_brut = (this.get_fee() / 7200); // get the parking fee of the park area for 1 second //
        int time_spent = 7200 - second; // get the number of seconds it spent on the parking spot //
        return (park_fee_brut * time_spent);
      }
}
