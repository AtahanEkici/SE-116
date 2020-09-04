package Lab7;
/**
 *
 * @author Atahan Ekici
 */
public class Animal 
{
    protected String name;
    protected double height;
    protected int age;
    protected int numberOfLegs;
    
    public Animal()
    {
        this.name = "Unknown";
        this.height = 1.0;
        this.age = 10;
        this.numberOfLegs = 2;
    }
    
    public Animal(String name, double height,int age,int numberOfLegs)
    {
        this.name = name;
        this.height = height;
        this.age = age;
        this.numberOfLegs = numberOfLegs;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    
    public void setHeight(double height)
    {
        this.height = height;
    }
    public double getHeight()
    {
        return this.height;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    
    public void setNumberOfLegs(int numberOfLegs)
    {
        this.numberOfLegs = numberOfLegs;
    }
    public int getNumberOfLegs()
    {
        return this.numberOfLegs;
    }
    
    public void printVoice()
    {
    System.out.println("In the future, the method printVoice will display the voice of a subclass of the class Animal");
    }
    
    public void printAllData()
    {
        System.out.println(String.format("\nName: %s \nHeight: %s\nAge: %s\nNumber_Of_Legs: %s\n", this.name,this.height,this.age,this.numberOfLegs));
    }
}
