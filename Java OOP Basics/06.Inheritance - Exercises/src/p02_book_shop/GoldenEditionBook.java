package p02_book_shop;

public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price * 1.3);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Type: GoldenEditionBook").append(System.lineSeparator());
        sb.append("Title: ").append(super.getTitle()).append(System.lineSeparator());
        sb.append("Author: ").append(super.getAuthor()).append(System.lineSeparator());
        sb.append("Price: ").append(String.format("%.1f", this.getPrice()));

        return sb.toString();
    }
}
