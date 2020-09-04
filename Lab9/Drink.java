package Lab9;
/**
 *
 * @author Atahan Ekici
 */
public class Drink extends Product
{
    private double volume;
    
    public Drink(int ID, String name, double price, double tax,double volume)
    {
        super(ID, name, price, tax);
        this.volume = volume;
    }
    
    public Drink(int ID, String name, double price,double volume)
    {
        super(ID, name, price, 0.18);
        this.volume = volume;
    }
    
    public Drink()
    {
        super(1,"Unknown Drink",1.0,0.18);
        this.volume = 1.0;
    }
    
    public void setVolume(double volume)
    {
        this.volume = volume;
    }
    public double getVolume()
    {
        return this.volume;
    }
    
    @Override
    public double calculateActualPrice() 
    {
         return (this.getBasePrice() * this.volume * (1 + this.getTaxRate()));
    }
    
    @Override
    public void display() 
    {
        super.display();
        System.out.println("Volume: "+this.volume+"");
        System.out.println("Selling Price: "+this.calculateActualPrice()+"");
    }
}