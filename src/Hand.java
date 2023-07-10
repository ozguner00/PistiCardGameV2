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

    public void removeCard(int cardIndex){
        hand.remove(cardIndex);
    }

    public int getCard(int cardIndex){
        return this.hand.get(cardIndex);
    }

    public ArrayList<Integer> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Integer> hand) {
        this.hand = hand;
    }
}
