package p02_book_shop;

public class Book {

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    public void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        String[] names = author.split(" ");
        if (names.length > 1) {
            if (Character.isDigit(names[1].charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    public void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Type: Book").append(System.lineSeparator());
        sb.append("Title: ").append(this.getTitle()).append(System.lineSeparator());
        sb.append("Author: ").append(this.getAuthor()).append(System.lineSeparator());
        sb.append("Price: ").append(String.format("%.1f", this.getPrice())).append(System.lineSeparator());

        return sb.toString();
    }
}
