import java.util.ArrayList;

public class Hand {
    private ArrayList<Integer> hand = new ArrayList<>();

    public void printHand(){
        System.out.println(hand);
    }
    public int handSize(){
        return hand.size();
    }

    public void addCard(int card) {
        hand.add(card);
    }
}
