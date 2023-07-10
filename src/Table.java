public class Table {
    private Deck deck = new Deck(); // Yerdeki oynanan kağıtlar
    private Hand hand = new Hand(); // yerdeki ilk kağıtlar

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

}
