package tech.pathtoprogramming.common.model;

import java.util.List;
import java.util.Objects;

public class Artist {
    private String artistId;
    private String name;
    private String genre;
    private List<Album> albums;

    public Artist(String artistId, String name, String genre, List<Album> albums) {
        this.artistId = artistId;
        this.name = name;
        this.genre = genre;
        this.albums = albums;
    }

    public String getArtistId() { return artistId; }

    public String getName() { return name; }

    public String getGenre() { return genre; }

    public List<Album> getAlbums() { return albums; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (!Objects.equals(artistId, artist.artistId)) return false;
        if (!Objects.equals(name, artist.name)) return false;
        if (!Objects.equals(genre, artist.genre)) return false;
        return Objects.equals(albums, artist.albums);
    }

    @Override
    public int hashCode() {
        int result = artistId != null ? artistId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (albums != null ? albums.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId='" + artistId + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", albums=" + albums +
                '}';
    }
}
