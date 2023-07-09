public class Table {
    private Deck deck = new Deck(); // Yerdeki oynanan kağıtlar
    private Hand hand = new Hand(); // yerdeki ilk kağıtlar

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
