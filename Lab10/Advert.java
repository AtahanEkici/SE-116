package Lab10;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
/**
 *
 * @author Atahan Ekici
 */
public class Advert implements Printable
{
    private int advertNo;
    private AdvertOwner advertOwner;
    private House house;
    private int price;
    
    public Advert(int advertNo,AdvertOwner advertOwner,House house,int price)
    {
        this.advertNo = advertNo;
        this.advertOwner = advertOwner;
        this.house = house;
        this.price = price;
    }
    
    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException 
    {
        System.out.println("------Advert No: "+this.advertNo+"\nOwner: "+this.advertOwner.print(grphcs, pf, i)+"\nHouse: "+this.house.print(grphcs, pf, i)+"\nPrice: "+this.price+"");
        return 1;
    }
}
