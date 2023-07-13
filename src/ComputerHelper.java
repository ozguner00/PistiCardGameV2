public class ComputerHelper {
    private static int wiewDeckIt = 0;
    private static int[] wiewDeckArr = new int[13];
    public static int checkEqualIndex(Hand hand, int lastCard){
        for(int cardIndex = 0; cardIndex < hand.handSize(); cardIndex++){
            if(hand.getCard(cardIndex)%13 == lastCard%13) return cardIndex;
        }
        return -1;
    }

    public static boolean hasJoker(Hand hand){
        for(int card: hand.getHand()){
            if(card%13 == 11) return true;
        }
        return false;
    }

    public static int jokerIndex(Hand hand){
        for(int cardIndex = 0; cardIndex < hand.handSize(); cardIndex++){
            if(hand.getCard(cardIndex)%13 == 11) return cardIndex;
        }
        return -1;
    }

    public static void wiewArrFill(Deck wiewDeck){
        while (wiewDeckIt < wiewDeck.getDeck().size()){
            int card = wiewDeck.getDeck().get(wiewDeckIt);
            wiewDeckArr[card%13] ++;
            wiewDeckIt++;
        }
    }

    public static int probabilityCal(Deck wiewDeck,Hand hand){
        wiewArrFill(wiewDeck);

        int index = 0;
        int max = 0;
        for(int cardI = 0; cardI<hand.handSize(); cardI++){
            int card = hand.getCard(cardI);
            if(wiewDeckArr[card%13] > max && card%13 != 11){
                index = cardI;
                max = wiewDeckArr[card%13];
            }
        }
        /*System.out.println("-----------------------------------");
        for(int i : wiewDeckArr){
            System.out.print(i + " - ");
        }*/
        return index;
    }

    public static boolean isPlayJoker(int dealerCounter){
        if(dealerCounter < 29)  return true;
        return false;
    }
}
