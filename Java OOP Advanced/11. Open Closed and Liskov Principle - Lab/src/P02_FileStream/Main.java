package P02_FileStream;

import P02_FileStream.models.File;
import P02_FileStream.models.Music;
import P02_FileStream.models.StreamProgressInfo;

public class Main {
    public static void main(String[] args) {

        StreamProgressInfo spi = new StreamProgressInfo(new File(100, 200, "Gosho"));
        StreamProgressInfo spi2 = new StreamProgressInfo(new Music(200, 300, "Gosho", "Triller"));

        System.out.println(spi.calculateCurrentPercent());
        System.out.println(spi2.calculateCurrentPercent());
    }
}
