package org.example.payroll;

import org.example.helper.CurrencyFormatter;

import java.util.ArrayList;
import java.util.List;

public class PayrollReport {

    List<PayrollEntry> entries = new ArrayList<>();
    private PayrollSummary payrollSummary;


    public PayrollReport(PayrollSummary payrollSummary) {
        this.payrollSummary = payrollSummary;
    }

    public PayrollReport() {};


    public void addEntry(PayrollEntry entry) {
        entries.add(entry);
    }

    public void printReport() {
        //for loop
        System.out.println("Employee Records:\n");

        for(PayrollEntry entry : entries) {
            System.out.println("Employee Entry:\n");

            System.out.println("Employee Name: " + entry.name());
            System.out.println("Employment type: " + entry.employeeType());
            System.out.println("Employee Gross Pay: " + CurrencyFormatter.format( entry.grossPay() ));
            System.out.println("Employee Tax: " + CurrencyFormatter.format( entry.tax() ));
            System.out.println("Employee Net Pay: " + CurrencyFormatter.format( entry.netPay() ));

            System.out.println("\n\n");
        }

        payrollSummary.printSummary();
    }

    //Default scope - visible only in payroll package
    //So that PayrollProcessor can set it
    void setPayrollSummary(PayrollSummary payrollSummary) {
        this.payrollSummary = payrollSummary;
    }

    public PayrollSummary getPayrollSummary() {
        return this.payrollSummary;
    }

    //Default scope - visible only in payroll package
    //So that PayrollProcessor can set it
    void setEntries(List<PayrollEntry> entries) {
        this.entries = entries;
    }

    public List<PayrollEntry> getEntries() {
        return entries;
    }
}
