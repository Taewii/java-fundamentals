import java.io.File;
import java.util.ArrayDeque;

public class p08_NestedFolders {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String path = directory + "Files-and-Streams";
        File root = new File(path);

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int counter = 1;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                    counter++;
                }
            }
            System.out.println(current.getName());
        }
        System.out.println(counter + " folders");
    }
}
