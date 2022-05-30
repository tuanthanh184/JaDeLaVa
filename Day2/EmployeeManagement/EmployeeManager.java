package EmployeeManagement;

import java.util.Scanner;
import java.util.Arrays;

public class EmployeeManager {

  Scanner scanner = new Scanner(System.in);

  Employee[] employees = new Employee[0];

  public void create() {
    int n;
    int countID = 1;
    System.out.print("Input number of employees: ");
    n = scanner.nextInt();
    scanner.nextLine();
    int newArrLength = n + employees.length;
    System.out.println(newArrLength);

    if (newArrLength < 1) {
      System.out.println("Number of employees must be greater than 0");
      return;
    }

    if (n == newArrLength) {
      employees = new Employee[n];
      for (int i = 0; i < n; ++i) {
        employees[i] = new Employee();

        employees[i].setEmpNo("empNo" + Integer.toString(countID++));

        this.setEmployee(i, employees[i]);

        System.out.println(employees[i]);
        System.out.printf("Add success employee %d! \n", i + 1);
      }
    } else {
      Employee[] moreEmployees = new Employee[newArrLength];
      System.out.println(employees.length);
      System.arraycopy(employees, 0,
          moreEmployees, employees.length,
          employees.length);

      for (int i = newArrLength - n; i < newArrLength; ++i) {
        moreEmployees[i] = new Employee();

        moreEmployees[i].setEmpNo("empNo" + Integer.toString(++countID));

        this.setEmployee(i, moreEmployees[i]);

        System.out.println(moreEmployees[i]);
        System.out.printf("Add success employee %d! \n", i + 1);
      }
      employees = moreEmployees;
    }
  }

  public void update() {
    if (employees.length > 0) {
      int id;
      boolean found = false;
      System.out.println("Enter employee ID to update: ");
      id = scanner.nextInt();
      scanner.nextLine();
      for (int i = 0; i < employees.length; i++) {
        if (employees[i].getEmpNo().equals("empNo" + Integer.toString(id))) {
          this.setEmployee(i, employees[i]);
          System.out.printf("Employee ID %d has been updated \n", id);
          System.out.println(employees[i]);
          found = true;
        }
      }
      if (!found) {
        System.out.printf("ID %d was not found \n", id);
      }
    } else {
      System.out.println("Employees list is empty!");
    }
  }

  public void delete() {
    if (employees.length > 0) {
      int id;
      boolean found = false;
      System.out.println("Enter employee ID to delete: ");
      id = scanner.nextInt();
      for (int i = 0; i < employees.length; i++) {
        if (employees[i].getEmpNo().equals("empNo" + Integer.toString(id))) {
          employees[i] = null;
          System.out.printf("Employee ID %d has been deleted \n", id);
          found = true;
        }
      }
      if (!found) {
        System.out.printf("ID %d was not found \n", id);
      }
      Employee[] newEmployees = Arrays.stream(employees)
          .filter(value -> value != null)
          .toArray(size -> new Employee[size]);
      employees = newEmployees;
    } else {
      System.out.println("Employees list is empty!");
    }
  }

  public void display() {
    if (employees.length > 0) {
      System.out.println(employees.length);
      for (Employee employee : employees) {
        System.out.println(employee);
      }
    } else {
      System.out.println("Employees list is empty!");
    }
  }

  public void setEmployee(int index, Employee employee) {
    System.out.printf("Employee %d name: ", index + 1);
    employee.setEmpNm(scanner.nextLine());

    System.out.printf("Employee %d gender: ", index + 1);
    employee.setGender(false, scanner.nextLine());

    System.out.printf("Employee %d address: ", index + 1);
    employee.setAddress(scanner.nextLine());

    System.out.printf("Employee %d email: ", index + 1);
    employee.setEmail(scanner.nextLine());

    System.out.printf("Employee %d phone number: ", index + 1);
    employee.setPhone(scanner.nextLine());

    System.out.printf("Employee %d salary: ", index + 1);
    employee.setSalary(0, scanner.nextLine());

    System.out.printf("Employee %d DOB (dd/MM/yyyy): ", index + 1);
    employee.setDateOfBirth(null, scanner.nextLine());
  }
}
