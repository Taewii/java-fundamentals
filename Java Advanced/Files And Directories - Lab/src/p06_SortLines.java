import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class p06_SortLines {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String inputPath = directory + "input.txt";
        Path path = Paths.get(inputPath);
        String outputPath = directory + "output.txt";
        Path output = Paths.get(outputPath);

        try {
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            Files.write(output, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
