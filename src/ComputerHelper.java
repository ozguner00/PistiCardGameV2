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

    public static int probabilityCalNegative(Deck wiewDeck,Hand hand){
        wiewArrFill(wiewDeck);

        int index = 0;
        int min = 4;
        for(int cardI = 0; cardI<hand.handSize(); cardI++){
            int card = hand.getCard(cardI);
            if(wiewDeckArr[card%13] < min && card%13 != 11){
                index = cardI;
                min = wiewDeckArr[card%13];
            }
        }
        /*System.out.println("-----------------------------------");
        for(int i : wiewDeckArr){
            System.out.print(i + " - ");
        }*/
        return index;
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

    public static boolean isPlayJokerFirstly(int dealerCounter){
        if(dealerCounter < 21)  return true;
        return false;
    }

    public static boolean isPlayJoker(){
        //Yerdeki puan sayısı(kart sayısı da +3 puan ihtimali olarak eklenebilir.) ör : yerdeki kartları alınca +3 puan kazanma olasılığı garanti +3
        //garanti değil ama yüksekse +2 gibi

        return false;
    }

    public static boolean isPlayerJoker(){
        //yerde çok puan varsa ve karşısı joker oynamadıysa false
        //puan yoksa olasılık hesabı yapılır winable ile garanti oyun mu standart mı riskli mi tartışılır.
        //true dönerse ve winable 0-1 ise joker ilk fırsatta oynanır. winable -1 ise riskli oyuna bakılır.

        //false ise ve winable 1 dğeilse joker pisti ihtimalini kovalar.//elde çıkmamış kart sona bırakılır pisti iiçin.
        //pisti ihtimali düşükse last card olarak oynanır.

        return false;
    }

    public static int winable(int playerScore,int computerScore,int scoreLimit){
        if((computerScore >= playerScore+20 || computerScore >= scoreLimit-16) && playerScore <= scoreLimit-16){
            return 1;
        }else if((playerScore >= computerScore+20 || playerScore >= scoreLimit-16) && computerScore <= scoreLimit-16){
            return -1;
        }

        return 0; // default game
    }

}
