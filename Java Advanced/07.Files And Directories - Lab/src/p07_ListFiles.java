import java.io.File;

public class p07_ListFiles {
    public static void main(String[] args) {

        String directory = "C:\\Users\\eLaZizY\\Desktop\\asd\\";
        String path = directory + "Files-and-Streams";
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: %s%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
