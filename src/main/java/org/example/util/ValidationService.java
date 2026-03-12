package org.example.util;

import org.example.employee.Employee;
import org.example.employee.EmployeeContractor;
import org.example.employee.EmployeeHourly;
import org.example.employee.EmployeeSalaried;

public class ValidationService {

    public static void validateEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("[warn] employee record is null");
            return;
        }

        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            System.out.println("[warn] employee name is missing");
            throw new IllegalArgumentException(
                    "Employee name is mandatory and cannot be empty!");
        }


        switch (employee) {
            case EmployeeSalaried s ->
                    validateEmployee(s);

            case EmployeeContractor c ->
                    validateEmployee(c);

            case EmployeeHourly h ->
                validateEmployee(h);


            default -> {
                AuditLogger.logUnknownType(employee);
                return;
            }
        }

    };


    //EmployeeSalaried validation
    public static void validateEmployee(EmployeeSalaried employeeSalaried) {
        if (employeeSalaried.getMonthlySalary() < 0) {
            System.out.println("[warn] negative monthly salary for " + safeName(employeeSalaried));
            throw new IllegalArgumentException(
                    "Invalid monthly salary (" + employeeSalaried.getMonthlySalary() + ") for: " + employeeSalaried.getName());
        }
    }

    //EmployeeContractor validation
    public static void validateEmployee(EmployeeContractor employeeContractor) {
        if (employeeContractor.getHourlyRate() < 0) {
            System.out.println("[warn] negative hourly rate for " + safeName(employeeContractor));
            throw new IllegalArgumentException(
                    "Invalid hourly rate (" + employeeContractor.getHourlyRate() + ") for: " + employeeContractor.getName());
        }

        if (employeeContractor.getHoursWorked() < 0) {
            System.out.println("[warn] negative hours worked for " + safeName(employeeContractor));
            throw new IllegalArgumentException(
                    "Invalid hours worked (" + employeeContractor.getHoursWorked() + ") for: " + employeeContractor.getName());
        }
    }

    //EmployeeHourly validation
    public static void validateEmployee(EmployeeHourly employeeHourly) {
        if (employeeHourly.getHourlyRate() < 0) {
            System.out.println("[warn] negative hourly rate for " + safeName(employeeHourly));
            throw new IllegalArgumentException(
                    "Invalid hourly rate (" + employeeHourly.getHourlyRate() + ") for: " + employeeHourly.getName());
        }

        if (employeeHourly.getHoursWorked() < 0) {
            System.out.println("[warn] negative hours worked for " + safeName(employeeHourly));
            throw new IllegalArgumentException(
                    "Invalid hours worked (" + employeeHourly.getHoursWorked() + ") for: " + employeeHourly.getName());
        }
    }


    private static String safeName(Employee employee) {
        if (employee == null || employee.getName() == null || employee.getName().trim().isEmpty()) {
            return "<unknown>";
        }
        return employee.getName();
    }

}

