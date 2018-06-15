import java.io.*;
import java.util.Scanner;

public class p05_WriteEveryThirdLine {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String inputPath = directory + "input.txt";
        String outputPath = directory + "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {

            int counter = 1;
            String line = reader.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }

                counter++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
