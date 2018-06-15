import java.io.FileInputStream;
import java.io.IOException;

public class p01_ReadFile {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String inputPath = directory + "input.txt";

        try (FileInputStream fis = new FileInputStream(inputPath)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
