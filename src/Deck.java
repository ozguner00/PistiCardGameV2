import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Integer> deck = new ArrayList<>();
    private String name;

    public Deck() {
    }

    public Deck(String name) {
        this.name = name;
        fillDeck();
    }

    public void fillDeck(){
        for(int i = 1; i<53; i++){
            this.deck.add(i);
        }
    }


    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public List<Integer> getDeck() {
        return deck;
    }

    public void setDeck(List<Integer> deck) {
        this.deck = deck;
    }

    public void printDeck(){
        System.out.println(deck);
    }

    public int deckSize(){
        return this.deck.size();
    }

    public void addCard(int card){
        deck.add(card);
    }
}
