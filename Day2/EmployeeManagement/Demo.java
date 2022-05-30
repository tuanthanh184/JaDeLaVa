package EmployeeManagement;

import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    EmployeeManager employeeManager = new EmployeeManager();
    while (true) {

      System.out.println("Choose an option:");
      System.out.println("1. Add employees");
      System.out.println("2. Edit employees");
      System.out.println("3. Delete employees");
      System.out.println("4. Display employees list");
      System.out.println("5. Exit");

      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          employeeManager.create();
          break;
        case 2:
          employeeManager.update();
          break;
        case 3:
          employeeManager.delete();
          break;
        case 4:
          employeeManager.display();
          break;
        case 5:
          System.exit(0);
          scanner.close();
          break;

        default:
          System.out.println("Invalid choice!");
          break;
      }
    }
  }
}
