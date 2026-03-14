package org.example.employee;

import org.example.payroll.PayrollProcessor;


public abstract class Employee {

    private String name;
    private final double taxRate; //Default tax rate
    Enum<EmployeeType> employeeType;


    //With default tax rate - 20%
    public Employee(String name, Enum<EmployeeType> employeeType) {

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Employee: Name cannot be empty or blank!");

        this.name = name;
        this.employeeType = employeeType;


        this.taxRate = PayrollProcessor.TAX_RATE; //Defaults to 0.2 = 20%
    }

    public Employee(String name, Enum<EmployeeType> employeeType, double taxRate) {

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Employee: Name cannot be empty or blank!");

        this.name = name;
        this.employeeType = employeeType;
        this.taxRate = taxRate;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Only getter for TaxRate
    public double getTaxRate() {
        return taxRate;
    }


    public Enum<EmployeeType> getEmployeeType() {
        return employeeType;
    }
}