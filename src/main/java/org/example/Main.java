package org.example;

import org.example.employee.EmployeeContractor;
import org.example.employee.EmployeeHourly;
import org.example.employee.EmployeeSalaried;
import org.example.payroll.PayrollProcessor;
import org.example.payroll.PayrollProcessor;
import org.example.payroll.PayrollReport;

public class Main {

    public static void main(String[] args) {

        PayrollProcessor p1 = new PayrollProcessor();
        PayrollReport report;

        //Salaried
        EmployeeSalaried e1 = new EmployeeSalaried("Alice", 5000);

        //Contractor
        EmployeeContractor e2 = new EmployeeContractor("Bob", 50, 160);

        //Contractor
        EmployeeContractor e3 = new EmployeeContractor("Charlie", 60, 0);


        //Breaks the code
        //Throws Exception - Negative hourlyRate and negative hoursWorked
        EmployeeHourly e4 = new EmployeeHourly("", -50, -40);


        p1.addEmployee(e1);
        p1.addEmployee(e2);
        p1.addEmployee(e3);
        p1.addEmployee(e4);


        report = p1.processPayroll();

        report.printReport();
    }
}

