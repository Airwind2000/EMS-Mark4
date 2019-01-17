/*
 * Arvind Nagabhirava
 * Employee Management System - 2019
 */
package employeemark2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import javax.swing.JTable;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ArvindNagabhirava
 */
public class hashTable {
   private ArrayList<EmployeeInfo>[] buckets; // buckets is the array of ArrayList
   private int contents;
   private int length;


   public hashTable(int modval) {
       // Construct the hash table (open hashing/closed addressing) as an array of modval ArrayLists.

       // Instantiate an array to have an ArrayList as each element of the array.
       buckets = new ArrayList[modval];
       contents = 0;
       length = modval;

       // For each element in the array, instantiate its ArrayList.
       for (int i = 0; i < modval; i++) {
           buckets[i] = new ArrayList();  // Instantiate the ArrayList for bucket i.
       }

   }
//Getter
public int getContents(){
   return contents;
}

   public int calcBucket(int empnum){
       return empnum%buckets.length;
   }



   public void addToTable(EmployeeInfo itemToAdd){
       int bucketnum;
       bucketnum=(calcBucket(itemToAdd.getEmployeeNumber()));
       buckets[bucketnum].add(itemToAdd);
       contents++;
       
   }

// Tools for development: printing contents of one bucket, printing contents of hashtable.  
/*
  
   public void Printer(int x) {
       EmployeeInfo someEmp;
       someEmp = new EmployeeInfo();
       //System.out.println(contents + "yes");
       for (int cntrx = 0; cntrx < buckets[x].size(); cntrx++) {
           someEmp = buckets[x].get(cntrx);
           System.out.println(someEmp.getEmployeeNumber());

       }
   }

   public void PrintLoop(){
       for (int bucketnum = 0; bucketnum < buckets.length; bucketnum++){
           System.out.println("-----------------------");
           Printer(bucketnum);
       }
       System.out.println("-----------------------");
   }
*/
    
    
    public ArrayList nameSearch(String name){
        ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
        EmployeeInfo someEmp;
        someEmp = new EmployeeInfo();
        for (int bucketnum = 0; bucketnum < buckets.length; bucketnum++){
            for (int cntrx = 0; cntrx < buckets[bucketnum].size(); cntrx++){
                someEmp = buckets[bucketnum].get(cntrx);
                if (someEmp.getLastName().equals(name) || (someEmp.getFirstName().equals(name))){
                    list.add(someEmp);
                }
            }
        }
        return list;
    }
   

   public void removeFromTable(int stdNum){
       int bucketnum;
       boolean removed = false;
       bucketnum = calcBucket(stdNum);
       EmployeeInfo someEmp;
       someEmp = new EmployeeInfo();
           for (int cntrx = 0; cntrx < buckets[bucketnum].size(); cntrx++) {
               someEmp = buckets[bucketnum].get(cntrx);
               if (someEmp.getEmployeeNumber() == stdNum) {
                   buckets[bucketnum].remove(someEmp);
                   removed = true;
                   contents--;
               }
           }
       if (removed == false){
       }

   }

   public EmployeeInfo search(int stdNum){
       int bucketnum;
       boolean inTable = false;
       bucketnum = calcBucket(stdNum);
       EmployeeInfo someEmp;
       someEmp = new EmployeeInfo();
           for (int cntrx = 0; cntrx < buckets[bucketnum].size(); cntrx++) {
               someEmp = buckets[bucketnum].get(cntrx);
               if (someEmp.getEmployeeNumber() == stdNum && inTable == false) {

                   inTable = true;
                   return someEmp;
               }

       }
       if (inTable == false){
           return null;
       }
       return null;
   }
   
   
   public ArrayList search (String name){
       ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
        EmployeeInfo someEmp;
        someEmp = new EmployeeInfo();
        for (int bucketnum = 0; bucketnum < buckets.length; bucketnum++){
            for (int cntrx = 0; cntrx < buckets[bucketnum].size(); cntrx++){
                someEmp = buckets[bucketnum].get(cntrx);
                if (someEmp.getLastName().equals(name) || (someEmp.getFirstName().equals(name))){
                    list.add(someEmp);
                }
            }
        }
        return list;
   }
   
   //public EmployeeInfo search(String fN){
       
  // }
   

   
   
   
   
     public boolean inTable(int stdNum){
       int bucketnum;
       boolean inTable = false;
       bucketnum = calcBucket(stdNum);
       EmployeeInfo someEmp;
       someEmp = new EmployeeInfo();
       for (int i = 0; i < buckets[bucketnum].size(); i++) {
           for (int cntrx = 0; cntrx < buckets[bucketnum].size(); cntrx++) {
               someEmp = buckets[bucketnum].get(cntrx);
               if (someEmp.getEmployeeNumber() == stdNum && inTable == false) {
                   return true;
               }
           }
       }
       if (inTable == false){
           return false;
       }
       return false;
   }
     //Tuning algorhythm, unused in this project. However, the tuning algorhythm makes the hashtable more efficient by finding 
     //the point at which number of buckets and length of buckets is most efficient and shaped theoretically like a "square"
   public void squareTune(hashTable originalTable) {
       EmployeeInfo someEmp;
       int sqnum = (int)Math.round(java.lang.Math.sqrt(originalTable.getContents()));
       hashTable squareTable = new hashTable(sqnum);
       for (int bucket = 0; bucket < buckets.length; bucket++){
           for (int i = 0; i < buckets[bucket].size(); i++) {
               someEmp = buckets[bucket].get(i);
               squareTable.addToTable(someEmp);
           }
       }


   }
   
public ArrayList<EmployeeInfo> preSerialize(hashTable originalTable){
       EmployeeInfo someEmp;
       ArrayList<EmployeeInfo> fullList=new ArrayList<>();
       for (int bucket = 0; bucket < buckets.length; bucket++){
           for (int i = 0; i < buckets[bucket].size(); i++) {
               someEmp = buckets[bucket].get(i);
               fullList.add(someEmp);
           }
       }
       return fullList;

}

    public void fillTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < length; i++) {

            if (buckets[i].isEmpty()) {
                continue;
            }

            for (int n = 0; n < buckets[i].size(); n++) {
                if (buckets[i].get(n) instanceof PTE) {
                    PTE emp = (PTE) buckets[i].get(n);
                    double salary;
                    if (emp.getDeductionsRate()== 0) {
                        salary = (emp.getHourlyWage() * emp.getHoursPerWeek() * emp.getWeeksPerYear());
                    } else {
                        salary = emp.calcAnnualNetIncome(emp);
                        salary = (java.lang.Math.round(salary * 100) / 100.0);
                    }
                    model.addRow(new Object[]{emp.getFirstName(), emp.getLastName(), emp.getEmployeeNumber(), "Part Time", salary});
                } else if (buckets[i].get(n) instanceof FTE) {
                    FTE emp = (FTE) buckets[i].get(n);
                    double salary;
                    if (emp.getDeductionsRate()== 0) {
                        salary = (emp.getYearlySalary());
                    } else {
                        salary = emp.calcAnnualNetIncome(emp);
                        salary = (java.lang.Math.round(salary * 100) / 100.0);
                    }
                    model.addRow(new Object[]{emp.getFirstName(), emp.getLastName(), emp.getEmployeeNumber(), "Full Time", salary});
                } else {
                    //Silence
                }
            }
        }
    }

   

  
}






