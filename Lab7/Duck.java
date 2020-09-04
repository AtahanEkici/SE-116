package Lab7;
/**
 *
 * @author Atahan Ekici
 */
public class Duck extends Animal
{
    public Duck()
    {
        super();
    }
    
    public Duck(String name , double height , int age , int numberOfLegs)
    {
        super(name,height,age,numberOfLegs);
    }
    
    @Override
    public void printVoice()
    {
        System.out.println("QUACK!");
    }
}
