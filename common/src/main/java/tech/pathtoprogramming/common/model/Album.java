package tech.pathtoprogramming.common.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Album {
    private String albumId;
    private String albumName;
    private String releaseDate;
    private List<Track> tracks;

    public Album(String albumId, String albumName, String releaseDate, List<Track> tracks) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.tracks = tracks;
    }

    public String getAlbumId() { return albumId; }

    public String getAlbumName() { return albumName; }

    public String getReleaseDate() { return releaseDate; }

    public List<Track> getTracks() { return tracks; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (!Objects.equals(albumId, album.albumId)) return false;
        if (!Objects.equals(albumName, album.albumName)) return false;
        if (!Objects.equals(releaseDate, album.releaseDate)) return false;
        return Objects.equals(tracks, album.tracks);
    }

    @Override
    public int hashCode() {
        int result = albumId != null ? albumId.hashCode() : 0;
        result = 31 * result + (albumName != null ? albumName.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", albumName='" + albumName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
