package MidTerm_question1;
import java.util.Scanner;
/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static boolean checkForCourse(Course course)
    {
        if(course.getCourseName().equals("Programming II") && course.getCredits() == 6)
        {
            return true;
        }
        else
        {
            return false;
        }    
    }
    
    
    public static void main(String[] args)
    {
    Scanner scanned;
    Course course1 = new Course();
    Course course2 = new Course("SE116",6);
    
    System.out.println("Please specify the Course's name:");
    scanned = new Scanner(System.in);
    course1.setCourseName(scanned.nextLine());
    
    System.out.println("Please specify the Course's Credit value:");
    scanned = new Scanner(System.in);
    course1.setCredits(scanned.nextInt());
    scanned.close();
    
    course1.display();
    course2.display();
    
    if(checkForCourse(course1) == true)
    {
        System.out.println(course1);
    }
    if(checkForCourse(course2) == true)
    {
         System.out.println(course2);
    }
    else
    {
        System.out.println("No course is found with the name of Programming II and Credits of 6");
    }
    } 
}
