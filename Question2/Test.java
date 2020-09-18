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
public class Test
{
    public static void main()
    {
    String temp = "init";
    Scanner scan;
    boolean done = false;
    
    try
    {
       while(temp.matches("x") == false)
    {
        switch(temp)
        {
            case "w":
                WashingMachine w = new WashingMachine();
                
            case "r":
                
            case "m":
                
            case "x":
                System.exit(1);
                break;
        }
    } 
    }catch(Exception e)
    {
        if(e instanceof IllegalAccessException)
        {
            System.out.println(e.getMessage());
        }
    }
    
    }  
}
