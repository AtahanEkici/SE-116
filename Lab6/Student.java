package Lab6;
/**
 *
 * @author Atahan Ekici
 */
public class Student 
{
    private int ID;
    private String fullName;
    private double grade;
    
    public Student(int ID,String fullName,double grade)
    {
        this.ID = ID;
        this.fullName = fullName;
        this.grade = grade;
    }
    
    public Student()
    {
        this.ID = 1;
        this.fullName = "Unknown";
        this.grade = 0.0;
    }
    
    public int get_ID()
    {
        return this.ID;
    }
    public void set_ID(int ID)
    {
        this.ID = ID;
    }
    
    public String get_FullName()
    {
        return this.fullName;
    }
    public void set_FullName(String fullName)
    {
        this.fullName = fullName;
    }
    
    public double get_Grade()
    {
        return this.grade;
    }
    public void set_Grade(double grade)
    {
        this.grade = grade;
    }
    
    public void printInfo()
    {
        System.out.println(String.format("ID: %s\nFull Name: %s\nGrade: %s\n-----------------",this.ID,this.fullName,this.grade));
    }
}
