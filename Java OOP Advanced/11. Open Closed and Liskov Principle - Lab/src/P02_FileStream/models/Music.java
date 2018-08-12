package P02_FileStream.models;

public class Music extends StreamableImpl{

    private String artist;
    private String album;

    public Music(int length, int bytesSent, String artist, String album) {
        super(length, bytesSent);
        this.artist = artist;
        this.album = album;
    }
}
