package org.example.payroll;

import org.example.employee.EmployeeType;

public record PayrollEntry(
        String name,
        Enum<EmployeeType> employeeType,
        double grossPay,
        double tax,
        double netPay
) {}