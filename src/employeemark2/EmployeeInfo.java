/*
 * Arvind Nagabhirava
 * Employee Management System - 2019
 */
package employeemark2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ArvindNagabhirava
 */
public class EmployeeInfo implements Serializable {
    // Attributes

    private int empNum;
    private String firstName;
    private String lastName;
    private int sex;
    private int workLoc;
    private double deductionsRate;
    private static final long serialVersionUID = -2722972583608119832L;



   // Blank Employee
    public EmployeeInfo() {
        empNum = -1; // Bogus employee number!
        firstName = "a";
        lastName = "z";

   }
   // Constructor with Parameters
    public EmployeeInfo(int sN, String fN, String lN, int s, int wLoc, double dRate) {
        empNum = sN;
        firstName = fN;
        lastName = lN;
        sex = s;
        workLoc = wLoc;
        deductionsRate = dRate;
   }


   // Getter Setter Method
    public int getEmployeeNumber(){
        return empNum; 
   }
    public String getFirstName(){
        return firstName; 
   }
    public String getLastName(){
        return lastName; 
   }
    public int getSex(){
        return sex; 
   }
    public int getWorkLocation(){
        return workLoc; 
   }
    public double getDeductionsRate(){
        return deductionsRate; 
   }
    public void setEmployeeNumber(int enumber){
         empNum = enumber;
   }
    public void setFirstName(String fN){
         firstName = fN;
   }
    public void setLastName(String lN){
         lastName = lN;
   }
    public void setSex(int sX){
         sex = sX;
   }    
    public void setWoc(int wL){
       workLoc = wL;
    }
    public void setDeductionRate(double dR){
        deductionsRate = dR;
    }
        //Methods
    public double calcAnnualNetIncome (EmployeeInfo someEmp) {
        if(someEmp instanceof PTE){
            PTE somePTE = (PTE)someEmp;
            double netIncome = (somePTE.getHourlyWage() * somePTE.getHoursPerWeek() * somePTE.getWeeksPerYear()) * ((100 - somePTE.getDeductionsRate())/ 100);
            return netIncome;
        }
        if(someEmp instanceof FTE) {
            FTE someFTE = (FTE)someEmp;
            double netIncome = (someFTE.getYearlySalary()) * ((100 - someFTE.getDeductionsRate())/ 100);
            return netIncome;
        }
    return 0.0;
}
       public static void deserialize(){
       EmployeeInfo someEmp;
       try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<EmployeeInfo> employeeList = (ArrayList<EmployeeInfo>) in.readObject();
            
            
            
            for (EmployeeInfo e: employeeList) {
            LoginPage.getHashTable().addToTable(e);
                
            }
            in.close();
            fileIn.close();
       }
       catch(IOException exc){
       exc.printStackTrace();
   }
       catch(ClassNotFoundException exc){
           System.out.println("Employee Class Not Found");
       }
       
   }
        
       //this function empties out the hashtable into an output file "employee.ser"
       public static void serialize(){
         try {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);            
            out.writeObject(LoginPage.getHashTable().preSerialize(LoginPage.getHashTable()));
            out.close();
            fileOut.close();
            //Serialized data is saved in employee.ser
      } 
         catch (IOException exc) {
         exc.printStackTrace();
      }
           
       
    }
        
    
}
