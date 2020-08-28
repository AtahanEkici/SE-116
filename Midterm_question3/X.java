package Midterm_question3;
/**
 *
 * @author Atahan Ekici
 */
public class X extends Y
{
    private int data3;
    
    public X(int data1, double data2, int data3) 
    {
       super(data1,data2);
       this.data3 = data3;
    }
    
    @Override
    public void print()
    {
        super.print();
        System.out.println("Third data: " + this.data3);
    }
}
