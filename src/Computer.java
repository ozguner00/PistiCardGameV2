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

    public int computerSelectCardIndex(int lastCard,int scoreLimit, int dealerCounter,int playerScore){
        // Standart game için yerdeki puanı al ona göre ek kontrol yaz. joker atmak, puan çoksa risk almak
        // rakibin elinde joker olma ihtimaline göre oyun planı geliştir.
        // dealerPlayer kontrolüne göre oynanış değişir(en son kartı kim atıyor)
        if(lastCard == -1){ // yerde kart yoksa
            return ComputerHelper.probabilityCal(this.wiewDeck,this.getHand());
        }else if(ComputerHelper.checkEqualIndex(this.getHand(),lastCard) != -1) { // eşit kartım var mı
            return ComputerHelper.checkEqualIndex(this.getHand(),lastCard);
        }else if(ComputerHelper.hasJoker(this.getHand()) && ComputerHelper.isPlayJokerFirstly(dealerCounter)){ // joker ilk 2 turda hesap yapmadan oynanıyor.
            return ComputerHelper.jokerIndex(this.getHand());
        }else if(ComputerHelper.winable(playerScore,this.score,scoreLimit) == 1){
            if(ComputerHelper.hasJoker(this.getHand())){
                return ComputerHelper.jokerIndex(this.getHand());
            }else{
                return ComputerHelper.probabilityCalNegative(this.wiewDeck,this.getHand());
            }
        }else if(ComputerHelper.winable(playerScore,this.score,scoreLimit) == -1){
            if(ComputerHelper.hasJoker(this.getHand())){
                if(this.hand.handSize() == 2){
                    return ComputerHelper.jokerIndex(this.getHand());
                }
            }else{
                return ComputerHelper.probabilityCal(this.wiewDeck,this.getHand());
            }
        }else if(ComputerHelper.winable(playerScore,this.score,scoreLimit) == 0){
            if(ComputerHelper.hasJoker(this.getHand())){
                return ComputerHelper.probabilityCal(this.wiewDeck,this.getHand());
            }else{
                if(this.hand.handSize() == 2){
                    return ComputerHelper.probabilityCalNegative(this.wiewDeck,this.getHand());
                }else {
                    return ComputerHelper.probabilityCal(this.wiewDeck,this.getHand());
                }
            }
        }

        return 0;
    }


}
