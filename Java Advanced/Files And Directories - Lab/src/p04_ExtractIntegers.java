import java.io.*;
import java.util.Scanner;

public class p04_ExtractIntegers {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String inputPath = directory + "input.txt";
        String outputPath = directory + "output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }

                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
