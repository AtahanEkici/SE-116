/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question1;

/**
 *
 * @author ataha
 */
public class Test 
{
    public static void main(String[] args)
    {
        Skater skater = new Skater("Adelina Sotnikova","Russia","ice");
        skater.fill_points();
        skater.setfinal_score();
        skater.display();
    }
}
