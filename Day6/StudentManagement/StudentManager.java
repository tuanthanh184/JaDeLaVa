package StudentManagement;

import java.io.*;
import java.util.*;

public class StudentManager {
  private ArrayList<Student> students = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  public void addStudent() {
    this.showStudent();

    System.out.println("Numbers of students:");
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      Student student = new Student();

      System.out.println("Student ID:");
      int studentID = scanner.nextInt();
      scanner.nextLine();

      for (Student std : students) {
        while (std.getId() == studentID || studentID == 0) {
          System.out.println("Invalid student ID!");
          System.out.println("Student ID:");
          studentID = scanner.nextInt();
          scanner.nextLine();
        }
      }
      student.setId(studentID);
      this.setStudent(student);

      this.writeFile(student, true);
    }
    System.out.printf("Add successfully %d student(s).", n);
  }

  public void editStudent() {
    this.showStudent();

    System.out.println("Select a student ID to update:");
    int updateID = scanner.nextInt();
    scanner.nextLine();

    for (Student student : students) {
      if (student.getId() == updateID) {
        student.setId(updateID);
        this.setStudent(student);
      }
    }

    this.renderFile();
  }

  public void deleteStudent() {
    this.showStudent();

    System.out.println("Select a student ID to delete:");
    int delID = scanner.nextInt();
    scanner.nextLine();
    boolean isDeleted = students.removeIf(student -> student.getId() == delID);
    if (isDeleted) {
      System.out.printf("Student %d is deleted \n", delID);
    } else {
      System.out.printf("ID %d is not found in student list!", delID);
    }
    this.renderFile();
  }

  public void sortStudentByGPA() {
    this.showStudent();
    Collections.sort(students, new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
        return Float.compare(o1.getGpa(), o2.getGpa());
      }
    });
    this.renderFile();
  }

  public void sortStudentByName() {
    this.showStudent();
    Collections.sort(students, new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
        return (int) o1.getName().compareTo(o2.getName());
      }
    });
    this.renderFile();
  }

  public void showStudent() {
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] arr = line.split(";");
        int i = 0;
        Student student = new Student();
        student.setId(Integer.parseInt(arr[i]));
        student.setName(arr[++i]);
        student.setAge(Integer.parseInt(arr[++i]));
        student.setAddress(arr[++i]);
        student.setGpa(Float.parseFloat(arr[++i]));
        students.add(student);
      }
      bufferedReader.close();
      for (Student student : students) {
        System.out.println(student);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeFile(Student student, boolean append) {
    try {
      FileWriter fileWriter = new FileWriter("student.txt", append);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(student.getId()).append(";").append(student.getName()).append(";").append(student.getAge())
          .append(";").append(student.getAddress()).append(";").append(student.getGpa());
      bufferedWriter.write(stringBuilder.toString());
      bufferedWriter.newLine();
      bufferedWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setStudent(Student student) {
    String name;
    do {
      System.out.println("Student name:");
      name = scanner.nextLine();
    } while (name.length() == 0);
    student.setName(name);

    int age;
    do {
      System.out.println("Student age:");
      age = scanner.nextInt();
      scanner.nextLine();
    } while (age < 0 || age > 100);
    student.setAge(age);

    String address;
    do {
      System.out.println("Student address:");
      address = scanner.nextLine();
    } while (address.length() == 0);
    student.setAddress(address);

    float gpa;
    do {
      System.out.println("Student GPA (scale to 10):");
      gpa = scanner.nextFloat();
      scanner.nextLine();
    } while (gpa < 0 || gpa > 10);
    student.setGpa(gpa);
  }

  public void renderFile() {
    try {
      PrintWriter printWriter = new PrintWriter("student.txt");
      printWriter.write("");
      printWriter.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (Student student : students) {
      System.out.println(student);
      this.writeFile(student, true);
    }
  }
}
