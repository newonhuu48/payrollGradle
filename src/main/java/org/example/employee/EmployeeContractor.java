package org.example.employee;

public class EmployeeContractor extends Employee {
    private double hourlyRate;
    private double hoursWorked;


    //With default tax rate - 20%
    public EmployeeContractor(String name, double hourlyRate, double hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public EmployeeContractor(String name, double taxRate, double hourlyRate, double hoursWorked) {
        super(name, taxRate);
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
