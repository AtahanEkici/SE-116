package Lab5;

/**
 *
 * @author Atahan Ekici
 */
public class Engine 
{
    private double volume;
    private int displacement;
    public String manufacturer;
    
    public Engine(double volume,int displacement,String manufacturer)
    {
        this.volume = volume;
        this.displacement = displacement;
        this.manufacturer = manufacturer;
    }
    
    public Engine()
    {
        this.volume = 1.2;
        this.displacement = 100;  
        this.manufacturer = "Bosch";
    }
    
    public double get_Volume()
    {
        return this.volume;
    }
    public double set_Volume(double volume)
    {
        return this.volume = volume;
    }
    
    public int get_Displacement()
    {
        return this.displacement;
    }
    public int set_Displacement(int displacement)
    {
        return this.displacement = displacement;
    }
    
    public String get_manufacturer()
    {
        return this.manufacturer;
    }
    public String set_manufacturer(String manufacturer)
    {
        return this.manufacturer = manufacturer;
    }
    
    @Override
    public String toString() 
    { 
        return String.format("\nVolume: %s\nDisplacement: %s\nManufacturer: %s\n",this.volume,this.displacement,this.manufacturer); 
    } 
}
