package tech.pathtoprogramming.java8examples.service;

import org.junit.jupiter.api.Test;
import tech.pathtoprogramming.common.model.Album;
import tech.pathtoprogramming.common.model.Artist;
import tech.pathtoprogramming.common.service.ArtistService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.common.TestData.*;

public class ArtistServiceJava8Test {

    private ArtistService artistServiceJava8 = new ArtistServiceJava8();

    @Test
    public void getAllAlbumsAfterReleaseDate_shouldReturnAlbumsAfterReleaseDate() {
        List<Album> expected = Arrays.asList(jackJohnsonAlbums.get(2), macDeMarcoAlbums.get(1), macDeMarcoAlbums.get(2));

        String releaseDate = of(2017, 1, 1).toString();
        List<Album> result = artistServiceJava8.getAllAlbumsAfterReleaseDate(allArtists(), releaseDate);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void getAllTrackNamesStartingWith_returnsListOfTrackNamesStartingWithTheGivenString() {
        List<String> expected = Arrays.asList("Drink the Water", "Dreams Be Dreams", "Dreams from Yesterday");

        List<String> result = artistServiceJava8.getAllTrackNamesStartingWith(allArtists(), "Dr");

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void getAllTrackNamesStartingWith_returnsEmptyList() {
        List<String> expected = Collections.emptyList();

        List<String> result = artistServiceJava8.getAllTrackNamesStartingWith(allArtistsWithNoTracks(), "Dr");

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void getAllTrackNamesByArtist_returnsListOfTrackNamesForTheGivenArtist() {
        List<String> expectedTrackNames = getExpectedTrackNamesList();

        List<String> result = artistServiceJava8.getAllTrackNamesByArtist(macDeMarco);

        assertThat(result).isEqualTo(expectedTrackNames);
    }

    @Test
    public void getAllArtistsByGenre_returnsArtistListThatAreOfGivenGenre() {
        List<Artist> expected = Collections.singletonList(jackJohnson);

        List<Artist> result = artistServiceJava8.getAllArtistsByGenre(allArtists(), "Folk Rock");

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void getAllArtistsByGenre_returnsEmptyListWhenGenreIsNull() {
        List<String> expected = Collections.emptyList();

        List<Artist> result = artistServiceJava8.getAllArtistsByGenre(allArtistsWithNoGenre(), "Folk Rock");

        assertThat(result).isEqualTo(expected);
    }
}
