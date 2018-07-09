package p05_online_radio_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main { // Its pretty badly made, but I'm too lazy to fix it..
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());
        List<Song> songs = new ArrayList<>();
        List<String> songlengths = new ArrayList<>();

        while (n-- > 0) {
            String[] input = reader.readLine().split(";");

            Song radioDatabase = null;
            try {
                radioDatabase = new Song(input[0], input[1], input[2]);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            if (radioDatabase != null) {
                songs.add(radioDatabase);
                songlengths.add(input[2]);
                System.out.println("Song added.");
            }
        }

        long tm = 0;
        for (String tmp : songlengths){
            String[] arr = tmp.split(":");
            tm += Integer.parseInt(arr[1]);
            tm += 60 * Integer.parseInt(arr[0]);
        }

        long hh = tm / 3600;
        tm %= 3600;
        long mm = tm / 60;
        tm %= 60;
        long ss = tm;

        System.out.println("Songs added: " + songlengths.size());
        System.out.println("Playlist length: " + hh + "h " + mm + "m " + ss + "s");
    }
}
