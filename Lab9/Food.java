package Lab9;
/**
 *
 * @author Atahan Ekici
 */
public class Food extends Product
{
    private double weight;
    
    public Food(int ID, String name, double price, double tax, double weight) 
    {
        super(ID, name, price, tax);
        this.weight = weight;
    }
    
    public Food(int ID,String Name,double price,double weight)
    {
        super(ID,Name,price,0.08);
        this.weight = weight;
    }
    
    public Food()
    {
        super(1,"Unknown Food",1.0,0.08);
        this.weight = 1.0;
    }
    
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    public double getWeight()
    {
        return this.weight;
    }

    @Override
    public double calculateActualPrice() 
    {
        return (this.getBasePrice() * this.weight * (1 + this.getTaxRate()));
    }   
    
    @Override
    public void display() 
    {
        super.display();
        System.out.println("Weight: "+this.weight+"");
        System.out.println("Selling Price: "+this.calculateActualPrice()+"");
    }
}