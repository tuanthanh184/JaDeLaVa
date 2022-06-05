package FootballManager;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class PlayerManager {
  private ArrayList<Player> players = new ArrayList<>();

  Scanner scanner = new Scanner(System.in);

  public void addPlayer() {

    System.out.println("Insert number of players: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < n; i++) {
      Player player = new Player();
      this.setPlayer(player);
    }
    this.writeFile("Saved successfully " + n + " records");
  }

  public void calcTotalSalaries() {
    this.readFile();

    long totalSalaries = 0L;
    for (Player player : players) {
      totalSalaries += player.getSalary();
    }
    System.out.println(totalSalaries);
  }

  public void findPlayersByScores() {
    this.readFile();
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
      System.out.printf("Players who have from %d to %d scores:", minRange, maxRange);
      for (Player player : filteredPlayers) {
        System.out.println(player);
      }
    } else {
      System.out.printf("No result");
    }
  }

  public void sortPlayersBySalariesDesc() {
    this.readFile();

    players.sort((player1, player2) -> (int) (player2.getSalary() - player1.getSalary()));

    this.writeFile("Players list by salary descending order is sorted!");
  }

  public void updatePlayer() {
    this.readFile();
    System.out.println("Select player's shirt number to update:");
    int shirtNumberUpdate = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getShirtNumber() == shirtNumberUpdate) {
        this.setPlayer(players.get(i));
        players.remove(i);
      }
    }

    this.writeFile("Update successfully player " + shirtNumberUpdate);
  }

  public void deletePlayer() {
    this.readFile();

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

    this.writeFile("Delete successfully player " + shirtNumberDel);
  }

  public void readFile() {
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("player.dat"));
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
        player.setSalary(Long.parseLong(arr[++i]));
        players.add(player);
      }
      bufferedReader.close();
      System.out.println(players);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeFile(String message) {
    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("player.dat"));
      for (Player player : players) {
        StringBuilder builder = new StringBuilder();
        builder.append(player.getPlayerName()).append(";").append(player.getShirtNumber()).append(";")
            .append(player.getBirthYear()).append(";").append(player.getStartDate()).append(";")
            .append(player.getPlayTimeByMin()).append(";").append(player.getGoalScore()).append(";")
            .append(player.getSalary());
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
    final long BONUS_PER_GOAL_SCORE = 5000000L;
    // Player name
    System.out.println("Player name: ");
    String playerName = scanner.nextLine();

    if (playerName.length() == 0) {
      throw new Error("Player name cannot be blank");
    }
    player.setPlayerName(playerName);

    // Player shirt number
    System.out.println("Player shirt number: ");
    int shirtNumber = scanner.nextInt();
    scanner.nextLine();
    if (shirtNumber < 1 || shirtNumber > 99) {
      throw new Error("Invalid shirt number");

    }
    for (Player footballPlayer : players) {
      if (footballPlayer.getShirtNumber() == shirtNumber) {
        throw new Error("Shirt number " + shirtNumber + " is already existed");
      }
    }
    player.setShirtNumber(shirtNumber);

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

    long salary = 0L;

    if (playTimeByMin < 0) {
      throw new Error("Playtime cannot be less than 0");
    } else if (playTimeByMin <= 100) {
      salary = 10000000L;
    } else if (playTimeByMin <= 500) {
      salary = 50000000L;
    } else {
      salary = 65000000L;
    }
    player.setPlayTimeByMin(playTimeByMin);

    // Player goal score
    System.out.println("Player goal score: ");
    int goalScore = scanner.nextInt();
    scanner.nextLine();
    if (goalScore < 0) {
      throw new Error("Goal score cannot be less than 0");
    }
    player.setGoalScore(goalScore);

    salary += goalScore * BONUS_PER_GOAL_SCORE;
    player.setSalary(salary);

    players.add(player);
  }
}
