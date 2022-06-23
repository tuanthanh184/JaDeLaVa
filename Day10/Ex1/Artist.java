package Ex1;

public class Artist {
  private String nameArtist;

  public Artist(String nameArtist) {
    this.nameArtist = nameArtist;
  }

  public String getNameArtist() {
    return this.nameArtist;
  }

  public void setNameArtist(String nameArtist) {
    this.nameArtist = nameArtist;
  }

  @Override
  public String toString() {
    return "{" +
        " nameArtist='" + getNameArtist() + "'" +
        "}";
  }

}
