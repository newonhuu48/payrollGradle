import org.example.employee.EmployeeContractor;
import org.example.employee.EmployeeHourly;
import org.example.employee.EmployeeSalaried;
import org.example.payroll.PayrollProcessor;
import org.example.payroll.PayrollReport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeUnitTests {

    //Hourly Employee Invalid
    @Test
    void hourlyEmployee_WithNegativeHourlyRate_ShouldThrowException() {

        assertThrows(IllegalArgumentException.class, () -> {
            new EmployeeHourly("Ivan", -50, 50);
        }, "Hourly Employee: Hourly Rate cannot be negative!");
    }

    @Test
    void hourlyEmployee_WithNegativeHoursWorked_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmployeeHourly("Ivan", 50, -50);
        }, "Hourly Employee: Hours Worked cannot be negative!");
    }


    //Contractor Employee Invalid
    @Test
    void contractorEmployee_WithNegativeHourlyRate_ShouldThrowException() {

        assertThrows(IllegalArgumentException.class, () -> {
            new EmployeeContractor("Ivan", -50, 50);
        }, "Contractor Employee: Hourly Rate cannot be negative!");
    }

    @Test
    void contractorEmployee_WithNegativeHoursWorked_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmployeeHourly("Ivan", 50, -50);
        }, "Contractor Employee: Hours Worked cannot be negative!");
    }

    @Test
    void employee_WithEmptyName_ShouldThrowException() {
        // Assert & Act
        assertThrows(IllegalArgumentException.class, () -> {
            // Опитваме да създадем служител с празно име
            new EmployeeSalaried("", 8500);
        }, "Employee name cannot be empty!");
    }

    @Test
    void employee_WithBlankName_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Опитваме да създадем служител с празно име
            new EmployeeSalaried("     ", 8500);
        }, "Employee name cannot be blank!");
    }


    //Employee Overtime calculation
    @Test
    void hourlyEmployee_OvertimeCalculation_IsCorrect() {
        PayrollProcessor processor = new PayrollProcessor();
        EmployeeHourly emp = new EmployeeHourly("Ivan", 30, 200);
        processor.addEmployee(emp);

        PayrollReport report = processor.processPayroll();

        double expectedGross = 6600.0;
        assertEquals(expectedGross, report.getPayrollSummary().getTotalGross(), 0.001, "Gross Pay should be 6600");

    }

    @Test
    void contractorEmployee_OvertimeCalculation_IsCorrect() {
        PayrollProcessor processor = new PayrollProcessor();
        EmployeeContractor emp = new EmployeeContractor("Ivan", 30, 200);
        processor.addEmployee(emp);

        PayrollReport report = processor.processPayroll();

        double expectedGross = 6600.0;
        assertEquals(expectedGross, report.getPayrollSummary().getTotalGross(), 0.001);
    }
}
