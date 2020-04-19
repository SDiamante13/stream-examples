package tech.pathtoprogramming.common;

import tech.pathtoprogramming.common.model.Album;
import tech.pathtoprogramming.common.model.Artist;
import tech.pathtoprogramming.common.model.Track;

import java.util.*;

import static java.util.Collections.singletonList;

public class TestData {

    // region tracks
    public static final List<Track> brushfireFairytalesTracks = Arrays.asList(
            new Track(randomId(), "Inaudible Melodies", "3:35"),
            new Track(randomId(), "Middle Man", "3:14"),
            new Track(randomId(), "Posters", "3:13"),
            new Track(randomId(), "Sexy Plexi", "2:07"),
            new Track(randomId(), "Flake", "4:40"),
            new Track(randomId(), "Bubble Toes", "3:56"),
            new Track(randomId(), "Fortunate Fool", "3:48"),
            new Track(randomId(), "The News", "2:26"),
            new Track(randomId(), "Drink the Water", "3:21"),
            new Track(randomId(), "Mudfootball", "3:03"),
            new Track(randomId(), "F-Stop Blues", "3:10"),
            new Track(randomId(), "Losing Hope", "3:52"),
            new Track(randomId(), "It's All Understood", "5:28")
    );

    public static final List<Track> onAndOnTracks = Arrays.asList(
            new Track(randomId(), "Times Like These", "2:22"),
            new Track(randomId(), "The Horizon Has Been Defeated", "2:33"),
            new Track(randomId(), "Traffic in the Sky", "2:50"),
            new Track(randomId(), "Taylor", "3:59"),
            new Track(randomId(), "Gone", "2:10"),
            new Track(randomId(), "Cupid", "1:05"),
            new Track(randomId(), "Wasting Time", "3:50"),
            new Track(randomId(), "Holes to Heaven", "2:54"),
            new Track(randomId(), "Dreams Be Dreams", "2:12"),
            new Track(randomId(), "Tomorrow Morning", "2:50"),
            new Track(randomId(), "Fall Line", "1:35"),
            new Track(randomId(), "Cookie Jar", "2:57"),
            new Track(randomId(), "Rodeo Clowns", "2:38"),
            new Track(randomId(), "Cocoon", "4:10"),
            new Track(randomId(), "Mediocre Bad Guys", "3:00"),
            new Track(randomId(), "Symbol in My Driveway", "2:55")
    );

    public static final List<Track> allTheLightAboveItTooTracks = Arrays.asList(
            new Track(randomId(), "Subplots",	"4:29"),
            new Track(randomId(), "You Can't Control It", "4:09"),
            new Track(randomId(), "Sunsets for Somebody Else",	"3:30"),
            new Track(randomId(), "My Mind Is for Sale",	"3:59"),
            new Track(randomId(), "Daybreaks",	"3:59"),
            new Track(randomId(), "Big Sur",	"2:52"),
            new Track(randomId(), "Love Song #16",	"3:01"),
            new Track(randomId(), "Is One Moon Enough?",	"4:11"),
            new Track(randomId(), "Gather",	"4:15"),
            new Track(randomId(), "Fragments", "3:41")
    );

    public static final List<Track> saladDayTracks = Arrays.asList(
            new Track(randomId(), "Salad Days", "2:25"),
            new Track(randomId(), "Blue Boy", "2:06"),
            new Track(randomId(), "Brother", "3:32"),
            new Track(randomId(), "Let Her Go", "3:02"),
            new Track(randomId(), "Goodbye Weekend", "2:59"),
            new Track(randomId(), "Let My Baby Stay", "4:08"),
            new Track(randomId(), "Passing Out Pieces", "2:47"),
            new Track(randomId(), "Treat Her Better", "3:49"),
            new Track(randomId(), "Chamber of Reflection", "3:51"),
            new Track(randomId(), "Go Easy", "3:24"),
            new Track(randomId(), "Jonny's Odyssey", "2:38")
    );

