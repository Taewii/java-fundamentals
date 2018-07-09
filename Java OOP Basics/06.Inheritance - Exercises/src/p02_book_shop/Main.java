package p02_book_shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String author = reader.readLine();
        String title = reader.readLine();
        double price = Double.parseDouble(reader.readLine());

        try {
            Book book = new Book(title, author, price);
            GoldenEditionBook geb = new GoldenEditionBook(title, author, price);
            System.out.println(book);
            System.out.println(geb);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
