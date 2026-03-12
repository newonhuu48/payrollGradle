## 🏗️ Architecture & Design
The system has been redesigned to follow **Separation of Concerns (SoC)** and modern design patterns.

![Payroll System Architecture](https://github.com/user-attachments/assets/efe9287d-265e-4fe7-bfc8-e2b2aa2599a6)

### 1. Employee Model (Hierarchy)
* **Abstract Class `Employee`**: Implements the Open/Closed Principle. 
* **Avoidance of "Fat" Models**: Instead of using Enums (which would force an `Hourly` employee to have `monthlySalary` fields), we use specific implementations:
    * **Salaried**: Handles fixed monthly compensation.
    * **Contractor**: Hourly-based with specific tax rules.
    * **Hourly**: Standard hourly wages and calculation logic.

### 2. PayrollProcessor (The "Brain")
* Coordinates the entire lifecycle of the payroll process.
* **Immutability**: Transforms raw data into **Java Records** for thread-safety and data integrity.
* **Aggregator**: Calculates a `PayrollSummary` (Total Gross, Taxes, and Net).

### 3. PayrollCalculator (Logic Layer)
* A dedicated module for mathematical computations.
* Calculates gross, tax, and net pay per employee type.
* Returns a `PayrollEntry` record, ensuring the logic remains decoupled from the processor.

### 4. ValidationService (The Shield)
* Implements **Pattern Matching for switch** (Java 21).
* **Fail-Fast Approach**: Protects the system from invalid data (negative salaries, null names, or invalid hours) by throwing `IllegalArgumentException`.

---

## ⚙️ How to Run
**Environment:** JDK Amazon Corretto 21.

1. **Initialize the Processor and create an empty Report:**
   ```java
   PayrollProcessor p1 = new PayrollProcessor();
   PayrollReport report;
2. **Create Employees:**
Initialize specific types with your data:

   ```java
   EmployeeSalaried e1 = new EmployeeSalaried("Alice", 5000);
   EmployeeContractor e2 = new EmployeeContractor("Bob", 50, 160);
   EmployeeContractor e3 = new EmployeeContractor("Charlie", 60, 0);
3. **Add Employees to Payroll Processor:**
   ```java
   p1.addEmployee(e1);
   p1.addEmployee(e2);
   p1.addEmployee(e3);

4. **Process Payroll for added Employees**
   ```java
   report = p1.processPayroll();

5. **Print report in readable format**
   ```java
   report.printReport();
