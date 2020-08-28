package MidTerm_question1;
/**
 *
 * @author Atahan Ekici
 */
public class Course
{
    private String CourseName;
    private int Credits;
    
    public Course()
    {
        this.CourseName = "Unknown";
        this.Credits = 0;
    }
    
    public Course(String CourseName,int Credits)
    {
        this.CourseName = CourseName;
        this.Credits = Credits;
        checkCourse();  
    }
    
    public String getCourseName()
    {
        return this.CourseName;
    }
    public void setCourseName(String CourseName)
    {
        this.CourseName = CourseName;
    }
    
    private void checkCourse()
    {
        if(this.Credits < 0)
        {
            System.out.println("\nCredits value is invalid\n");
            this.Credits = 0;
        }
    }
    
    public int getCredits()
    {
        return this.Credits;
    }
    public void setCredits(int Credits)
    {
        this.Credits = Credits;
        checkCourse();
    }
    
    public void display()
    {
        System.out.println(String.format("\n------\nCourse Name: %s\nCredits: %s\n------\n",this.CourseName,this.Credits));
    }

}