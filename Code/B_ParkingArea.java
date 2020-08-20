package Code;

/**
 *
 * @author Atahan Ekici
 */
public class B_ParkingArea extends Park_Area
{
    public B_ParkingArea(double fee)
    {
         this.fee = fee;
    }
    
    public B_ParkingArea()
    {
        this.fee = 15.0;
    }
    
    public double calculate_Discount(int second)        
      {
         double park_fee_brut = (this.get_fee() / 7200); // get the parking fee of the park area //
        int time_spent = 7200 - second; // get the number of seconds it spent on the parking spot //
        return (park_fee_brut * time_spent);
      }
}
