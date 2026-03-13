import org.example.employee.EmployeeContractor;
import org.example.employee.EmployeeHourly;
import org.example.employee.EmployeeSalaried;
import org.example.payroll.PayrollProcessor;
import org.example.payroll.PayrollReport;
import org.example.payroll.PayrollSummary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PayrollSystemUnitTests {
    /*
    @Test
    void testTwoEqualsTwo() {
        // The first 2 is the expected value, the second 2 is the actual value
        assertEquals(2, 2, "Math should work!");
    }
    */


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

    @Test
    void processPayroll_WithNoEmployees_ShouldReturnZeroTotals() {
        PayrollProcessor processor = new PayrollProcessor();

        PayrollReport report = processor.processPayroll();
        PayrollSummary summary = report.getPayrollSummary();

        assertEquals(0.0, summary.getTotalGross(), 0.001, "Gross Pay should be 0 for empty Payroll");
        assertEquals(0.0, summary.getTotalTax(), 0.001, "Total Tax should be 0 for empty Payroll");
        assertEquals(0.0, summary.getTotalNet(), 0.001, "Net Pay should be 0 for empty Payroll");

        assertTrue(report.getEntries().isEmpty(), "Списъкът с записи в репорта трябва да е празен");
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



    @Test
    void netPay_Calculation_IsCorrectAfterTaxAndOvertime() {
        PayrollProcessor processor = new PayrollProcessor();
        EmployeeHourly emp = new EmployeeHourly("John", 10, 200);
        processor.addEmployee(emp);

        PayrollReport report = processor.processPayroll();
        PayrollSummary summary = report.getPayrollSummary();

        double expectedGrossPay = 1600.0 + 600.0;
        double expectedTax = expectedGrossPay * 0.2;
        double expectedNetPay = expectedGrossPay - expectedTax;

        assertEquals(expectedGrossPay, summary.getTotalGross(), 0.001, "Gross Pay should be 2200");
        assertEquals(expectedTax, summary.getTotalTax(), 0.001, "Tax should be 440");
        assertEquals(expectedNetPay, summary.getTotalNet(), 0.001, "Net Pay should be 1760");
    }




    @Test
    void payrollSummary_ShouldAggregateTotalsFromMultipleEmployees() {
        PayrollProcessor processor = new PayrollProcessor();

        EmployeeSalaried alice = new EmployeeSalaried("Alice", 5000.0);
        EmployeeHourly bob = new EmployeeHourly("Bob", 10.0, 25, 100);

        processor.addEmployee(alice);
        processor.addEmployee(bob);

        PayrollReport report = processor.processPayroll();
        PayrollSummary summary = report.getPayrollSummary();

        double expectedTotalGross = 5000.0 + (25.0 * 100.0);
        assertEquals(expectedTotalGross, summary.getTotalGross(), 0.001, "Total Gross should be 5100");
        assertEquals(2, report.getEntries().size(), "There should be 2 Employee Records in the Report");
    }


}
