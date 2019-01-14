/*
 * Arvind Nagabhirava
 * Employee Management System - 2019
 */
package employeemark2;

/**
 *
 * @author ArvindNagabhirava
 */
public class PTE extends EmployeeInfo{
    //Attributes
    private static final long serialVersionUID = -2722972583608119832L;
    
    private double hourlyWage;
    private double hoursPerWeek;
    private double weeksPerYear;

   
    public PTE(int empNum, String firstName, String lastName,int sex, int workLocation, double deductionRate,double hourlyWage, double hoursPerWeek, double weeksPerYear){
    super(empNum,firstName,lastName,sex,workLocation,deductionRate);
    this.hourlyWage = hourlyWage;
    this.hoursPerWeek = hoursPerWeek;
    this.weeksPerYear = weeksPerYear;
        
    }
    //Methods
    
    // Getter Setter Method
    public double getHourlyWage(){
        return hourlyWage; 
   }
    public double getHoursPerWeek(){
        return hoursPerWeek; 
   }
    public double getWeeksPerYear(){
        return weeksPerYear; 
   }
    
    
    public void setHourlyWage(double hrwage){
         hourlyWage = hrwage;
   }
    
    public void setHoursPerWeek(double hrweek){
         hoursPerWeek = hrweek;
   }
    
    public void setWeeksPerYear(double wkyear){
         weeksPerYear = wkyear;
   }
    


}