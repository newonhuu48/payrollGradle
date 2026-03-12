package org.example.employee;

public class EmployeeHourly extends Employee {
    private double hourlyRate;
    private double hoursWorked;


    //With default tax rate - 20%
    public EmployeeHourly(String name, double hourlyRate, double hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public EmployeeHourly(String name, double taxRate, double hourlyRate, double hoursWorked) {
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
