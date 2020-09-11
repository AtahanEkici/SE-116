package Lab10;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
/**
 *
 * @author Atahan Ekici
 */
public class AdvertOwner implements Printable 
{
    private String fullName;
    private int id;
    private String contactNumber;
    
    public AdvertOwner(String fullName,int id,String contactNumber)
    {
        this.fullName = fullName;
        this.id = id;
        this.contactNumber = contactNumber;
    }
    
    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException 
    {
        System.out.println("Full Name: "+this.fullName+"\nID: "+this.id+"\nNumber: "+this.contactNumber+"");
        return 1;
    }
    
}
