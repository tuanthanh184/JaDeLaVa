package FootballManager;

public class Player {
  private String playerName;
  private int shirtNumber;
  private int birthYear;
  private String startDate;
  private int playTimeByMin;
  private int goalScore;
  private long basicSalary;
  private long totalBonus;
  private long totalSalary;

  public Player() {
  }

  public Player(String playerName, int shirtNumber, int birthYear, String startDate, int playTimeByMin, int goalScore,
      long basicSalary, long totalBonus, long totalSalary) {
    this.playerName = playerName;
    this.shirtNumber = shirtNumber;
    this.birthYear = birthYear;
    this.startDate = startDate;
    this.playTimeByMin = playTimeByMin;
    this.goalScore = goalScore;
    this.basicSalary = basicSalary;
    this.totalBonus = totalBonus;
    this.totalSalary = totalSalary;
  }

  public String getPlayerName() {
    return this.playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public int getShirtNumber() {
    return this.shirtNumber;
  }

  public void setShirtNumber(int shirtNumber) {
    this.shirtNumber = shirtNumber;
  }

  public int getBirthYear() {
    return this.birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public String getStartDate() {
    return this.startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public int getPlayTimeByMin() {
    return this.playTimeByMin;
  }

  public void setPlayTimeByMin(int playTimeByMin) {
    this.playTimeByMin = playTimeByMin;
  }

  public int getGoalScore() {
    return this.goalScore;
  }

  public void setGoalScore(int goalScore) {
    this.goalScore = goalScore;
  }

  public long getBasicSalary() {
    return this.basicSalary;
  }

  public void setBasicSalary(long basicSalary) {
    this.basicSalary = basicSalary;
  }

  public long getTotalBonus() {
    return this.totalBonus;
  }

  public void setTotalBonus(long totalBonus) {
    this.totalBonus = totalBonus;
  }

  public long getTotalSalary() {
    return this.totalSalary;
  }

  public void setTotalSalary(long totalSalary) {
    this.totalSalary = totalSalary;
  }

  @Override
  public String toString() {
    return "{" +
        " playerName='" + getPlayerName() + "'" +
        ", shirtNumber='" + getShirtNumber() + "'" +
        ", birthYear='" + getBirthYear() + "'" +
        ", startDate='" + getStartDate() + "'" +
        ", playTimeByMin='" + getPlayTimeByMin() + "'" +
        ", goalScore='" + getGoalScore() + "'" +
        ", basicSalary='" + getBasicSalary() + "'" +
        ", totalBonus='" + getTotalBonus() + "'" +
        ", totalSalary='" + getTotalSalary() + "'" +
        "}";
  }

}
