package Lab5;

/**
 *
 * @author Atahan Ekici
 */
public class Car extends Engine
{
    
    private Engine eng;
    
    private int carID;
    private String brand;
    private String model;
    private double topSpeed;
    private double price;
    
    public Car()
    {
       this.eng = new Engine();
       this.carID = 0;
       this.brand = "Unknown";
       this.model = "Unknown";
       this.topSpeed = 0.0;
       this.price = 0.0;
    }
    
    public Car(int carID, String brand, String model,double topSpeed,double price)
    {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.topSpeed = topSpeed;
        this.price = price;
        this.eng = new Engine();
    }
    
    public void set_carID(int carID)
    {
        this.carID = carID;
    }
    public int get_carID()
    {
        return this.carID;
    }
    
    public void set_brand(String brand)
    {
        this.brand = brand;
    }
    public String get_brand()
    {
        return this.brand;
    }
    
    public void set_model(String model)
    {
        this.model = model;
    }
    public String get_model()
    {
        return this.model;
    }
    
    public void set_topSpeed(double topSpeed)
    {
        this.topSpeed = topSpeed;
    }
    public double get_topSpeed()
    {
        return this.topSpeed;
    }
    
    public void set_price(double price)
    {
        this.price = price;
    }
    public double get_price()
    {
        return this.price;
    }
    
    public void set_eng(double volume,int displacement,String manufacturer)
    {
        this.eng.set_Volume(volume);
        this.eng.set_Displacement(displacement);
        this.eng.set_manufacturer(manufacturer);
    }
    
    public double get_eng_Volume()
    {
        return this.eng.get_Volume();
    }
    
    public int get_eng_Displacement()      
    {
        return this.eng.get_Displacement();
    }
    
    public String get_eng_Manufacturer()      
    {
        return this.eng.get_manufacturer();
    }
    
    public void printInfo()        
    {
        System.out.println(String.format("ID:%s \nBrand:%s \nModel:%s \nTop_Speed:%s%sPrice:%s\n-------------\n", this.carID,this.brand,this.model,this.topSpeed,this.eng,this.price));
    }
}
