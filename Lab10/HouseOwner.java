package Lab10;
/**
 *
 * @author Atahan Ekici
 */
public class HouseOwner extends AdvertOwner
{   
    private int age;
    private char gender;
    private String occupation;
    
    public HouseOwner(int age,char gender,String occupation,String fullName, int id, String contactNumber) 
    {
        super(fullName, id, contactNumber);
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        genderChecker(gender);
    }
    
    public void setGender(char gender)
    {
        this.gender = gender;
    }
    
    private void genderChecker(char a)
    {
        if(a != 'F' || a != 'M')
        {
            System.out.println("Gender Must be M or F");
            this.setGender('M');
        }
    }
}
