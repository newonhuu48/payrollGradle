package org.example.payroll;

import org.example.employee.Employee;
import org.example.employee.EmployeeContractor;
import org.example.employee.EmployeeHourly;
import org.example.employee.EmployeeSalaried;

public class PayrollCalculator {

    private static final double OVERTIME_THRESHOLD = 160.0;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    /*
    public static double calculateHourlyGross(double rate, double hours) {

        double regularPay = Math.min(hours, OVERTIME_THRESHOLD) * rate;
        double overtimePay = Math.max(0, hours - OVERTIME_THRESHOLD) * rate * OVERTIME_MULTIPLIER;

        return regularPay + overtimePay;
    }

    public static PayrollResult calculate(Employee employee) {
        double gross = employee.calculateGrossPay();
        double tax = gross * employee.getTaxRate();
        double net = gross - tax;
        return new PayrollResult(employee.getName(), gross, tax, net);
    }
    */



    private static double calculateGrossPay(EmployeeSalaried e) {
        double grossPay = e.getMonthlySalary();

        return grossPay;
    }

    private static double calculateGrossPay(EmployeeContractor e) {
        double rate = e.getHourlyRate();
        double hours = e.getHoursWorked();

        double regularPay = Math.min(hours, OVERTIME_THRESHOLD) * rate;
        double overtimePay = Math.max(0, hours - OVERTIME_THRESHOLD) * rate * OVERTIME_MULTIPLIER;

        return regularPay + overtimePay;
    }


    private static double calculateGrossPay(EmployeeHourly e) {
        double rate = e.getHourlyRate();
        double hours = e.getHoursWorked();

        double regularPay = Math.min(hours, OVERTIME_THRESHOLD) * rate;
        double overtimePay = Math.max(0, hours - OVERTIME_THRESHOLD) * rate * OVERTIME_MULTIPLIER;

        return regularPay + overtimePay;
    }




    public static PayrollEntry calculateEntry(Employee e) {

        String name = e.getName();
        String type = e.getClass().getSimpleName().replace("Employee", "");


        double grossPay = switch (e) {
            case EmployeeSalaried s -> calculateGrossPay(s);
            case EmployeeContractor c -> calculateGrossPay(c);
            case EmployeeHourly h -> calculateGrossPay(h);
            default -> throw new IllegalArgumentException("Error: Unknown Employee Type!");
        };

        double taxRate = e.getTaxRate();


        double tax = grossPay * taxRate;
        double netPay = grossPay - tax;


        return new PayrollEntry(name, type, grossPay, tax, netPay);
    }




    private static double calculateUnusedBonus(EmployeeSalaried e) {
        double bonus = 0.05 * e.getMonthlySalary();
        return bonus;
    }

    private static double calculateUnusedBonus(EmployeeContractor e) {
        double bonus = 0.05 *  e.getHourlyRate() * e.getHoursWorked();
        return bonus;
    }

    private static double calculateUnusedBonus(EmployeeHourly e) {
        double bonus = 0.05 *  e.getHourlyRate() * e.getHoursWorked();
        return bonus;
    }


}
