import java.util.ArrayList;

public class Hand {
    private ArrayList<Integer> hand = new ArrayList<>();

    public void printHand(){
        for(int card : hand){
            System.out.print(card%13 + " - " );
        }
        System.out.println();
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

}
