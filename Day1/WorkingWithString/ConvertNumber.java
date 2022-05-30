package WorkingWithString;

import java.util.Scanner;

public class ConvertNumber {
  public void convertNumber() {
    System.out.println("Enter a string number: ");
    String num = new Scanner(System.in).nextLine();

    String newNum = "";

    for (int i = 0; i < num.length(); i++) {
      char character = num.charAt(i);
      if (character == '1') {
        character = '0';
      } else if (character == '0') {
        character = '1';
      }
      newNum = newNum + character;
    }
    System.out.printf("New string number: %s", newNum);
  }
}
