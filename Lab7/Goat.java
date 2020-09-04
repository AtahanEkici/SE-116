package Lab7;
/**
 *
 * @author Atahan Ekici
 */
public class Goat extends Animal
{
    private int lenghtOfBeard;
    
    public Goat()
    {
        super();
        this.lenghtOfBeard = 10; 
    }
    
    public Goat(String name , double height , int age , int numberOfLegs , int lenghtOfBeard)
    {
        super(name,height,age,numberOfLegs);
        this.lenghtOfBeard = lenghtOfBeard;
    }
    
    public void setLenghtOfBeard(int lenghtOfBeard)
    {
        this.lenghtOfBeard = lenghtOfBeard;
    }
    public int getLenghtOfBeard()
    {
        return this.lenghtOfBeard;
    }
    
    @Override
    public void printVoice()
    {
        System.out.println("BAAAAA!");
    }
    
    @Override
    public void printAllData()
    {
        System.out.println(String.format("\nName: %s \nHeight: %s\nAge: %s\nNumber_Of_Legs: %s\nLenght_Of_Beard: %s\n", this.name,this.height,this.age,this.numberOfLegs,this.lenghtOfBeard));
    }
}
