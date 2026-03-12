package org.example.util;

import org.example.employee.Employee;
import org.example.helper.CurrencyFormatter;
import org.example.payroll.PayrollSummary;

public class AuditLogger {

    public static void logEmployeeAdded(Employee employee) {
        System.out.println("[audit] employee added: " + safeName(employee));
    }

    public static void logPayrollStart(int employeeCount) {
        System.out.println("[audit] payroll run started for " + employeeCount + " employees");
    }

    public static void logPayrollEnd(PayrollSummary summary) {
        System.out.println("[audit] payroll run finished: " + summary.getEmployeeCount() + " employees processed");
    }

    public static void logUnknownType(Employee employee) {
        System.out.println("[audit] unknown employee type: " + safeType(employee));
    }

    public static void logPayComputed(Employee employee, double pay) {
        System.out.println("[audit] pay computed for " + safeName(employee) + ": " + CurrencyFormatter.format(pay));
    }

    private static String safeName(Employee employee) {
        if (employee == null || employee.getName() == null || employee.getName().trim().isEmpty()) {
            return "<unknown>";
        }
        return employee.getName();
    }

    private static String safeType(Employee employee) {
        if (employee == null) {
            return "<null>";
        }
        return employee.getClass().getSimpleName().replace("Employee", "");
    }
}

