package StudentManagement;

public class Student {
  private String code;
  private String name;
  private float score1;
  private float score2;
  private float score3;
  private String classification;

  public Student() {
  }

  public Student(String code, String name, float score1, float score2, float score3, String classification) {
    this.code = code;
    this.name = name;
    this.score1 = score1;
    this.score2 = score2;
    this.score3 = score3;
    this.classification = classification;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getScore1() {
    return this.score1;
  }

  public void setScore1(float score1) {
    this.score1 = score1;
  }

  public float getScore2() {
    return this.score2;
  }

  public void setScore2(float score2) {
    this.score2 = score2;
  }

  public float getScore3() {
    return this.score3;
  }

  public void setScore3(float score3) {
    this.score3 = score3;
  }

  public String getClassification() {
    return this.classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public float getAverage() {
    return (this.score1 + this.score2 + this.score3) / 3;
  }

  @Override
  public String toString() {
    return "{" +
        " code='" + getCode() + "'" +
        ", name='" + getName() + "'" +
        ", score1='" + getScore1() + "'" +
        ", score2='" + getScore2() + "'" +
        ", score3='" + getScore3() + "'" +
        ", classification='" + getClassification() + "'" +
        ", average='" + this.getAverage() + "'" +
        "}";
  }

}
