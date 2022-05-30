package StudentManagement;

import java.util.Scanner;

public class StudentDemo {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String code = "";
    String name = "";
    String scoreInput1 = "";
    String scoreInput2 = "";
    String scoreInput3 = "";
    float score1 = 0;
    float score2 = 0;
    float score3 = 0;
    String classification = "";

    System.out.println("Nhap ma hoc sinh: ");
    code = scanner.nextLine();
    System.out.println("Nhap ten hoc sinh: ");
    name = scanner.nextLine();
    System.out.println("Nhap diem thu nhat cua hoc sinh: ");
    scoreInput1 = scanner.nextLine();
    System.out.println("Nhap diem thu hai cua hoc sinh: ");
    scoreInput2 = scanner.nextLine();
    System.out.println("Nhap diem thu ba cua hoc sinh: ");
    scoreInput3 = scanner.nextLine();
    System.out.println("Nhap thu hang hoc sinh: ");
    classification = scanner.nextLine();

    scanner.close();

    try {
      score1 = Float.parseFloat(scoreInput1);
      score2 = Float.parseFloat(scoreInput2);
      score3 = Float.parseFloat(scoreInput3);
    } catch (NumberFormatException e) {
      throw new NumberFormatException("Ban phai nhap kieu du lieu la so!!!");

    }
    Student student = new Student();
    student.setCode(code);
    student.setName(name);
    student.setScore1(score1);
    student.setScore2(score2);
    student.setScore3(score3);
    student.setClassification(classification);
    System.out.println(student);
  }
}
