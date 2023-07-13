public class Computer extends Player{
    private int score = 0;
    private String name = "Computer";
    private Deck deck = new Deck();
    private Hand hand = new Hand();
    private Deck wiewDeck = new Deck();

   /* private List<Integer> probabilityList = new ArrayList<Integer>();
    private HashMap<Integer,Double> probabilityMap= new HashMap<Integer,Double>();
    private Deck wiewDeck = new Deck(); //probability
    private List<Integer> playedCardCounter = new ArrayList<>(13); // probability
    private int wiewDeckIt = 0; // probability?*/


    public Computer() {
        super();
    }
    public void printNameScore(){
        System.out.println("Name:" + this.name + " Score:" + this.score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

    public Deck getWiewDeck() {
        return wiewDeck;
    }

    public void addWiewDeck(int card){
        this.wiewDeck.getDeck().add(card);
    }

    public int computerSelectCardIndex(int lastCard,int scoreLimit, int dealerCounter){

        if(lastCard == -1){ // yerde kart yoksa
            return ComputerHelper.probabilityCal(this.wiewDeck,this.getHand());
        }else if(ComputerHelper.checkEqualIndex(this.getHand(),lastCard) != -1) { // eşit kartım var mı
            return ComputerHelper.checkEqualIndex(this.getHand(),lastCard);
        }else if(ComputerHelper.hasJoker(this.getHand()) && ComputerHelper.isPlayJokerFirstly(dealerCounter)){ // joker ilk 2 turda hesap yapmadan oynanıyor.
            return ComputerHelper.jokerIndex(this.getHand());
        }
        /* winable boolean veya int 0-1-(-1) geride, önce veya standart olarak 3 farklı oynanış eklenebilir.

        *
        *
        *
        * */

        return 0;
    }


}
