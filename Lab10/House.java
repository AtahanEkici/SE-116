package Lab10;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
/**
 *
 * @author Atahan Ekici
 */
public class House implements Printable
{
    private String rooms;
    private int floor;
    private int areaInSquareMeters;
    private String address;
    
    public House(String rooms,int floor,int areaInSquareMeters,String address)
    {
        this.rooms = rooms;
        this.floor = floor;
        this.areaInSquareMeters = areaInSquareMeters;
        this.address = address;
    }
    
    public String getRooms()
    {
        return this.rooms;
    }
    
    public int getFloor()
    {
        return this.floor;
    }
    
    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException
    {
        System.out.println("Rooms: "+this.rooms+"\nFloor: "+this.floor+"\nArea: "+this.areaInSquareMeters+"\nAddress: "+this.address+"");
        return 1;
    }
}