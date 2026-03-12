package org.example.payroll;

public record PayrollEntry(
        String name,
        String employeeType,
        double grossPay,
        double tax,
        double netPay
) {}