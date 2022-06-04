package EmployeeManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManager {
  private ArrayList<Employee> employees = new ArrayList<>();

  Scanner scanner = new Scanner(System.in);

  public void addEmp() {

    final int MIN_BIRTH_YEAR = 1900;
    final int MIN_EMPLOYEE_AGE = 18;
    final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    final int MAX_BIRTH_YEAR = Calendar.getInstance().get(Calendar.YEAR) - MIN_EMPLOYEE_AGE;
    final int BASIC_SALARY = 1150000;

    System.out.println("Insert number of employees: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < n; i++) {
      Employee employee = new Employee();

      System.out.println("Employee ID: ");
      String empID = scanner.nextLine();
      for (Employee emp : employees) {
        if (emp.getEmpID().equals(empID)) {
          throw new Error("ID " + empID + " is already existed");
        }
      }
      employee.setEmpID(empID);

      System.out.println("Employee name: ");
      String empName = scanner.nextLine();

      if (empName.length() == 0) {
        throw new Error("Employee name cannot be blank");
      }
      employee.setEmpName(empName);

      System.out.println("Employee birth year: ");
      int empBirthYear = scanner.nextInt();
      scanner.nextLine();
      if (empBirthYear < MIN_BIRTH_YEAR || empBirthYear > MAX_BIRTH_YEAR) {
        throw new Error("Birth year should be more than " + MIN_BIRTH_YEAR + " and less than " + (MAX_BIRTH_YEAR + 1));
      }
      employee.setEmpBirthYear(empBirthYear);

      System.out.println("Employee gender (male: 0, female: 1, other: 2): ");
      int empGender = scanner.nextInt();
      scanner.nextLine();
      String empGenderInput = "";
      switch (empGender) {
        case 0:
          empGenderInput = "male";
          break;
        case 1:
          empGenderInput = "female";
          break;
        case 2:
          empGenderInput = "other";
          break;
        default:
          empGenderInput = "unknown";
          break;
      }
      employee.setGender(empGenderInput);

      System.out.println("Employee start date: ");
      String sStartDate = scanner.nextLine();
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      Date startDate = null;
      try {
        startDate = dateFormat.parse(sStartDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int startYear = calendar.get(Calendar.YEAR);
        if (startYear < (MIN_BIRTH_YEAR + MIN_EMPLOYEE_AGE) || startYear > CURRENT_YEAR) {
          throw new Error("Start year should be more than " + (MIN_BIRTH_YEAR +
              MIN_EMPLOYEE_AGE) + " and less than "
              + CURRENT_YEAR);
        }
        employee.setStartDate(startDate);
      } catch (Exception e) {
        throw new CustomException("Start date", sStartDate);
      }

      System.out.println("Employee coeff salary: ");
      float coeff = scanner.nextFloat();
      scanner.nextLine();
      if (coeff < 0) {
        throw new Error("Coefficients salary cannot be less than 0");
      }
      float salary = coeff * BASIC_SALARY;
      employee.setCoeff(coeff);
      employee.setSalary(salary);

      employees.add(employee);
    }
    System.out.println(employees);
  }

  public void findOldestEmployee() {
    if (employees.size() < 0) {
      System.out.println("Employees list is empty!");
    }
    Employee oldestEmployee = employees.stream()
        .max((emp1, emp2) -> emp2.getEmpBirthYear() - emp1.getEmpBirthYear()).get();
    System.out.println("The oldest employee is:");
    System.out.println(oldestEmployee);
  }

  public void findTopLowestSalary() {
    System.out.println("Number of top lowest salary: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    if (n > employees.size()) {
      throw new Error(n + " is out of range of employee list");
    }

    this.employees.sort((emp1, emp2) -> (int) (emp1.getSalary() - emp2.getSalary()));
    System.out.printf("Top %d lowest salary: ", n);
    for (int i = 0; i < n; i++) {
      System.out.println(employees.get(i));
    }
  }

  public void sortEmployeeByBirthYear() {
    if (employees.size() == 0) {
      System.out.println("Employee list is empty!");
    }
    this.employees.sort((emp1, emp2) -> (emp1.getEmpBirthYear() - emp2.getEmpBirthYear()));
    System.out.println("Employee list sorted by birth year:");
    for (int i = 0; i < employees.size(); i++) {
      System.out.println(employees.get(i));
    }
  }
}
