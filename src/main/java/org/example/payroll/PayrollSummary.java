package org.example.payroll;

import org.example.helper.CurrencyFormatter;

public class PayrollSummary {

    private int salariedCount;
    private int contractorCount;
    private int hourlyCount;
    private int unknownCount;
    private int employeeCount;
    private double totalGross;
    private double totalTax;
    private double totalNet;

    public void recordSalaried(double gross, double tax, double net) {
        salariedCount++;
        employeeCount++;
        totalGross += gross;
        totalTax += tax;
        totalNet += net;
    }

    public void recordContractor(double gross, double tax, double net) {
        contractorCount++;
        employeeCount++;
        totalGross += gross;
        totalTax += tax;
        totalNet += net;
    }

    public void recordHourly(double gross, double tax, double net) {
        hourlyCount++;
        employeeCount++;
        totalGross += gross;
        totalTax += tax;
        totalNet += net;
    }

    public void recordUnknown() {
        unknownCount++;
        employeeCount++;
    }

    public void printSummary() {
        System.out.println("Payroll summary:");
        System.out.println("  Salaried employees count: " + this.getSalariedCount());
        System.out.println("  Contractor employees count: " + this.getContractorCount());
        System.out.println("  Hourly employees count: " + this.getHourlyCount());
        System.out.println("  Unknown employees count: " + this.getUnknownCount());
        System.out.println("  Total Gross Pay: " + CurrencyFormatter.format(this.getTotalGross()));
        System.out.println("  Total Taxes: " + CurrencyFormatter.format(this.getTotalTax()));
        System.out.println("  Total Net Pay: " + CurrencyFormatter.format(this.getTotalNet()));
    }


    public int getSalariedCount() {
        return salariedCount;
    }

    public int getContractorCount() {
        return contractorCount;
    }

    public int getHourlyCount() {return hourlyCount;}

    public int getUnknownCount() {
        return unknownCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public double getTotalGross() {
        return totalGross;
    }

    public double getTotalTax() { return totalTax; }

    public double getTotalNet() {
        return totalNet;
    }
}

