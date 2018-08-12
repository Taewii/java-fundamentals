package P02_FileStream.models;

public class File extends StreamableImpl{

    private String name;

    public File(int length, int bytesSent, String name) {
        super(length, bytesSent);
        this.name = name;
    }
}
