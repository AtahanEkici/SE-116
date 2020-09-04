package Lab7;
/**
 *
 * @author Atahan Ekici
 */
public class Cat extends Animal
{
    public Cat() 
    {
       super();
    }
    
    public Cat(String name,double height,int age,int numberOfLegs)
    {
        super(name,height,age,numberOfLegs);
    }
    
    @Override
    public void printVoice()
    {
        System.out.println("MEOW!");
    }
    
}
