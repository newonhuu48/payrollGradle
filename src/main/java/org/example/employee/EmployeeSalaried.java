package org.example.employee;

public class EmployeeSalaried extends Employee {

    private double monthlySalary;



    //With default tax rate - 20%
    public EmployeeSalaried(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    public EmployeeSalaried(String name, double taxRate, double monthlySalary) {
        super(name, taxRate);
        this.monthlySalary = monthlySalary;
    }



    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

}

