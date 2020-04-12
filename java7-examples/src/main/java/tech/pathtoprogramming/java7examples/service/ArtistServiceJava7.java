package tech.pathtoprogramming.java7examples.service;

import tech.pathtoprogramming.common.model.Album;
import tech.pathtoprogramming.common.model.Artist;
import tech.pathtoprogramming.common.model.Track;
import tech.pathtoprogramming.common.service.ArtistService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.Integer.valueOf;

public class ArtistServiceJava7 implements ArtistService {

    @Override
    public List<Album> getAllAlbumsAfterReleaseDate(List<Artist> artists, String releaseDate) {
        List<Album> albums = new ArrayList<>();
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                if (toCalendar(album.getReleaseDate()).after(toCalendar(releaseDate))) {
                    albums.add(album);
                }
            }
        }

        return albums;
    }

    @Override
    public List<String> getAllTrackNamesStartingWith(List<Artist> artists, String startsWith) {
        List<String> trackNames = new ArrayList<>();
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                for (Track track : album.getTracks()) {
                    if (track.getTrackName().startsWith(startsWith)) {
                        trackNames.add(track.getTrackName());
                    }
                }
            }
        }

        return trackNames;
    }

    @Override
    public List<String> getAllTrackNamesByArtist(Artist artist) {
        List<String> trackNames = new ArrayList<>();
        for (Album album : artist.getAlbums()) {
            for (Track track : album.getTracks()) trackNames.add(track.getTrackName());
        }

        return trackNames;
    }

    @Override
    public List<Artist> getAllArtistsByGenre(List<Artist> artists, String genre) {
        List<Artist> artistsByGenre = new ArrayList<>();
        for (Artist artist : artists) {
            if (artist.getGenre().equalsIgnoreCase(genre)) {
                artistsByGenre.add(artist);
            }
        }

        return artistsByGenre;
    }

    private Calendar toCalendar(String releaseDate) {
        String[] dateArray = releaseDate.split("-");
        return new GregorianCalendar(valueOf(dateArray[0]), valueOf(dateArray[1]), valueOf(dateArray[2]));
    }
}
