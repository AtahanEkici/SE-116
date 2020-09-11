package Lab10;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
/**
 *
 * @author Atahan Ekici
 */
public class RealEstateAgent extends AdvertOwner
{
    private String address;
    private int netWorth;
    
    public RealEstateAgent(String fullName, int id, String contactNumber) 
    {
        super(fullName, id, contactNumber);
    }
    
    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException 
    {
        System.out.println("Address: "+this.address+"\nNet Worth: "+this.netWorth+"\n"+super.print(grphcs, pf, i)+"");
        return 1;
    }
}
