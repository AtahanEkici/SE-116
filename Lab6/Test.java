package Lab6;
/**
 *
 * @author Atahan Ekici
 */
public class Test 
{
    public static boolean Is_Passed(double i)
    {
        if(i >= 60.0)
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
        
    System.out.println(Lecture.get_TotalOfLectures());      
    Lecture SE116 = new Lecture();
    System.out.println(Lecture.get_TotalOfLectures());
    Lecture SE115 = new Lecture();
    System.out.println(Lecture.get_TotalOfLectures());
    
    SE116.set_LectureID(1);
    SE116.set_lectureName("SE116");
    
    SE115.set_LectureID(2);
    SE115.set_lectureName("SE115");
    
    Student Ata = new Student();
    Student Berke = new Student();
    Student Onat = new Student();
    
    Ata.set_ID(1);
    Ata.set_FullName("Atahan Ekici");
    Ata.set_Grade(59);
    
    Berke.set_ID(2);
    Berke.set_FullName("Berke Soyadı1");
    Berke.set_Grade(60);
    
    Onat.set_ID(3);
    Onat.set_FullName("Onat Soyadı2");
    Onat.set_Grade(75);
    
    SE115.add_StudentToList(Ata);
    SE115.add_StudentToList(Berke);
    SE115.add_StudentToList(Onat);
    
    System.out.println("Is Passed:"+Is_Passed(Ata.get_Grade()));
    System.out.println("Is Passed:"+Is_Passed(Berke.get_Grade()));
    System.out.println("Is Passed:"+Is_Passed(Onat.get_Grade()));
    
    Ata.set_Grade(85.0);
    Berke.set_Grade(47.6);
    Onat.set_Grade(59.99);
    
    SE116.add_StudentToList(Ata);
    SE116.add_StudentToList(Berke);
    SE116.add_StudentToList(Onat);
    
    System.out.println("Is Passed:"+Is_Passed(Ata.get_Grade()));
    System.out.println("Is Passed:"+Is_Passed(Berke.get_Grade()));
    System.out.println("Is Passed:"+Is_Passed(Onat.get_Grade()));
    
    }  
}
