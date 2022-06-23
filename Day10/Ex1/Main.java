package Ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    AlbumManagement albumManagement = new AlbumManagement();
    List<Album> albums = new ArrayList<>();
    List<Artist> artists = new ArrayList<>();
    List<Track> tracks = new ArrayList<>();

    Track track11 = new Track("song1", 150000);
    Track track12 = new Track("song2", 12000);
    Track track13 = new Track("song3", 130);
    Track track14 = new Track("song4", 1500);
    Track track15 = new Track("song5", 12300);

    tracks.add(track11);
    tracks.add(track12);
    tracks.add(track13);
    tracks.add(track14);
    tracks.add(track15);

    Artist artist11 = new Artist("Thawmisntme");
    Artist artist12 = new Artist("Thawmisme");

    artists.add(artist11);
    artists.add(artist12);

    Album album1 = new Album("Tung Duong Hat Tinh Ca", tracks, artists);

    Track track21 = new Track("song1", 150000);
    Track track22 = new Track("song2", 12000);
    Track track23 = new Track("song3", 130);
    Track track24 = new Track("song4", 1500);
    Track track25 = new Track("song5", 12300);

    tracks.add(track21);
    tracks.add(track22);
    tracks.add(track23);
    tracks.add(track24);
    tracks.add(track25);

    Artist artist21 = new Artist("Anti-Thawmisntme");
    Artist artist22 = new Artist("Anti-Thawmisme");

    artists.add(artist21);
    artists.add(artist22);

    Album album2 = new Album("Tung Ca Hat Tinh Duong", tracks, artists);

    albums.add(album1);
    albums.add(album2);

    // System.out.println(albums);

    Track min = albumManagement.getMinViewCount(albums);
    Track max = albumManagement.getMaxViewCount(albums);
    long count = albumManagement.countTracks(albums);

    System.out.println(min);
    System.out.println(max);
    System.out.println(count);
  }
}
