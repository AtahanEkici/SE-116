/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question2;

import java.util.Scanner;

/**
 *
 * @author ataha
 */
public class Status 
{
    public static void reportStatus(Machine m)
    {
        try{
           if(m instanceof Microwawe)
           {
               throw new IllegalAccessException();
               
           }
        }catch(Exception e)
        {
            
        }
        
    }
}