    public static final List<Track> thisOldDogTracks = Arrays.asList(
            new Track(randomId(), "My Old Man",	"3:41"),
            new Track(randomId(), "This Old Dog",	"2:30"),
            new Track(randomId(), "Baby You're Out",	"2:37"),
            new Track(randomId(), "For the First Time",	"3:02"),
            new Track(randomId(), "One Another",	"2:46"),
            new Track(randomId(), "Still Beating",	"3:01"),
            new Track(randomId(), "Sister",	"1:18"),
            new Track(randomId(), "Dreams from Yesterday",	"3:27"),
            new Track(randomId(), "A Wolf Who Wears Sheeps Clothes",	"2:49"),
            new Track(randomId(), "One More Love Song",	"4:01"),
            new Track(randomId(), "On the Level", "3:47"),
            new Track(randomId(), "Moonlight on the River", "7:02"),
            new Track(randomId(), "Watching Him Fade Away", "2:23")
    );

    public static final List<Track> hereComesTheCowboyTracks = Arrays.asList(
            new Track(randomId(), "Here Comes the Cowboy",	"3:00"),
            new Track(randomId(), "Nobody",	"3:32"),
            new Track(randomId(), "Finally Alone",	"2:25"),
            new Track(randomId(), "Little Dogs March",	"2:29"),
            new Track(randomId(), "Preoccupied",	"4:00"),
            new Track(randomId(), "Choo Choo",	"2:39"),
            new Track(randomId(), "K",	"3:33"),
            new Track(randomId(), "Heart to Heart",	"3:31"),
            new Track(randomId(), "Hey Cowgirl",	"2:16"),
            new Track(randomId(), "On the Square",	"3:29"),
            new Track(randomId(), "All of Our Yesterdays",	"4:04"),
            new Track(randomId(), "Skyless Moon",	"4:05"),
            new Track(randomId(), "Baby Bye Bye",	"7:29")
    );

    // endregion tracks

    // region albums
    public static final List<Album> jackJohnsonAlbums = Arrays.asList(
            new Album(randomId(), "Brushfire Fairytales", "2001-2-1", brushfireFairytalesTracks),
            new Album(randomId(), "On and On", "2003-5-6", onAndOnTracks),
            new Album(randomId(), "All The Light Above It Too", "2017-7-14", allTheLightAboveItTooTracks)
    );

    public static final List<Album> macDeMarcoAlbums = Arrays.asList(
            new Album(randomId(), "Salad Days", "2014-3-28", saladDayTracks),
            new Album(randomId(), "This Old Dog", "2017-5-5", thisOldDogTracks),
            new Album(randomId(), "Here Comes the Cowboy", "2019-5-10", hereComesTheCowboyTracks)
    );

    public static final List<Album> emptyAlbum = singletonList(
            new Album(randomId(), "Empty Album", "2019-02-02", Arrays.asList(new Track(), new Track()))
    );
    // endregion albums

    // region artists
    public static final Artist jackJohnson = new Artist(randomId(), "Jack Johnson", "Folk Rock", jackJohnsonAlbums);
    public static final Artist macDeMarco = new Artist(randomId(), "Mac DeMarco", "Indie Rock", macDeMarcoAlbums);

    // endregion artists

    // region common test functions
    static String randomId() {
        return UUID.randomUUID().toString();
    }
    public static List<Artist> allArtists() { return Arrays.asList(jackJohnson, macDeMarco); }
    public static List<String> getExpectedTrackNamesList() {
        List<String> expected = new ArrayList<>();

        for (Track track : saladDayTracks) {
            expected.add(track.getTrackName());
        }
        for (Track track : thisOldDogTracks) {
            expected.add(track.getTrackName());
        }
        for (Track track : hereComesTheCowboyTracks) {
            expected.add(track.getTrackName());
        }
        return expected;
    }

    public static List<Artist> allArtistsWithNoTracks() {
        return singletonList(new Artist(randomId(), "The Unknown", "Metal", emptyAlbum));
    }

    public static List<Artist> allArtistsWithNoGenre() {
        return singletonList(new Artist(randomId(), "mac with no genre", null, macDeMarcoAlbums));
    }
    // endregion common test functions
}
