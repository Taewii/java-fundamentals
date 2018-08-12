package P02_FileStream.models;

import P02_FileStream.interfaces.Streamable;

public abstract class StreamableImpl implements Streamable {

    private int length;
    private int bytesSent;

    public StreamableImpl(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
