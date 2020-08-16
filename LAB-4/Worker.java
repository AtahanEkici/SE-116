package Worker;

/**
 *
 * @author Atahan Ekici
 */
public class Worker 
{
    private int workerID;
    private String fullName;
    private double monthlySalary;
    private String jobDescription;
    private boolean isPenalized;
    
    public Worker()
    {
        this.isPenalized = false; // default //
    }
    
    public int get_workerID()
    {
        return this.workerID;
    }
    public void set_workerID(int workerID)
    {
        this.workerID = workerID;
    }
    
    
    public String get_fullName()
    {
        return this.fullName;
    }
    public void set_fullName(String fullName)
    {
        this.fullName = fullName;
    }
    
    
    public double get_monthlySalary()
    {
        return this.monthlySalary;
    }
    public void set_monthlySalary(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }
    
    
    public String get_jobDescription()
    {
        return this.jobDescription;
    }
    public void set_jobDescription(String jobDescription)
    {
        this.jobDescription = jobDescription;
    }
    
    public boolean get_isPenalized()
    {
        return this.isPenalized;
    }
    public void set_isPenalized(boolean isPenalized)
    {
        this.isPenalized = isPenalized;
    }
    
    public double calculateAnnualIncome()
    {
        if(this.get_isPenalized() == true)
        {
             return (12 * this.monthlySalary * 80 / 100);
        }
        else
        {
            return (12 * this.monthlySalary);
        }  
    }
}
