package org.example.payroll;

import org.example.employee.Employee;
import org.example.employee.EmployeeContractor;
import org.example.employee.EmployeeHourly;
import org.example.employee.EmployeeSalaried;
import org.example.util.AuditLogger;
import org.example.util.ValidationService;

import java.util.ArrayList;
import java.util.List;

public class PayrollProcessor {

    private List<Employee> employees = new ArrayList<>();

    //Final Result here
    PayrollReport payrollReport = new PayrollReport();


    //Default tax rate used in Employee class and its Subclasses
    //Of course Employees are free to define their own Tax Rate
    public static final double TAX_RATE = 0.2;


    public void addEmployee(Employee e) {
        employees.add(e);
        AuditLogger.logEmployeeAdded(e);
    }

    public PayrollReport processPayroll() {
        PayrollSummary summary = new PayrollSummary();

        AuditLogger.logPayrollStart(employees.size());

        for (Employee e : employees) {
            ValidationService.validateEmployee(e);

            //PayrollCalculator calculate on employee
            //Add result to PayrollReport(end result)
            PayrollEntry entry = PayrollCalculator.calculateEntry(e);

            switch (e) {
                case EmployeeSalaried s ->
                        summary.recordSalaried(entry.grossPay(), entry.tax(), entry.netPay());

                case EmployeeContractor c ->
                        summary.recordContractor(entry.grossPay(), entry.tax(), entry.netPay());

                case EmployeeHourly h ->
                        summary.recordHourly(entry.grossPay(), entry.tax(), entry.netPay());

                default -> {
                    summary.recordUnknown();
                    AuditLogger.logUnknownType(e);
                }
            };

            payrollReport.addEntry(entry);

        }

        payrollReport.setPayrollSummary(summary);

        AuditLogger.logPayrollEnd(summary);

        return payrollReport;
    }


    //Getters and setters
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}