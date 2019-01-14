/*
 * Arvind Nagabhirava
 * Employee Management System - 2019
 */
package employeemark2;

/**
 *
 * @author ArvindNagabhirava
 */
public class FTE extends EmployeeInfo {

    //Attributes
    private double yearlySalary;
    private static final long serialVersionUID = -2722972583608119832L;

    public FTE(int empNum, String firstName, String lastName, int sex, int workLocation, double deductionRate, double yearlySalary) {
        super(empNum, firstName, lastName, sex, workLocation, deductionRate);
        this.yearlySalary = yearlySalary;

    }

    //Method
    //Getter Setter Method
    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setSalary(double salary) {
        yearlySalary = salary;
    }

}
