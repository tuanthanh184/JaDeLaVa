package FootballManager;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    PlayerManager playerManager = new PlayerManager();

    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("\n");
      System.out.println("1. Add players");
      System.out.println("2. Calculate total salaries");
      System.out.println("3. Find Players by scores");
      System.out.println("4. Sort players by salaries");
      System.out.println("5. Update player");
      System.out.println("6. Delete player");
      System.out.println("7. Exit");
      System.out.println("Choose an option:");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          playerManager.addPlayer();
          break;
        case 2:
          playerManager.calcTotalSalaries();
          break;
        case 3:
          playerManager.findPlayersByScores();
          break;
        case 4:
          playerManager.sortPlayersBySalariesDesc();
          break;
        case 5:
          playerManager.updatePlayer();
          break;
        case 6:
          playerManager.deletePlayer();
          break;
        case 7:
          System.exit(1);
          scanner.close();
          break;
        default:
          throw new Error("Invalid choice");
      }
    } while (true);
  }
}
