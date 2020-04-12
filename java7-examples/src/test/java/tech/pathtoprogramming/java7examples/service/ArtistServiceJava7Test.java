package tech.pathtoprogramming.java7examples.service;

import junit.framework.TestCase;
import tech.pathtoprogramming.common.model.Album;
import tech.pathtoprogramming.common.model.Artist;
import tech.pathtoprogramming.common.service.ArtistService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.common.TestData.*;

public class ArtistServiceJava7Test extends TestCase {

    private ArtistService artistServiceJava7 = new ArtistServiceJava7();

    public void test_getAllAlbumsAfterReleaseDate_shouldReturnAlbumsAfterReleaseDate() {
        List<Album> expected = Arrays.asList(jackJohnsonAlbums.get(2), macDeMarcoAlbums.get(1), macDeMarcoAlbums.get(2));

        String releaseDate = "2017-1-1";
        List<Album> result = artistServiceJava7.getAllAlbumsAfterReleaseDate(allArtists(), releaseDate);

        assertThat(result).isEqualTo(expected);
    }

    public void test_getAllTrackNamesStartingWith_returnsListOfTrackNamesStartingWithTheGivenString() {
        List<String> expected = Arrays.asList("Drink the Water", "Dreams Be Dreams", "Dreams from Yesterday");

        List<String> result = artistServiceJava7.getAllTrackNamesStartingWith(allArtists(), "Dr");

        assertThat(result).isEqualTo(expected);
    }

    public void test_getAllTrackNamesByArtist_returnsListOfTrackNamesForTheGivenArtist() {
        List<String> expectedTrackNames = getExpectedTrackNamesList();

        List<String> result = artistServiceJava7.getAllTrackNamesByArtist(macDeMarco);

        assertThat(result).isEqualTo(expectedTrackNames);
    }

    public void test_getAllArtistsByGenre_returnsArtistListThatAreOfGivenGenre() {
        List<Artist> expected = Collections.singletonList(jackJohnson);

        List<Artist> result = artistServiceJava7.getAllArtistsByGenre(allArtists(), "Folk Rock");

        assertThat(result).isEqualTo(expected);
    }
}
