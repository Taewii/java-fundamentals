package p02_card_rank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");

        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.name());
        }
    }
}
