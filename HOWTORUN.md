A large scale refactoring of base payroll repo from PublicIntern2222 has been done

Applied OOP and SOLID principles to make code base correct and scalable

Below is the architecture of the system. Note the refactoring and separation of concerns applied to the Payroll system.

<img width="931" height="643" alt="Payroll System Architecture" src="https://github.com/user-attachments/assets/efe9287d-265e-4fe7-bfc8-e2b2aa2599a6" />

Project Modules:
Employee(Salaried, Contractor, Hourly)
Abstract class Employee follow by it's different implementations. Other possibility for implementing different kinds of Employees is using an Enum but that would lead to Employee containing unneeded data, for example Employee with Enum Salaried would still contain HourlyRate and HoursWorked which is inapplicable

PayrollProcessor
The "brain" of the system it connects all the other payroll-related modules together. Calculation of results delegated as requested. Loops through a List of Employees creates a Java Record for each and meanwhile calculates the PayrollSummary containing the total gross, total taxes and total net for all employees. It finally packages everything into a final structured PayrollReport whose contents can be printed.

PayrollCalculator
The module which calculates gross pay, tax and net pay for an employee, gets their name and employment type, packages everything into a PayrollEntry Java Record and returns it to PayrollProcessor.




How to Run:
Use JDK Amazon Coretto 21 for running the project.

You need to make an instance of PayrollProcessor
Create an instance of PayrollReport as well

Create different types of employees(Salaried, Contractors, Hourly) and initialize them with data

Add employees to PayrollProcessor using payrollProcessor1.addEmployee(employee1) (substitute for variable names)

Execute the statement payrollProcessor1.processPayroll and assign it's value to the instance of PayrollReport for example:
payrollReport1 = payrollProcessor.processPayroll(); (substitute for variable names)

And finally just print the ready report with it's method for example:
payrollReport1.printReport();

This command will print all the employees previously added in the PayrollProcessor - their name, employment type, gross pay, tax and net pay. Additionally it will print the Payroll summary that will list number of employees by contract types. 
