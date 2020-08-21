package Lab6;

import java.util.ArrayList;

/**
 *
 * @author Atahan Ekici
 */
public class Lecture extends Student
{
    private ArrayList<Student> studentList;
    private int lectureID;
    private String lectureName;
    static int numberOfLectures;
    
    public Lecture(int lectureID,String lectureName)
    {
        this.lectureID = lectureID;
        this.lectureName = lectureName;
        studentList = new ArrayList<>();
        numberOfLectures++;
    }
    
    public Lecture()
    {
        this.lectureID = 1;
        this.lectureName = "Default";
        studentList = new ArrayList<>();
        numberOfLectures++;
    }
    
    public int get_LectureID()
    {
        return this.lectureID;
    }
    public void set_LectureID(int lectureID)
    {
        this.lectureID = lectureID;
    }
    
    public String get_lectureName()
    {
        return this.lectureName;
    }
    public void set_lectureName(String lectureName)
    {
        this.lectureName = lectureName;
    }
    
    public void add_StudentToList(Student S)
    {
        this.studentList.add(S);
    }
    public void get_AllStudents()
    {
        System.out.println(this.studentList.toString());
    }
    
    public static int get_TotalOfLectures()
    {
        return Lecture.numberOfLectures;
    }

}
