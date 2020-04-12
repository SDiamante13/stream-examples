package tech.pathtoprogramming.java8examples.service;

import tech.pathtoprogramming.common.model.Album;
import tech.pathtoprogramming.common.model.Artist;
import tech.pathtoprogramming.common.model.Track;
import tech.pathtoprogramming.common.service.ArtistService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;

public class ArtistServiceJava8 implements ArtistService {

    @Override
    public List<Album> getAllAlbumsAfterReleaseDate(List<Artist> artists, String releaseDate) {
        return artists.stream()
                .map(Artist::getAlbums)
                .flatMap(Collection::stream)
                .filter(album -> toLocalDate(album.getReleaseDate()).isAfter(toLocalDate(releaseDate)))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTrackNamesStartingWith(List<Artist> artists, String startsWith) {
        return artists.stream()
                .map(Artist::getAlbums)
                .flatMap(Collection::stream)
                .map(Album::getTracks)
                .flatMap(Collection::stream)
                .filter(track -> track.getTrackName().startsWith(startsWith))
                .map(Track::getTrackName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTrackNamesByArtist(Artist artist) {
        return artist.getAlbums()
                .stream()
                .map(Album::getTracks)
                .flatMap(Collection::stream)
                .map(Track::getTrackName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Artist> getAllArtistsByGenre(List<Artist> artists, String genre) {
        return artists.stream()
                .filter(artist -> artist.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    private LocalDate toLocalDate(String releaseDate) {
        String[] dateArray = releaseDate.split("-");
        return LocalDate.of(valueOf(dateArray[0]), valueOf(dateArray[1]), valueOf(dateArray[2]));
    }
}
