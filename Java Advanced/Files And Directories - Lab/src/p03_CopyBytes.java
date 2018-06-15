import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p03_CopyBytes {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String inputPath = directory + "input.txt";
        String outputPath = directory + "output.txt";

        try (FileInputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {

            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
