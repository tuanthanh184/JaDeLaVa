package FootballManager;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class PlayerManager {
  private ArrayList<Player> players = new ArrayList<>();

  Scanner scanner = new Scanner(System.in);

  public void calcTotalSalaries() {
    this.readFile("player-raw.dat");
    this.setSalary();

    long totalSalariesOfTeam = 0L;
    for (Player player : players) {
      totalSalariesOfTeam += player.getTotalSalary();
    }
    System.out.println(totalSalariesOfTeam);
  }

  public void findPlayersByScores() {
    this.readFile("player-raw.dat");
    this.setSalary();

    System.out.println("Enter min range:");
    int minRange = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter max range:");
    int maxRange = scanner.nextInt();
    scanner.nextLine();

    if (minRange > maxRange) {
      throw new Error("Invalid range!");
    }

    List<Player> filteredPlayers = players.stream()
        .filter((Player player) -> (player.getGoalScore() >= minRange && player.getGoalScore() <= maxRange))
        .collect(Collectors.toList());

    if (filteredPlayers.size() != 0) {
      System.out.printf("Players who have from %d to %d scores: \n", minRange, maxRange);
      for (Player player : filteredPlayers) {
        System.out.println(player);
      }
    } else {
      System.out.printf("No result");
    }
  }

  public void sortPlayersBySalariesDesc() {
    this.readFile("player-raw.dat");
    this.setSalary();

    players.sort((player1, player2) -> (int) (player2.getTotalSalary() - player1.getTotalSalary()));

    this.writeFile("player-sort.dat", "Players list by salary descending order is sorted!");
  }

  public void updatePlayer() {
    this.readFile("player-raw.dat");
    System.out.println("Select player's shirt number to update:");
    int shirtNumberUpdate = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getShirtNumber() == shirtNumberUpdate) {
        this.setPlayer(players.get(i));
      }
    }
    this.setSalary();

    this.writeFile("player-updated.dat", "Update successfully player " + shirtNumberUpdate);

  }

  public void deletePlayer() {
    this.readFile("player-raw.dat");
    this.setSalary();

    System.out.println("Select player's shirt number to delete:");
    int shirtNumberDel = scanner.nextInt();
    scanner.nextLine();
    boolean isDeleted = players.removeIf((Player player) -> player.getShirtNumber() == shirtNumberDel);

    if (isDeleted) {
      for (Player player : players) {
        System.out.println(player);
      }
    } else {
      System.out.printf("Player %d is not found", shirtNumberDel);
    }

    this.writeFile("player-deleted.dat", "Delete successfully player " + shirtNumberDel);
  }

  public void readFile(String fileName) {
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        String[] arr = line.split(";");
        int i = 0;
        Player player = new Player();
        player.setPlayerName(arr[i]);
        player.setShirtNumber(Integer.parseInt(arr[++i]));
        player.setBirthYear(Integer.parseInt(arr[++i]));
        player.setStartDate(arr[++i]);
        player.setPlayTimeByMin(Integer.parseInt(arr[++i]));
        player.setGoalScore(Integer.parseInt(arr[++i]));
        player.setBasicSalary(Long.parseLong(arr[++i]));
        players.add(player);
      }
      bufferedReader.close();
      System.out.printf("Read successfully file %s", fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeFile(String fileName, String message) {
    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
      for (Player player : players) {
        StringBuilder builder = new StringBuilder();
        builder.append(player.getPlayerName()).append(";").append(player.getShirtNumber()).append(";")
            .append(player.getBirthYear()).append(";").append(player.getStartDate()).append(";")
            .append(player.getPlayTimeByMin()).append(";").append(player.getGoalScore()).append(";")
            .append(player.getTotalSalary()).append(";").append(player.getTotalBonus());
        bufferedWriter.write(builder.toString());
        bufferedWriter.newLine();
      }
      bufferedWriter.close();

      System.out.println(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setPlayer(Player player) {
    final int MIN_BIRTH_YEAR = 1900;
    final int MIN_PLAYER_AGE = 16;
    final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    final int MAX_BIRTH_YEAR = Calendar.getInstance().get(Calendar.YEAR) - MIN_PLAYER_AGE;
    // Player name
    System.out.println("Player name: ");
    String playerName = scanner.nextLine();

    if (playerName.length() == 0) {
      throw new Error("Player name cannot be blank");
    }
    player.setPlayerName(playerName);

    // Player birth year
    System.out.println("Player birth year: ");
    int birthYear = scanner.nextInt();
    scanner.nextLine();
    if (birthYear < MIN_BIRTH_YEAR || birthYear > MAX_BIRTH_YEAR) {
      throw new Error("Birth year should be more than " + MIN_BIRTH_YEAR + " and less than " + (MAX_BIRTH_YEAR + 1));
    }
    player.setBirthYear(birthYear);

    // Player start date
    System.out.println("Player start date: ");
    String startDate = scanner.nextLine();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date dStartDate = null;

    try {
      if (startDate.length() == 0) {
        dStartDate = new Date();
        startDate = dateFormat.format(dStartDate);
      } else {
        dStartDate = dateFormat.parse(startDate);
      }
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(dStartDate);
      int startYear = calendar.get(Calendar.YEAR);
      if (startYear < (MIN_BIRTH_YEAR + MIN_PLAYER_AGE) || startYear > CURRENT_YEAR) {
        throw new Error("Start year should be more than " + (MIN_BIRTH_YEAR +
            MIN_PLAYER_AGE) + " and less than "
            + CURRENT_YEAR);
      }
      player.setStartDate(startDate);
    } catch (Exception e) {
      throw new CustomException("Start date", startDate);
    }

    // Player playtime
    System.out.println("Playtime of player: ");
    int playTimeByMin = scanner.nextInt();
    scanner.nextLine();

    player.setPlayTimeByMin(playTimeByMin);

    // Player goal score
    System.out.println("Player goal score: ");
    int goalScore = scanner.nextInt();
    scanner.nextLine();
    if (goalScore < 0) {
      throw new Error("Goal score cannot be less than 0");
    }
    player.setGoalScore(goalScore);

  }

  public void setSalary() {
    final long BONUS_PER_GOAL_SCORE = 5000000L;
    for (Player player : players) {
      int playTimeByMin = player.getPlayTimeByMin();
      int goalScore = player.getGoalScore();
      long basicSalary = player.getBasicSalary();
      long totalBonus = 0L;
      long totalSalary = 0L;

      if (playTimeByMin <= 100) {
        totalBonus = 10000000L;
      } else if (playTimeByMin <= 500) {
        totalBonus = 50000000L;
      } else {
        totalBonus = 65000000L;
      }
      totalBonus += goalScore * BONUS_PER_GOAL_SCORE;
      totalSalary = basicSalary + totalBonus;

      player.setTotalBonus(totalBonus);
      player.setTotalSalary(totalSalary);

      System.out.println(player);
    }
  }
}
