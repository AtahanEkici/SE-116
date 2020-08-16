package Staff;

/**
 *
 * @author Atahan Ekici
 */
public class Staff 
{
    private int staffID;
    private String fullName;
    private int age;
    private char gender;
    private String role;
    
    
    public void set_staffID(int staffID)        
    {
        this.staffID = staffID;
    }
    public int get_staffID()
    {
        return this.staffID;
    }
    
     public void set_fullName(String fullName)        
    {
        this.fullName = fullName;
    }
    public String get_fullName()
    {
        return this.fullName;
    }
    
     public void set_age(int age)        
    {
        this.age = age;
    }
    public int get_age()
    {
        return this.age;
    }
    
     public void set_gender(char gender)        
    {
        this.gender = gender;
    }
    public char get_gender()
    {
        return this.gender;
    }
    
    public void set_role(String role)        
    {
        this.role = role;
    }
    public String get_role()
    {
        return this.role;
    }
    
    public void printInfo()
    {
        System.out.println("staffID: " +staffID);
        System.out.println("fullName: " +fullName);
        System.out.println("age: " +age);
        System.out.println("gender: " +gender);
        System.out.println("role: " +role);  
    }
}
