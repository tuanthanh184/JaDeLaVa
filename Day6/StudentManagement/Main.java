package StudentManagement;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    StudentManager studentManager = new StudentManager();
    Scanner scanner = new Scanner(System.in);

    int choice;

    System.out.println("1. Add student.");
    System.out.println("2. Edit student by ID.");
    System.out.println("3. Delete student by ID.");
    System.out.println("4. Sort student by GPA.");
    System.out.println("5. Sort student by name.");
    System.out.println("6. Show student.");
    System.out.println("0. Exit.");
    System.out.println("Enter your choice:");
    choice = scanner.nextInt();

    switch (choice) {
      case 1:
        studentManager.addStudent();
        break;
      case 2:
        studentManager.editStudent();
        break;
      case 3:
        studentManager.deleteStudent();
        break;
      case 4:
        studentManager.sortStudentByGPA();
        break;
      case 5:
        studentManager.sortStudentByName();
        break;
      case 6:
        studentManager.showStudent();
        break;
      case 0:
        scanner.close();
        System.exit(1);
        break;

      default:
        System.out.println("Invalid choice! \n");
    }
  }
}
