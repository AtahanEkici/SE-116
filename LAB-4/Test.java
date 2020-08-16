package Test;

import Worker.Worker;
import java.util.Scanner;

/**
 *
 * @author ataha
 */
public class Test 
{
    public static void displayWorkersArrayInfo(Worker[] worker)
    {
        for(int i=0;i<worker.length;i++)
        {
            System.out.println("ID: "+worker[i].get_workerID());
            System.out.println("Name: "+worker[i].get_fullName());
           System.out.println("Job: "+worker[i].get_jobDescription());
           System.out.println("Salary: "+worker[i].get_monthlySalary());
        }
    }
    
    public static void displayWorkersArrayInfo_MODIFIED(Worker[] worker)
    {
        for(int i=0;i<worker.length;i++)
        {
            System.out.println("ID: "+worker[i].get_workerID());
            System.out.println("Name: "+worker[i].get_fullName());
           System.out.println("Job: "+worker[i].get_jobDescription());
           System.out.println("Annual Salary: "+worker[i].calculateAnnualIncome());
        }
    }
    
    public static void main(String[] args)
    {
        Scanner scan;
        int scanned;
        Worker[] workersArray;
        
        System.out.println("How many workers do you like to add? :");
        
        scan = new Scanner(System.in);
        scanned = scan.nextInt();
        workersArray = new Worker[scanned];
        
        for(int i=0;i<scanned;i++)
        {
            
            System.out.println("Worker "+i+" out of "+scanned+" : ");
            
            workersArray[i] = new Worker();
            
             System.out.println("Please provide a Worker ID :");
             scan = new Scanner(System.in);
             workersArray[i].set_workerID(scan.nextInt());
             
             System.out.println("Please provide a Worker Name :");
             scan = new Scanner(System.in);
             workersArray[i].set_fullName(scan.nextLine());
             
             System.out.println("Please provide a Worker Montly Salary :");
             scan = new Scanner(System.in);
             workersArray[i].set_monthlySalary(scan.nextDouble());
             
             System.out.println("Please provide a Worker Job Description :");
             scan = new Scanner(System.in);
             workersArray[i].set_jobDescription(scan.nextLine());
             
             System.out.println("Is the worker Penalized true or false :");
             scan = new Scanner(System.in);
             if(scan.nextBoolean() == true)
             {
                 workersArray[i].set_isPenalized(true);
             }
             else
             {
                 workersArray[i].set_isPenalized(false);
             }
        }
        displayWorkersArrayInfo(workersArray);
        
        displayWorkersArrayInfo_MODIFIED(workersArray);
    }
}
