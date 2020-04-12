package tech.pathtoprogramming.common.model;

import java.util.Objects;

public class Track {
    private String trackId;
    private String trackName;
    private int trackDuration;

    public Track(String trackId, String trackName, int trackDuration) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackDuration = trackDuration;
    }

    public Track(String trackId, String trackName, String trackTimeInMinsAndSecs) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackDuration = convertToTrackDuration(trackTimeInMinsAndSecs);
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public int convertToTrackDuration(String minsSecs) {
        String[] trackTime = minsSecs.split(":");
        return Integer.valueOf(trackTime[0]) * 60 + Integer.valueOf(trackTime[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (trackDuration != track.trackDuration) return false;
        if (!Objects.equals(trackId, track.trackId)) return false;
        return Objects.equals(trackName, track.trackName);
    }

    @Override
    public int hashCode() {
        int result = trackId != null ? trackId.hashCode() : 0;
        result = 31 * result + (trackName != null ? trackName.hashCode() : 0);
        result = 31 * result + trackDuration;
        return result;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId='" + trackId + '\'' +
                ", trackName='" + trackName + '\'' +
                ", trackDuration=" + trackDuration +
                '}';
    }
}
