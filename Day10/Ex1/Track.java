package Ex1;

public class Track {
  private String nameTrack;
  private int viewCount;

  public Track(String nameTrack, int viewCount) {
    this.nameTrack = nameTrack;
    this.viewCount = viewCount;
  }

  public String getNameTrack() {
    return this.nameTrack;
  }

  public void setNameTrack(String nameTrack) {
    this.nameTrack = nameTrack;
  }

  public int getViewCount() {
    return this.viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  @Override
  public String toString() {
    return "{" +
        " nameTrack='" + getNameTrack() + "'" +
        ", viewCount='" + getViewCount() + "'" +
        "}";
  }

}
