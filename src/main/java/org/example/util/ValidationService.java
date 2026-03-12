package org.example.util;

import org.example.employee.Employee;

public class ValidationService {

    public static void validateEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("[warn] employee record is null");
            return;
        }

        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            System.out.println("[warn] employee name is missing");
        }

        /*
        if (employee.type == null) {
            System.out.println("[warn] employee type is null for " + safeName(employee));
        }

        if (employee.hourlyRate < 0) {
            System.out.println("[warn] negative hourly rate for " + safeName(employee));
        }

        if (employee.hoursWorked < 0) {
            System.out.println("[warn] negative hours worked for " + safeName(employee));
        }

        if (employee.monthlySalary < 0) {
            System.out.println("[warn] negative monthly salary for " + safeName(employee));
        }
        */
    }

    private static String safeName(Employee employee) {
        if (employee == null || employee.getName() == null || employee.getName().trim().isEmpty()) {
            return "<unknown>";
        }
        return employee.getName();
    }
}

