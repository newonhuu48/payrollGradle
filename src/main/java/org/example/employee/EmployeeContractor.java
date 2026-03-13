package org.example.employee;

public class EmployeeContractor extends Employee {
    private double hourlyRate;
    private double hoursWorked;


    //With default tax rate - 20%
    public EmployeeContractor(String name, double hourlyRate, double hoursWorked) {
        super(name);

        //Validation
        if (hourlyRate < 0) throw new IllegalArgumentException("Contractor Employee: Hourly Rate cannot be negative");
        if (hoursWorked < 0) throw new IllegalArgumentException("Contractor Employee: Hours Worked cannot be negative");

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public EmployeeContractor(String name, double taxRate, double hourlyRate, double hoursWorked) {
        super(name, taxRate);

        //Validation
        if (hourlyRate < 0) throw new IllegalArgumentException("Hourly Employee: Hourly Rate cannot be negative");
        if (hoursWorked < 0) throw new IllegalArgumentException("Hourly Employee: Hours Worked cannot be negative");

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }


    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
