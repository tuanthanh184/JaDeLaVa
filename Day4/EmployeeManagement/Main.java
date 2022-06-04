package EmployeeManagement;

public class Main {
  public static void main(String[] args) {
    EmployeeManager employeeManager = new EmployeeManager();
    employeeManager.addEmp();
    employeeManager.findOldestEmployee();
    employeeManager.findTopLowestSalary();
    employeeManager.sortEmployeeByBirthYear();
  }
}