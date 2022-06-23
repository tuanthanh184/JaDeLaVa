package Ex1;

import java.util.Comparator;
import java.util.List;

public class AlbumManagement {

  public Track getMaxViewCount(List<Album> albums) {
    Track maxTrack = albums.get(0).getTracks().get(0);
    for (int i = 0; i < albums.size(); i++) {
      Track currentTrack = albums.get(i).getTracks().stream().max(Comparator.comparing(Track::getViewCount)).get();
      if (maxTrack.getViewCount() < currentTrack.getViewCount()) {
        maxTrack = currentTrack;
      }
    }
    return maxTrack;
  }

  public Track getMinViewCount(List<Album> albums) {
    Track minTrack = albums.get(0).getTracks().get(0);
    for (int i = 0; i < albums.size(); i++) {
      Track currentTrack = albums.get(i).getTracks().stream().min(Comparator.comparing(Track::getViewCount)).get();
      if (minTrack.getViewCount() > currentTrack.getViewCount()) {
        minTrack = currentTrack;
      }
    }
    return minTrack;
  }

  public long countTracks(List<Album> albums) {
    return albums.stream().reduce(0, (total, album) -> (int) (total + album.getTracks().stream().count()),
        Integer::sum);
  }
}
