package Lab9;
/**
 *
 * @author Atahan Ekici
 */
public abstract class Product 
{
    private final int ID;
    private final String NAME;
    private double basePrice;
    private double taxRate;
    
    public Product(int ID,String name,double price,double tax)
    {
        this.ID = ID;
        this.NAME = name;
        this.basePrice = price;
        this.taxRate = tax;
    }
    
    public int getID()
    {
        return this.ID;
    }
    
    public String getName()
    {
        return this.NAME;
    }
    
    public void setBasePrice(double price)
    {
        this.basePrice = price;
    }
    public double getBasePrice()
    {
        return this.basePrice;
    }
    
    public void setTaxRate(double tax)
    {
        this.taxRate = tax;
    }
    public double getTaxRate()
    {
        return this.taxRate;
    }
    
    public void display()
    {
        System.out.println("--------------------");
        System.out.println("ID: "+this.ID+"");
        System.out.println("NAME: "+this.NAME+"");
        System.out.println("Base Price: "+this.basePrice+"");
        System.out.println("Tax Rate: "+this.taxRate+"");
    }
    
    public abstract double calculateActualPrice();
}
