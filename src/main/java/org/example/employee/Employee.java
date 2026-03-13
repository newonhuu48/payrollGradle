package org.example.employee;

import org.example.payroll.PayrollProcessor;


public abstract class Employee {

    private String name;
    private final double taxRate; //Default tax rate


    //With default tax rate - 20%
    public Employee(String name) {
        this.name = name;

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Employee: Name cannot be empty or blank!");

        this.taxRate = PayrollProcessor.TAX_RATE; //Defaults to 0.2 = 20%
    }

    public Employee(String name, double taxRate) {
        this.name = name;
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

}