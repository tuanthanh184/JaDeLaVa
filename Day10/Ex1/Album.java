package Ex1;

import java.util.List;

public class Album {
  private String nameAlbum;
  private List<Track> tracks;
  private List<Artist> musicians;

  public Album(String nameAlbum, List<Track> tracks, List<Artist> musicians) {
    this.nameAlbum = nameAlbum;
    this.tracks = tracks;
    this.musicians = musicians;
  }

  public String getNameAlbum() {
    return this.nameAlbum;
  }

  public void setNameAlbum(String nameAlbum) {
    this.nameAlbum = nameAlbum;
  }

  public List<Track> getTracks() {
    return this.tracks;
  }

  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

  public List<Artist> getMusicians() {
    return this.musicians;
  }

  public void setMusicians(List<Artist> musicians) {
    this.musicians = musicians;
  }

  @Override
  public String toString() {
    return "Album [musicians=" + musicians + ", nameAlbum=" + nameAlbum + ", tracks=" + tracks + "]";
  }
}
