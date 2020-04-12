package tech.pathtoprogramming.common.service;

import tech.pathtoprogramming.common.model.Album;
import tech.pathtoprogramming.common.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Album> getAllAlbumsAfterReleaseDate(List<Artist> artists, String releaseDate);

    List<String> getAllTrackNamesStartingWith(List<Artist> artists, String startsWith);

    List<String> getAllTrackNamesByArtist(Artist artist);

    List<Artist> getAllArtistsByGenre(List<Artist> artists, String genre);
}
