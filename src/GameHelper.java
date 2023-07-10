public class GameHelper {
    public static void printHand(Hand hand){

    }

    public static boolean checkWinner(int playerScore, int computerScore, int scoreLimit){
        if(playerScore > scoreLimit && playerScore > computerScore){
            System.out.println("Congratulations !!!");
            return false;
        }else if(computerScore > scoreLimit && computerScore > playerScore){
            System.out.println("Try Again.");
            return false;
        }

        return true;
    }

    public static boolean winCheck(Deck tableDeck, int card, Hand tableHand,Player player){ // table hand yerdeki kağıtları temizlemek için
        if(tableDeck.deckSize() < 2){
            return false;
        }
        else if(tableDeck.getDeck().get(tableDeck.deckSize()-2)%13 == card%13 || card % 13 == 11){
            if(tableDeck.getDeck().get(tableDeck.deckSize()-2)%13 == card%13){
                pistiCheck(tableHand,tableDeck,player);
            }
            winDeckFillandClear(tableDeck,player.getDeck(),tableHand);
            return true;
        }else{
            return false;
        }
    }

    public static void pistiCheck(Hand tableHand,Deck tableDeck,Player player){
        if(tableHand.handSize() == 0 && tableDeck.deckSize() == 2){
            if(tableDeck.getDeck().get(tableDeck.getDeck().size()-1) %13 == 11){
                player.setScore(player.getScore() + 20);
            }else{
                player.setScore(player.getScore() + 10);
            }
            System.out.println("PİSTİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİiii");
            System.out.println("Table Deck"); tableDeck.printDeck();
        }
    }

    public static void winDeckFillandClear(Deck tableDeck, Deck winDeck, Hand tableHand){
        System.out.println("WİN DECK :" ); winDeck.printDeck();
        System.out.println("TABLE HAND :"); tableHand.printHand();
        System.out.println("TABLE DECK : "); tableDeck.printDeck();
        winDeck.getDeck().addAll(tableDeck.getDeck());
        winDeck.getDeck().addAll(tableHand.getHand());
        tableDeck.getDeck().clear();
        tableHand.getHand().clear();
        System.out.println("WİN DECK :" ); winDeck.printDeck();
        System.out.println("TABLE HAND :"); tableHand.printHand();
        System.out.println("TABLE DECK : "); tableDeck.printDeck();
    }
    public static void winDeckFillandClear(Deck tableDeck, Deck winDeck){
        System.out.println("WİN DECK :" ); winDeck.printDeck();
        System.out.println("TABLE DECK : "); tableDeck.printDeck();
        winDeck.getDeck().addAll(tableDeck.getDeck());
        tableDeck.getDeck().clear();
        System.out.println("WİN DECK :" ); winDeck.printDeck();
        System.out.println("TABLE DECK : "); tableDeck.printDeck();
    }

    public static int scoreCal(Deck deck){
        int score = 0; // A = 1 , J = 11 ,D10 = 23, CL2 = 2
        for(int card : deck.getDeck()){
            if(card % 13 == 1 || card % 13 == 11) score++;
            else if(card == 2) score +=2;
            else if(card == 23) score +=3;
        }
        return score + scoreCalCount(deck);
    }

    public static int scoreCalCount(Deck deck){
        if(deck.deckSize() > 26) return 3;
        return 0;
    }


}
