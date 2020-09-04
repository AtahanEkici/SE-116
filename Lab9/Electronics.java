package Lab9;
/**
 *
 * @author Atahan Ekici
 */
public class Electronics extends Product
{
    private double EnergyConsuption;
    
    public Electronics(int ID, String name, double price, double tax,double Energy) 
    {
        super(ID, name, price, tax);
        this.EnergyConsuption = Energy;
    }
    
    public Electronics(int ID, String name, double price,double Energy) 
    {
        super(ID, name, price, 0.46);
        this.EnergyConsuption = Energy;
    }
    
    public Electronics()
    {
        super(1,"Unknown Electronic",1.0,0.46);
        this.EnergyConsuption = 1.0;
    }
    
    public void setEnergyConsuption(double energy)
    {
        this.EnergyConsuption = energy;
    }
    public double getEnergyConsuption()
    {
        return this.EnergyConsuption;
    }

    @Override
    public double calculateActualPrice() 
    {
         return (this.getBasePrice() * this.EnergyConsuption * (1 + this.getTaxRate()));
    }
    
    @Override
    public void display() 
    {
        super.display();
        System.out.println("Energy Consuption: "+this.EnergyConsuption+"");
        System.out.println("Selling Price: "+this.calculateActualPrice()+"");
    }
}