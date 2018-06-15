import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p02_WriteFile {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String inputPath = directory + "input.txt";
        String outputPath = directory + "output.txt";

        List<Character> punctuations = new ArrayList<>();
        Collections.addAll(punctuations, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {

            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!punctuations.contains((char)oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
