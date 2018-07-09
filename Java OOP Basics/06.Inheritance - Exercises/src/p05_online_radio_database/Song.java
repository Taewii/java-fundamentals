package p05_online_radio_database;

public class Song {

    private static final String INVALID_ARTIST_NAME_EXCEPTION = "Artist name should be between 3 and 20 symbols.";
    private static final String INVALID_SONG_NAME_EXCEPTION = "Song name should be between 3 and 30 symbols.";
    private static final String INVALID_SONG_LENGTH_EXCEPTION = "Invalid song length.";
    private static final String INVALID_SONG_MINUTES_EXCEPTION = "Song minutes should be between 0 and 14.";
    private static final String INVALID_SONG_SECONDS_EXCEPTION = "Song seconds should be between 0 and 59.";

    private String artistName;
    private String songName;
    private String songLength;

    public Song(String artistName, String songName, String songLength) {
        setArtistName(artistName);
        setSongName(songName);
        setSongLength(songLength);
    }

    public void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new IllegalArgumentException(INVALID_ARTIST_NAME_EXCEPTION);
        }
        this.artistName = artistName;
    }

    public void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new IllegalArgumentException(INVALID_SONG_NAME_EXCEPTION);
        }
        this.songName = songName;
    }

    public void setSongLength(String length) {
        int seconds;
        int minutes;
        try {
            seconds = Integer.parseInt(length.split(":")[1]);
            minutes = Integer.parseInt(length.split(":")[0]);
        } catch (Exception ex) {
            throw new IllegalArgumentException(INVALID_SONG_LENGTH_EXCEPTION);
        }

        if (minutes < 0 || minutes > 14) {
            throw new IllegalArgumentException(INVALID_SONG_MINUTES_EXCEPTION);
        }
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException(INVALID_SONG_SECONDS_EXCEPTION);
        }
        this.songLength = length;
    }
}
