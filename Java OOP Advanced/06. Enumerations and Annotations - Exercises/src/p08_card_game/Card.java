package p08_card_game;

public class Card implements Comparable<Card>{

    private Rank cardRank;
    private Suit cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = Rank.valueOf(cardRank);
        this.cardSuit = Suit.valueOf(cardSuit);
    }

    public int getPower() {
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }

    @Override
    public int compareTo(Card o) {
        int result = this.cardRank.name().compareTo(o.cardRank.name());

        if (result == 0) {
            result = this.cardSuit.name().compareTo(o.cardSuit.name());
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Card card = (Card) obj;

        return this.compareTo(card) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                this.cardRank, this.cardSuit);
    }
}
