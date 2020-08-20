package Code;

/**
 *
 * @author ataha
 */
public class C_ParkingArea extends Park_Area
{
    public C_ParkingArea(double fee)
    {
        this.fee = fee;
    }
    
     public C_ParkingArea()
    {
        this.fee = 20.0;
    }
     
     public double calculate_Discount(int second)        
      {
         double park_fee_brut = (this.get_fee() / 7200); // get the parking fee of the park area //
        int time_spent = 7200 - second; // get the number of seconds it spent on the parking spot //
        return (park_fee_brut * time_spent);
      }
}
